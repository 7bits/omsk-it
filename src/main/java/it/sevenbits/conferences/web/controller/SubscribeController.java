package it.sevenbits.conferences.web.controller;

import it.sevenbits.conferences.domain.Subscription;
import it.sevenbits.conferences.service.SubscriptionService;
import it.sevenbits.conferences.web.form.JsonResponse;
import it.sevenbits.conferences.web.form.SubscriptionForm;
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
 * Controller for subscription.
 */
@Controller
public class SubscribeController {

    @Autowired
    private SubscriptionService subscriptionService;

    @Autowired
    @Qualifier("subscriptionValidator")
    private Validator validator;

    @RequestMapping(value = "/subscribe", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse subscribe(@ModelAttribute(value = "subscriptionForm") SubscriptionForm subscriptionForm, BindingResult bindingResult) {

        JsonResponse response = new JsonResponse();
        validator.validate(subscriptionForm, bindingResult);

        if (bindingResult.hasErrors()) {

            response.setStatus("FAIL");
            Map<String, String> errors = new HashMap<>();
            for (FieldError fieldError: bindingResult.getFieldErrors()) {
                if (!errors.containsKey(fieldError.getField())) {
                    errors.put(fieldError.getField(), fieldError.getDefaultMessage());
                }
            }
            response.setResult(errors);
        } else {

            Subscription subscription = new Subscription();
            subscription.setEmail(subscriptionForm.getEmail());
            subscriptionService.addSubscription(subscription);
            response.setStatus("SUCCESS");
            response.setResult(Collections.singletonMap("message", "Подписка на " + subscription.getEmail() + " прошла успешно."));
        }

        return response;
    }
}
