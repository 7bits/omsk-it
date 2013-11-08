package it.sevenbits.conferences.web.validator;

import it.sevenbits.conferences.service.SubscriptionService;
import it.sevenbits.conferences.web.form.SubscriptionForm;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Validator for subscription form.
 */
@Component
public class SubscriptionValidator implements Validator {

    @Autowired
    private SubscriptionService subscriptionService;

    @Override
    public boolean supports(Class<?> clazz) {

        return SubscriptionForm.class.equals(clazz);
    }

    /**
     * Validates all fields of Subscription form.
     * @param target Subscription form.
     * @param errors errors holder
     */
    @Override
    public void validate(Object target, Errors errors) {

        validateEmail(target, errors);
    }

    /**
     * Validates only one field of Subscription form - "email" field.
     * Returns immediately after an error has been found.
     * @param target Subscription form.
     * @param errors errors holder.
     */
    private void validateEmail(Object target, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.empty", "Поле должно быть заполнено.");
        if (errors.hasErrors()) {
            return;
        }

        SubscriptionForm subscriptionForm = (SubscriptionForm) target;

        if (!EmailValidator.getInstance().isValid(subscriptionForm.getEmail())) {
            errors.rejectValue("email", "email.notValid", "Некорректный email.");
            return;
        }
        if (!isUniqueEmail(subscriptionForm.getEmail())) {
            errors.rejectValue("email", "email.alreadyExists", "Такой email уже существует.");
        }
    }

    /**
     * Checks if the email already exists in the database.
     * @param email email to check.
     * @return true, if it's new email, false in other case.
     */
    private boolean isUniqueEmail(final String email) {

        return (subscriptionService.findSubscriptionByEmail(email) == null);
    }
}
