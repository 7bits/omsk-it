package it.sevenbits.conferences.web.controller;


import it.sevenbits.conferences.web.form.JsonResponse;
import it.sevenbits.conferences.web.form.SuggestionForm;
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
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *  Controller for /suggest page
 */
@Controller
public class SuggestController {

    @Autowired
    @Qualifier("suggestionValidator")
    private Validator validator;

    @RequestMapping(value = "/suggest", method = RequestMethod.GET)
    public ModelAndView showForm() {

        ModelAndView modelAndView = new ModelAndView("suggest");
        return modelAndView;
    }

    @RequestMapping(value = "/suggest", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse submitForm(@ModelAttribute(value = "suggestionForm") SuggestionForm suggestionForm, BindingResult bindingResult) {

        JsonResponse response = new JsonResponse();
        validator.validate(suggestionForm, bindingResult);

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

            // todo - form data save
            response.setStatus("SUCCESS");
            response.setResult(Collections.singletonMap("message", "Предложение принято."));
        }

        return response;
    }
}
