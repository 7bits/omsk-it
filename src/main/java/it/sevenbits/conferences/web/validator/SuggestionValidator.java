package it.sevenbits.conferences.web.validator;


import it.sevenbits.conferences.service.ReportService;
import it.sevenbits.conferences.service.ReporterService;
import it.sevenbits.conferences.web.form.ApplyForReportForm;
import it.sevenbits.conferences.web.form.SuggestionForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *  Validator for suggestion form
 */
@Component
public class SuggestionValidator implements Validator {

    @Autowired
    private ReportService reportService;

    @Autowired
    private ReporterService reporterService;

    @Override
    public boolean supports(Class<?> clazz) {

        return SuggestionForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        SuggestionForm form = (SuggestionForm) target;

        validateSenderSpecialization(form, errors);
        validateFavoriteTheme(form, errors);
        validateThemeRequest(form, errors);
//        validateReporterRequest(form, errors);
    }

    private void validateSenderSpecialization(SuggestionForm form, Errors errors) {

        ValidationUtils.rejectIfEmpty(errors, "senderSpecialization", "senderSpecialization.empty", "Надо что то выбрать");
        if (errors.getFieldErrorCount("senderSpecialization") == 0) {
            if (form.getSenderSpecialization().equals("other")) {
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "senderSpecializationOther", "senderSpecializationOther.empty", "Поле не должно быть пустым");
            }
        }
    }

    private void validateFavoriteTheme(SuggestionForm form, Errors errors) {

        ValidationUtils.rejectIfEmpty(errors, "favoriteTheme", "favoriteTheme.empty", "Надо что то выбрать");
        if (errors.getFieldErrorCount("favoriteTheme") == 0) {
            for (String field: form.getFavoriteTheme()) {
                if (field.equals("other")) {
                    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "favoriteThemeOther", "favoriteThemeOther.empty", "Поле не должно быть пустым");
                }
            }
        }
    }

    private void validateThemeRequest(SuggestionForm form, Errors errors) {

//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "themeRequest", "themeRequest.empty", "Поле должно быть заполнено.");
    }
}

