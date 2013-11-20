package it.sevenbits.conferences.web.controller;

import it.sevenbits.conferences.domain.Guest;
import it.sevenbits.conferences.service.ConferenceService;
import it.sevenbits.conferences.service.GuestService;
import it.sevenbits.conferences.web.form.GuestForm;
import it.sevenbits.conferences.web.form.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

/**
 *  Controller for /reg page
 */
@Controller
public class GuestController {

    @Autowired
    private ConferenceService conferenceService;

    @Autowired
    private GuestService guestService;

    @Autowired
    @Qualifier("guestValidator")
    private Validator validator;

//    @RequestMapping(value = "/register", method = RequestMethod.GET)
//    public ModelAndView showForm() {
//
//        ModelAndView modelAndView = new ModelAndView("register", "guestForm", new GuestForm());
//        return modelAndView;
//    }

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

            Guest guest = new Guest();

            guest.setConference(conferenceService.findNextConference());
            guest.setFirstName(guestForm.getFirstName());
            guest.setSecondName(guestForm.getSecondName());
            guest.setEmail(guestForm.getEmail());
            guest.setJob(guestForm.getJob());

            if (guestForm.getJobPosition().equals("other")) {
                guest.setJobPosition(guestForm.getJobPositionOther());
            } else {
                guest.setJobPosition(guestForm.getJobPosition());
            }

            guestService.addGuest(guest);

            response.setStatus("SUCCESS");
            response.setResult(Collections.singletonMap("message", "Вы зарегистрированы"));
        }

        return response;
    }
}