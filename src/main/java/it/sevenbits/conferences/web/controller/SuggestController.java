package it.sevenbits.conferences.web.controller;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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

import it.sevenbits.conferences.domain.Suggestion;
import it.sevenbits.conferences.service.SuggestionService;
import it.sevenbits.conferences.web.form.JsonResponse;
import it.sevenbits.conferences.web.form.SuggestionForm;

/**
 *  Controller for /suggest page
 */
@Controller
public class SuggestController {

    @Autowired
    private SuggestionService suggestionService;

    @Autowired
    @Qualifier("suggestionValidator")
    private Validator validator;

    @RequestMapping(value = "/suggest", method = RequestMethod.GET)
    public ModelAndView showForm() {

        return new ModelAndView("suggest", "suggestionForm", new SuggestionForm());
    }

    @RequestMapping(value = "/suggest", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse submitForm(
            @ModelAttribute(value = "suggestionForm") final SuggestionForm suggestionForm,
            final BindingResult bindingResult
    ) {

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

            Suggestion suggestion = new Suggestion();
            int i = 0;

            StringBuilder senderSpecialization = new StringBuilder();
            for (String field: suggestionForm.getSenderSpecialization()) {
                if (field.equals("other")) {
                    senderSpecialization.append(suggestionForm.getSenderSpecializationOther());
                } else {
                    senderSpecialization.append(field);
                }
                senderSpecialization.append(", ");
                i++;
            }

            StringBuilder favoriteTheme = new StringBuilder();
            i = 0;
            for (String field: suggestionForm.getFavoriteTheme()) {
                if (field.equals("other")) {
                    favoriteTheme.append(suggestionForm.getFavoriteThemeOther());
                } else {
                    favoriteTheme.append(field);
                }
                favoriteTheme.append(", ");
                i++;
            }

            suggestion.setSenderSpecialization(senderSpecialization.toString());
            suggestion.setFavoriteTheme(favoriteTheme.toString());
            suggestion.setThemeRequest(suggestionForm.getThemeRequest());
            suggestion.setReporterRequest(suggestionForm.getReporterRequest());

            suggestionService.addSuggestion(suggestion);

            response.setStatus("SUCCESS");
            response.setResult(Collections.singletonMap("message", "Предложение принято."));
        }

        return response;
    }
}
