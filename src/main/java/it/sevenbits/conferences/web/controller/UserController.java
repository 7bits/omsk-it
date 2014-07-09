package it.sevenbits.conferences.web.controller;

import java.awt.image.BufferedImage;
import java.util.*;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import it.sevenbits.conferences.domain.*;
import it.sevenbits.conferences.service.*;
import it.sevenbits.conferences.utils.file.FileConverter;
import it.sevenbits.conferences.utils.file.FileManager;
import it.sevenbits.conferences.utils.mail.MailSenderUtility;
import it.sevenbits.conferences.utils.mail.exception.MailSenderException;
import it.sevenbits.conferences.web.form.*;

/**
 * Controller for /user pages.
 */
@Controller
@RequestMapping(value = "user")
public class UserController {

    private static final Logger LOGGER = Logger.getLogger(VkAuthorizationController.class);
    private static final int DEFAULT_PASSWORD_LENGTH = 10;

    @Autowired
    private UserService userService;

    @Autowired
    private MailSenderUtility mailSenderUtility;

    @Autowired
    private RoleService roleService;

    @Autowired
    private ConferenceService conferenceService;

    @Autowired
    private GuestService guestService;

    @Autowired
    private ReportService reportService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private UserDetailsService customUserDetailsService;

    @Autowired
    @Qualifier("userRegistrationValidator")
    private Validator userRegistrationValidator;

    @Autowired
    @Qualifier("loginValidator")
    private Validator loginValidator;

    @Autowired
    @Qualifier("changePasswordValidator")
    private Validator changePasswordValidator;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ModelAndView getUserInformation(@PathVariable(value = "userId") final Long userId) {
        ModelAndView modelAndView = new ModelAndView("user-information");
        User user = userService.findUserById(userId);
        List<Report> reports = reportService.findAllPresentedReportsByUser(user);
        modelAndView.addObject("reports", reports);
        modelAndView.addObject("user", user);
        return  modelAndView;
    }

    @RequestMapping(value = "/confirmation", method = RequestMethod.GET)
    public ModelAndView confirmUser(
            @RequestParam(value = "confirmation_token", required = true) final String receivedConfirmationToken,
            @RequestParam(value = "confirmation_login", required = true) final String confirmationLogin,
            @RequestParam(value = "conference_status", required = false) final Long conferenceStatus,
            @RequestParam(value = "report_status", required = false) final Long reportStatus
    ) {
        String additionalRegistrationInfo = null;
        User user = userService.findUser(confirmationLogin);
        if (user != null || (user.getConfirmationToken().equals(receivedConfirmationToken) && !user.getEnabled())) {
            user.setEnabled(true);
            user = userService.updateUser(user);
            if (conferenceStatus != null && conferenceStatus == 1) {
                Guest guest = new Guest();
                guest.setUser(user);
                Conference currentConference = conferenceService.findLastConference();
                guest.setConference(currentConference);
                guestService.addGuest(guest);
                additionalRegistrationInfo = "Так же, Вы зарегистрированы на текущий субботник.";
            }
            if (reportStatus != null) {
                Report report = reportService.findReportById(reportStatus);
                report.setUser(user);
                reportService.updateReport(report);
                additionalRegistrationInfo = "Ваша заявка на выступление принята на рассмотрение.";
            }
            UserDetails userDetails;
            try {
                userDetails = customUserDetailsService.loadUserByUsername(user.getLogin());
            } catch (UsernameNotFoundException e) {
                return new ModelAndView("error-404");
            }
            authorizeUser(userDetails);
        }
        ModelAndView modelAndView = new ModelAndView("registration-confirm");
        modelAndView.addObject("additionalRegistrationInfo", additionalRegistrationInfo);
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView usersRegistrationPageGet() {
        ModelAndView modelAndView = new ModelAndView("user-registration");
        UserRegistrationForm userRegistrationForm = new UserRegistrationForm();
        modelAndView.addObject("userRegistrationForm", userRegistrationForm);
        return  modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse usersRegistrationPagePost(
            @ModelAttribute(value = "userRegistrationForm") final UserRegistrationForm userRegistrationForm,
            final BindingResult bindingResult,
            final HttpSession httpSession
    ) {
        JsonResponse jsonResponse = new JsonResponse();
        userRegistrationValidator.validate(userRegistrationForm, bindingResult);
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError fieldError: bindingResult.getFieldErrors()) {
                if (!errors.containsKey(fieldError.getField())) {
                    errors.put(fieldError.getField(), fieldError.getDefaultMessage());
                }
            }
            errors.put("message", "Форма заполнена неверно");
            jsonResponse.setResult(errors);
            jsonResponse.setStatus(JsonResponse.STATUS_FAIL);
        } else {
            User user = new User();
            user.setFirstName(userRegistrationForm.getFirstName());
            user.setSecondName(userRegistrationForm.getSecondName());
            user.setEmail(userRegistrationForm.getEmail());
            user.setLogin(userRegistrationForm.getEmail());
            PasswordEncoder encoder = new BCryptPasswordEncoder();
            String encodedPassword = encoder.encode(userRegistrationForm.getPassword());
            user.setPassword(encodedPassword);
            Company company = companyService.findCompanyByName(userRegistrationForm.getCompany());
            user.setCompany(company);
            user.setJobPosition(userRegistrationForm.getJobPosition());
            user.setEnabled(false);
            if (httpSession.getAttribute("photosName") != null) {
                FileManager fileManager = new FileManager();
                String photosName = httpSession.getAttribute("photosName").toString();
                boolean copyResult = fileManager.replaceFromTemporary(photosName);
                if (copyResult) {
                    user.setPhoto(photosName);
                } else {
                    user.setPhoto(null);
                }
                httpSession.setAttribute("photosName", null);
            } else {
                user.setPhoto(null);
            }
            //TODO: Kill this 3L hardcode
            Role role = roleService.findRoleById(3L);
            user.setRole(role);
            String confirmationToken = UUID.randomUUID().toString();
            user.setConfirmationToken(confirmationToken);
            try {
                mailSenderUtility.sendConfirmationToken(userRegistrationForm.getEmail(), confirmationToken);
            } catch (MailSenderException e) {
                LOGGER.error("Send mail error " + e);
                Map<String, String> result = new HashMap<>();
                result.put("message", "Произошла ошибка на сервере, пожалуйста, повторите Ваши действия.");
                jsonResponse.setResult(result);
                jsonResponse.setStatus(JsonResponse.STATUS_FAIL);
                return jsonResponse;
            }
            userService.updateUser(user);
            Map<String, String> result = new HashMap<>();
            result.put("message", "На Ваш email выслана ссылка для подтверждения");
            jsonResponse.setResult(result);
            jsonResponse.setStatus(JsonResponse.STATUS_SUCCESS);
        }
        return jsonResponse;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginGet() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse loginPost(
            @ModelAttribute(value = "loginForm") final LoginForm loginForm,
            final BindingResult bindingResult
    ) {
        JsonResponse response = new JsonResponse();
        loginValidator.validate(loginForm, bindingResult);
        if (bindingResult.hasErrors()) {
            response.setStatus(JsonResponse.STATUS_FAIL);
            Map<String, String> errors = new HashMap<>();
            for (FieldError fieldError: bindingResult.getFieldErrors()) {
                if (!errors.containsKey(fieldError.getField())) {
                    errors.put(fieldError.getField(), fieldError.getDefaultMessage());
                }
            }
            errors.put("base", "Логин или пароль введены неверно");
            response.setResult(errors);
        } else {
            UserDetails userDetails;
            try {
                userDetails = customUserDetailsService.loadUserByUsername(loginForm.getLogin());
            } catch (UsernameNotFoundException e) {
                Map<String, String> errors = new HashMap<>();
                errors.put("base", "Логин или пароль введены неверно");
                response.setResult(errors);
                response.setStatus(JsonResponse.STATUS_FAIL);
                return response;
            }
            if (!userDetails.isEnabled()) {
                Map<String, String> errors = new HashMap<>();
                errors.put("base", "Вам необходимо активировать Ваш аккаунт.");
                response.setResult(errors);
                response.setStatus(JsonResponse.STATUS_FAIL);
            } else if (!isPasswordValid(loginForm.getPassword(), userDetails)) {
                Map<String, String> errors = new HashMap<>();
                errors.put("base", "Логин или пароль введены неверно");
                response.setResult(errors);
                response.setStatus(JsonResponse.STATUS_FAIL);
            } else {
                authorizeUser(userDetails);
                response.setStatus(JsonResponse.STATUS_SUCCESS);
            }
        }
        return response;
    }

    private void authorizeUser(final UserDetails userDetails) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                userDetails, userDetails.getPassword(), userDetails.getAuthorities()
        );
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(authentication);
    }

    private boolean isPasswordValid(final String password, final UserDetails userDetails) {
        if (userDetails == null) {
            return false;
        }
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(password, userDetails.getPassword());
    }

    @RequestMapping(value = "/login/failed", method = RequestMethod.GET)
    public ModelAndView loginFailed() {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("error", "true");
        return modelAndView;
    }

    @RequestMapping(value = "/reset-password", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse changePasswordPost(@ModelAttribute final EmailForm emailForm) {
        JsonResponse jsonResponse = new JsonResponse();
        User user = userService.findUserByEmail(emailForm.getEmail());
        if (user == null) {
            jsonResponse.setStatus(JsonResponse.STATUS_FAIL);
            Map<String, String> resultMessage = new HashMap<>();
            resultMessage.put("base",  "Такого пользователя нету.");
            jsonResponse.setResult(resultMessage);
        } else {
            String newPassword = getNewRandomPassword(DEFAULT_PASSWORD_LENGTH);
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedNewPassword = passwordEncoder.encode(newPassword);
            user.setPassword(encodedNewPassword);
            try {
                mailSenderUtility.sendNewPassword(user.getEmail(), newPassword);
            } catch (MailSenderException e) {
                Map<String, String> result = new HashMap<>();
                result.put("base", "Произошла ошибка на сервере, пожалуйста, повторите Ваши действия.");
                jsonResponse.setResult(result);
                jsonResponse.setStatus(JsonResponse.STATUS_FAIL);
                return jsonResponse;
            }
            userService.updateUser(user);
            jsonResponse.setStatus(JsonResponse.STATUS_SUCCESS);
            Map<String, String> resultMessage = new HashMap<>();
            resultMessage.put("message", "Ваш пароль успешно изменен.");
            jsonResponse.setResult(resultMessage);
        }
        return jsonResponse;
    }

    @RequestMapping(value = "/change-password", method = RequestMethod.GET)
    public ModelAndView changePasswordGet(@RequestParam(value = "email", required = false) final String email) {
        ModelAndView modelAndView = new ModelAndView("change-password");
        modelAndView.addObject("email", email);
        return modelAndView;
    }

    @RequestMapping(value = "/change-password", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse changePasswordPost(
            @ModelAttribute(value = "ChangePasswordForm") final ChangePasswordForm changePasswordForm,
            final BindingResult bindingResult
    ) {
        JsonResponse jsonResponse;
        changePasswordValidator.validate(changePasswordForm, bindingResult);
        if (bindingResult.hasErrors()) {
            jsonResponse = getFailureResponse(bindingResult, "Неверный e-mail или пароль.");
        } else {
            User user = userService.findUserByEmail(changePasswordForm.getEmail());
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedNewPassword = passwordEncoder.encode(changePasswordForm.getNewPassword());
            user.setPassword(encodedNewPassword);
            userService.updateUser(user);
            jsonResponse = new JsonResponse();
            jsonResponse.setStatus(JsonResponse.STATUS_SUCCESS);
            Map<String, String> resultMessage = new HashMap<>();
            resultMessage.put("message", "Ваш пароль успешно изменен.");
            jsonResponse.setResult(resultMessage);
        }
        return jsonResponse;
    }

    @RequestMapping(value = "/upload/photo", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse fileUpload(final MultipartHttpServletRequest request, final HttpSession httpSession) {
        JsonResponse jsonResponse = new JsonResponse();
        Iterator<String> itr =  request.getFileNames();
        MultipartFile multipartFile = request.getFile(itr.next());
        FileManager fileManager = new FileManager();
        BufferedImage userPhoto = FileConverter.MultipartToBufferedImage(multipartFile);
        String photosName = fileManager.saveTemporaryPhoto(userPhoto);
        jsonResponse.setStatus(JsonResponse.STATUS_SUCCESS);
        Map<String, String> result = new HashMap<>();
        httpSession.setAttribute("photosName", photosName);
        result.put("name", photosName);
        jsonResponse.setResult(result);
        return jsonResponse;
    }

    private String getNewRandomPassword(final int length) {
        return RandomStringUtils.random(length, true, true);
    }

    private JsonResponse getFailureResponse(final BindingResult bindingResult, final String commonMessage) {
        JsonResponse response = new JsonResponse();
        response.setStatus(JsonResponse.STATUS_FAIL);
        Map<String, String> errors = new HashMap<>();
        for (FieldError fieldError: bindingResult.getFieldErrors()) {
            if (!errors.containsKey(fieldError.getField())) {
                errors.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
        }
        errors.put("message", commonMessage);
        response.setResult(errors);
        return response;
    }
}
