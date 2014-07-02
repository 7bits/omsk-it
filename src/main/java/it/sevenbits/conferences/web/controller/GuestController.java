package it.sevenbits.conferences.web.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it.sevenbits.conferences.domain.*;
import it.sevenbits.conferences.service.*;
import it.sevenbits.conferences.utils.file.FileManager;
import it.sevenbits.conferences.utils.mail.MailSenderUtility;
import it.sevenbits.conferences.utils.mail.exception.MailSenderException;
import it.sevenbits.conferences.web.form.AnonymousGuestForm;
import it.sevenbits.conferences.web.form.JsonResponse;

/**
 *  Controller for /reg page
 */
@Controller
public class GuestController {

    private static final String ANONYMOUS_USER = "anonymousUser";

    @Autowired
    private ConferenceService conferenceService;

    @Autowired
    private GuestService guestService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private MailSenderUtility mailSenderUtility;

    @Autowired
    @Qualifier("anonymousGuestValidator")
    private Validator validator;

    private boolean isAnonymousUser() {
        String authUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        boolean isAnonymous = authUser.equals(ANONYMOUS_USER);
        return  isAnonymous;
    }

    private boolean isUserIsGuestOnConference(final String login, final Long conferenceId) {
        if (guestService.findGuestWithLoginAndConferenceLike(login, conferenceId) != null) {
            return true;
        }
        return false;
    }

    @RequestMapping(value = "/guest-check", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse checkGuest() {
        JsonResponse response = new JsonResponse();
        if (isAnonymousUser()) {
            response.setStatus(JsonResponse.STATUS_FAIL);
        } else {
            String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
            Conference currentConference = conferenceService.findLastConference();
            if (!isUserIsGuestOnConference(userLogin, currentConference.getId())) {
                Guest guest = new Guest();
                User currentUser = userService.findUser(userLogin);
                guest.setUser(currentUser);
                guest.setConference(currentConference);
                guestService.addGuest(guest);
            }
            response.setStatus(JsonResponse.STATUS_SUCCESS);
        }
        return response;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse submitForm(
            @ModelAttribute (value = "guestForm") final AnonymousGuestForm guestForm,
            final BindingResult bindingResult,
            final HttpSession httpSession
    ) {
        JsonResponse response = new JsonResponse();
        validator.validate(guestForm, bindingResult);
        if (bindingResult.hasErrors()) {
            response.setStatus("FAIL");
            Map<String, String> errors = new HashMap<>();
            for (FieldError fieldError: bindingResult.getFieldErrors()) {
                if (!errors.containsKey(fieldError.getField())) {
                    errors.put(fieldError.getField(), fieldError.getDefaultMessage());
                }
            }
            errors.put("message", "Форма заполнена неверно.");
            response.setResult(errors);
        } else {
            User user = new User();
            user.setFirstName(guestForm.getFirstName());
            user.setSecondName(guestForm.getSecondName());
            user.setEmail(guestForm.getEmail());
            user.setLogin(guestForm.getEmail());
            PasswordEncoder encoder = new BCryptPasswordEncoder();
            String encodedPassword = encoder.encode(guestForm.getPassword());
            user.setPassword(encodedPassword);
            user.setJobPosition(guestForm.getJobPosition());
            user.setEnabled(false);
            Company company = companyService.findCompanyByName(guestForm.getCompany());
            user.setCompany(company);
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
                mailSenderUtility.sendConfirmationTokenAndConferenceStatus(guestForm.getEmail(), confirmationToken);
            } catch (MailSenderException e) {
                Map<String, String> result = new HashMap<>();
                result.put("message", "Произошла ошибка на сервере, пожалуйста, повторите Ваши действия.");
                response.setResult(result);
                response.setStatus(JsonResponse.STATUS_FAIL);
                return response;
            }
            userService.updateUser(user);
            response.setStatus(JsonResponse.STATUS_SUCCESS);
            response.setResult(Collections.singletonMap("message", "На Ваш email послано письмо для подтверждения регистрации и участия."));
        }
        return response;
    }
}
