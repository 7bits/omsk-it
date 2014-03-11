package it.sevenbits.conferences.web.validator;

import it.sevenbits.conferences.web.form.ApplyForReportForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Validator for apply-for-report form.
 */
@Component
public class UserApplyForReportValidator implements Validator {

    @Override
    public boolean supports(final Class<?> clazz) {

        return ApplyForReportForm.class.equals(clazz);
    }

    @Override
    public void validate(final Object target, final Errors errors) {

        ApplyForReportForm form = (ApplyForReportForm) target;

        validateTitle(form, errors);
        validateDescription(form, errors);
        validateKeyTechnologies(form, errors);
        validateOtherConferences(form, errors);
        validateSpeechExperience(form, errors);
        validateReporterWishes(form, errors);
    }

    private void validateTitle(final ApplyForReportForm form, final Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "title.empty", "Поле должно быть заполнено.");
    }

    private void validateDescription(final ApplyForReportForm form, final Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "description.empty", "Поле должно быть заполнено.");
    }

    private void validateKeyTechnologies(final ApplyForReportForm form, final Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "keyTechnologies", "keyTechnologies.empty", "Поле должно быть заполнено.");
    }

    private void validateOtherConferences(final ApplyForReportForm form, final Errors errors) {

//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "otherConferences", "otherConferences.empty", "Поле должно быть заполнено.");
    }

    private void validateSpeechExperience(final ApplyForReportForm form, final Errors errors) {

//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "speechExperience", "speechExperience.empty", "Поле должно быть заполнено.");
    }

    private void validateReporterWishes(final ApplyForReportForm form, final Errors errors) {

//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "reporterWishes", "reporterWishes.empty", "Поле должно быть заполнено.");
    }
}
