package it.sevenbits.conferences.web.validator;

import it.sevenbits.conferences.service.ReportService;
import it.sevenbits.conferences.service.ReporterService;
import it.sevenbits.conferences.web.form.GuestForm;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *  Validator for suggestion form
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

        validateFirstName(form, errors);
        validateSecondName(form, errors);
        validateEmail(form, errors);
        validateJob(form, errors);
        validateJobPosition(form, errors);
    }

    private void validateFirstName(GuestForm form, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.empty", "Заполните, пожалуйста, Ваше Имя");
    }

    private void validateSecondName(GuestForm form, Errors errors) {

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

    private void validateJob(GuestForm form, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "job", "job.empty", "Заполните, пожалуйста, Ваше место работы\\учебы");
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
