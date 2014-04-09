package it.sevenbits.conferences.web.controller;

import it.sevenbits.conferences.domain.Company;
import it.sevenbits.conferences.domain.Conference;
import it.sevenbits.conferences.domain.Guest;
import it.sevenbits.conferences.domain.Report;
import it.sevenbits.conferences.domain.Role;
import it.sevenbits.conferences.domain.User;
import it.sevenbits.conferences.service.CompanyService;
import it.sevenbits.conferences.service.ConferenceService;
import it.sevenbits.conferences.service.GuestService;
import it.sevenbits.conferences.service.ReportService;
import it.sevenbits.conferences.service.RoleService;
import it.sevenbits.conferences.service.UserService;
import it.sevenbits.conferences.service.common.CustomUserDetailsService;
import it.sevenbits.conferences.utils.file.FileConverter;
import it.sevenbits.conferences.utils.file.FileManager;
import it.sevenbits.conferences.utils.mail.MailSenderUtility;
import it.sevenbits.conferences.web.form.ChangePasswordForm;
import it.sevenbits.conferences.web.form.JsonResponse;
import it.sevenbits.conferences.web.form.LoginForm;
import it.sevenbits.conferences.web.form.UserRegistrationForm;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.util.*;

/**
 * Controller for /user pages.
 */
@Controller
@RequestMapping(value = "user")
public class UserController {

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
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    @Qualifier("userRegistrationValidator")
    private Validator userRegistrationValidator;

    @Autowired
    @Qualifier("loginValidator")
    private Validator loginValidator;

    @Autowired
    @Qualifier("changePasswordValidator")
    private Validator changePasswordValidator;

    private static final Logger LOGGER = Logger.getLogger(VkAuthorizationController.class);

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
                Conference currentConference = conferenceService.findNextConference();
                guest.setConference(currentConference);
                guestService.addGuest(guest);
                additionalRegistrationInfo = "Так же, вы зарегистрированы на текущий субботник.";
            }
            if (reportStatus != null) {
                Report report = reportService.findReportById(reportStatus);
                report.setUser(user);
                reportService.updateReport(report);
                additionalRegistrationInfo = "Ваша заявка на выступление принята на рассмотрение.";
            }
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
            userService.updateUser(user);
            mailSenderUtility.sendConfirmationToken(userRegistrationForm.getEmail(), confirmationToken);
            Map<String, String> result = new HashMap<>();
            result.put("message","На ваш email выслана ссылка для подтверждения");
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
            errors.put("message", "Логин или пароль введены неверно");
            response.setResult(errors);
        } else {
            try {
                UserDetails userDetails = customUserDetailsService.loadUserByUsername(loginForm.getLogin());
                if (userDetails == null || !isPasswordValid(loginForm.getPassword(), userDetails)) {
                    Map<String, String> errors = new HashMap<>();
                    errors.put("message", "Логин или пароль введены неверно");
                    response.setResult(errors);
                    response.setStatus(JsonResponse.STATUS_FAIL);
                } else {
                    Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
                    SecurityContext securityContext = SecurityContextHolder.getContext();
                    securityContext.setAuthentication(authentication);
                    response.setStatus(JsonResponse.STATUS_SUCCESS);
                }
            } catch (Exception e) {
                Map<String, String> errors = new HashMap<>();
                errors.put("message", "Логин или пароль введены неверно");
                response.setResult(errors);
                response.setStatus(JsonResponse.STATUS_FAIL);
            }
        }
        return response;
    }

    private boolean isPasswordValid(final String password, final UserDetails userDetails) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(password, userDetails.getPassword());
    }

    @RequestMapping(value = "/login/failed", method = RequestMethod.GET)
    public ModelAndView loginFailed() {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("error", "true");
        return modelAndView;
    }

    @RequestMapping(value = "/change-password", method = RequestMethod.GET)
    public ModelAndView changePasswordGet() {
        return new ModelAndView("change-password");
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
            resultMessage.put("message", "Вам пароль успешно изменен.");
            jsonResponse.setResult(resultMessage);
        }
        return jsonResponse;
    }

    @RequestMapping(value = "/upload/photo", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse fileUpload(MultipartHttpServletRequest request, HttpSession httpSession) {
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

    private String setNewRandomPassword(User user, final int length) {
        String newPassword = RandomStringUtils.random(length, true, true);
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedNewPassword = encoder.encode(newPassword);
        user.setPassword(encodedNewPassword);
        userService.updateUser(user);
        return newPassword;
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
