package it.sevenbits.conferences.web.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.sevenbits.conferences.web.form.SuggestionForm;

/**
 *  Validator for suggestion form
 */
@Component
public class SuggestionValidator implements Validator {

    @Override
    public boolean supports(final Class<?> clazz) {

        return SuggestionForm.class.equals(clazz);
    }

    @Override
    public void validate(final Object target, final Errors errors) {

        SuggestionForm form = (SuggestionForm) target;

        validateSenderSpecialization(form, errors);
        validateFavoriteTheme(form, errors);
//        validateThemeRequest(form, errors);
//        validateReporterRequest(form, errors);
    }

    private void validateSenderSpecialization(final SuggestionForm form, final Errors errors) {

        ValidationUtils.rejectIfEmpty(errors, "senderSpecialization", "senderSpecialization.empty", "Надо что-то выбрать");
        if (errors.getFieldErrorCount("senderSpecialization") == 0) {
            for (String field: form.getSenderSpecialization()) {
                if (field.equals("other")) {
                    ValidationUtils.rejectIfEmptyOrWhitespace(
                            errors,
                            "senderSpecializationOther",
                            "senderSpecializationOther.empty",
                            "Поле не должно быть пустым"
                    );
                }
            }
        }
    }

    private void validateFavoriteTheme(final SuggestionForm form, final Errors errors) {

        ValidationUtils.rejectIfEmpty(errors, "favoriteTheme", "favoriteTheme.empty", "Надо что-то выбрать");
        if (errors.getFieldErrorCount("favoriteTheme") == 0) {
            for (String field: form.getFavoriteTheme()) {
                if (field.equals("other")) {
                    ValidationUtils.rejectIfEmptyOrWhitespace(
                            errors,
                            "favoriteThemeOther",
                            "favoriteThemeOther.empty",
                            "Поле не должно быть пустым"
                    );
                }
            }
        }
    }

//    private void validateThemeRequest(SuggestionForm form, Errors errors) {
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "themeRequest", "themeRequest.empty", "Поле должно быть заполнено.");
//    }
}
