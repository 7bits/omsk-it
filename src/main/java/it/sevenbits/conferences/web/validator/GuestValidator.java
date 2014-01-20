package it.sevenbits.conferences.web.validator;

import it.sevenbits.conferences.web.form.GuestForm;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *  Validator for guest's form.
 */
@Component
public class GuestValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz){
        return GuestForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        GuestForm form = (GuestForm) target;
        validateFirstName(errors);
        validateSecondName(errors);
        validateEmail(form, errors);
        validateJobPosition(form, errors);
        validatePassword(errors);
    }

    private void validatePassword(Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty", "Пароль не должен быть пустым");
    }

    private void validateFirstName(Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.empty", "Заполните, пожалуйста, Ваше Имя");
    }

    private void validateSecondName(Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "secondName", "secondName.empty", "Заполните, пожалуйста, Вашу Фамилию");
    }

    private void validateEmail(GuestForm form, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.empty", "Заполните, пожалуйста, Ваш E-mail");
        if (errors.hasErrors()) {
            return;
        }
        if (!EmailValidator.getInstance().isValid(form.getEmail())) {
            errors.rejectValue("email", "email.empty", "Некорректный email.");
        }
    }

    private void validateJobPosition(GuestForm form, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "jobPosition", "jobPosition.empty", "Укажите, пожалуйста, Вашу роль в компании/команде");
        if (errors.getFieldErrorCount("jobPosition") == 0) {
            if (form.getJobPosition().equals("other")) {
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobPositionOther", "jobPositionOther.empty", "Заполните, пожалуйста, Вашу роль в компании/команде");
            }
        }
    }
}
