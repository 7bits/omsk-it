package it.sevenbits.conferences.web.validator;

import it.sevenbits.conferences.web.form.UserForm;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *  Validator for suggestion form
 */
@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz){

        return UserForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        UserForm form = (UserForm) target;

        validateFirstName(form, errors);
        validateSecondName(form, errors);
        validateEmail(form, errors);
        validateJobPosition(form, errors);
        validateLogin(form, errors);
        validatePassord(form, errors);
    }

    private void validateLogin(UserForm form, Errors errors) {


    }

    private void validatePassord(UserForm form, Errors errors) {

    }

    private void validateFirstName(UserForm form, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.empty", "Заполните, пожалуйста, Ваше Имя");
    }

    private void validateSecondName(UserForm form, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "secondName", "secondName.empty", "Заполните, пожалуйста, Вашу Фамилию");
    }

    private void validateEmail(UserForm form, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.empty", "Заполните, пожалуйста, Ваш E-mail");
        if (errors.hasErrors()) {
            return;
        }

        if (!EmailValidator.getInstance().isValid(form.getEmail())) {
            errors.rejectValue("email", "email.empty", "Некорректный email.");
        }
    }

    private void validateJob(UserForm form, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "job", "job.empty", "Заполните, пожалуйста, Ваше место работы\\учебы");
    }


    private void validateJobPosition(UserForm form, Errors errors) {

        ValidationUtils.rejectIfEmpty(errors, "jobPosition", "jobPosition.empty", "Укажите, пожалуйста, Вашу роль в компании/команде");
        if (errors.getFieldErrorCount("jobPosition") == 0) {
            if (form.getJobPosition().equals("other")) {
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobPositionOther", "jobPositionOther.empty", "Заполните, пожалуйста, Вашу роль в компании/команде");
            }
        }
    }
}
