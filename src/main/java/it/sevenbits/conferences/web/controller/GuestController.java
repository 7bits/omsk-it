package it.sevenbits.conferences.web.controller;

import it.sevenbits.conferences.domain.Conference;
import it.sevenbits.conferences.domain.Guest;
import it.sevenbits.conferences.domain.Role;
import it.sevenbits.conferences.domain.User;
import it.sevenbits.conferences.service.ConferenceService;
import it.sevenbits.conferences.service.GuestService;
import it.sevenbits.conferences.service.RoleService;
import it.sevenbits.conferences.service.UserService;
import it.sevenbits.conferences.utils.mail.MailSenderUtility;
import it.sevenbits.conferences.web.form.GuestForm;
import it.sevenbits.conferences.web.form.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 *  Controller for /reg page
 */
@Controller
public class GuestController {

    private final String ANONYMOUS_USER = "anonymousUser";

    @Autowired
    private ConferenceService conferenceService;
    @Autowired
    private GuestService guestService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;
    @Autowired
    private MailSenderUtility mailSenderUtility;
    @Autowired
    @Qualifier("guestValidator")
    private Validator validator;

    private boolean isAnonymousUser() {
        String authUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        boolean isAnonymous = authUser.equals(ANONYMOUS_USER);
        return  isAnonymous;
    }

    private boolean isUserIsGuestOnConference(String login, Long conference_id) {
        if (guestService.findGuestWithLoginAndConferenceLike(login,conference_id) != null) {
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
            Conference currentConference = conferenceService.findNextConference();
            if (!isUserIsGuestOnConference(userLogin,currentConference.getId())) {
                Guest guest = new Guest();
                User currentUser = userService.getUser(userLogin);
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
    public JsonResponse submitForm(@ModelAttribute (value = "guestForm") GuestForm guestForm, BindingResult bindingResult) {
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
            errors.put("message", "Форма заполнена не верно.");
            response.setResult(errors);
        } else {
            User user = new User();
            user.setFirstName(guestForm.getFirstName());
            user.setSecondName(guestForm.getSecondName());
            user.setEmail(guestForm.getEmail());
            user.setLogin(guestForm.getEmail());
            user.setPassword(guestForm.getPassword());
            user.setJobPosition(guestForm.getJobPosition());
            user.setEnabled(false);
            Role role = roleService.findRoleById(1l);
            user.setRole(role);
            String confirmation_token = UUID.randomUUID().toString();
            user.setConfirmationToken(confirmation_token);
            userService.updateUser(user);
            mailSenderUtility.sendConfirmationTokenAndConferenceStatus(guestForm.getEmail(), confirmation_token);
            response.setStatus(JsonResponse.STATUS_SUCCESS);
            response.setResult(Collections.singletonMap("message", "На ваш email послано письмо для подтверждения регистрации и участия."));
        }

        return response;
    }
}
