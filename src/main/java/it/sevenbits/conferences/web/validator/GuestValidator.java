package it.sevenbits.conferences.web.validator;

import it.sevenbits.conferences.web.form.GuestForm;
import org.apache.commons.validator.routines.EmailValidator;
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

        validateJob(form, errors);
    }

    private void validateJob(GuestForm form, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "job", "job.empty", "Заполните, пожалуйста, Ваше место работы\\учебы");
    }
}
