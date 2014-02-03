package it.sevenbits.conferences.web.validator;

import it.sevenbits.conferences.service.ReportService;
import it.sevenbits.conferences.web.form.ApplyForReportForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Validator for apply-for-report form.
 */
@Component
public class UserApplyForReportValidator implements Validator {

    @Autowired
    private ReportService reportService;

    @Override
    public boolean supports(Class<?> clazz) {

        return ApplyForReportForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        ApplyForReportForm form = (ApplyForReportForm) target;

        validateTitle(form, errors);
        validateDescription(form, errors);
        validateKeyTechnologies(form, errors);
        validateOtherConferences(form, errors);
        validateSpeechExperience(form, errors);
        validateReporterWishes(form, errors);
    }

    private void validateTitle(ApplyForReportForm form, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "title.empty", "Поле должно быть заполнено.");
    }

    private void validateDescription(ApplyForReportForm form, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "description.empty", "Поле должно быть заполнено.");
    }

    private void validateKeyTechnologies(ApplyForReportForm form, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "keyTechnologies", "keyTechnologies.empty", "Поле должно быть заполнено.");
    }

    private void validateOtherConferences(ApplyForReportForm form, Errors errors) {

//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "otherConferences", "otherConferences.empty", "Поле должно быть заполнено.");
    }

    private void validateSpeechExperience(ApplyForReportForm form, Errors errors) {

//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "speechExperience", "speechExperience.empty", "Поле должно быть заполнено.");
    }

    private void validateReporterWishes(ApplyForReportForm form, Errors errors) {

//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "reporterWishes", "reporterWishes.empty", "Поле должно быть заполнено.");
    }
}
