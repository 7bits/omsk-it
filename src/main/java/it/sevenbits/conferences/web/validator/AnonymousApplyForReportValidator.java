package it.sevenbits.conferences.web.validator;

import it.sevenbits.conferences.service.CompanyService;
import it.sevenbits.conferences.service.UserService;
import it.sevenbits.conferences.web.form.ApplyForReportForm;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Validator for anonymous apply-for-report form.
 */
@Component
public class AnonymousApplyForReportValidator implements Validator {

    @Autowired
    private UserService userService;

    @Autowired
    private CompanyService companyService;

    @Override
    public boolean supports(final Class<?> clazz) {

        return ApplyForReportForm.class.equals(clazz);
    }

    @Override
    public void validate(final Object target, final Errors errors) {

        ApplyForReportForm form = (ApplyForReportForm) target;

        validateFirstName(form, errors);
        validateSecondName(form, errors);
        validateEmail(form, errors);
        validatePassword(form, errors);
        validateJobPosition(form, errors);
        validateTitle(form, errors);
        validateDescription(form, errors);
        validateKeyTechnologies(form, errors);
        validateOtherConferences(form, errors);
        validateSpeechExperience(form, errors);
        validateReporterWishes(form, errors);
        validateCompany(form, errors);
    }

    private void validateFirstName(final ApplyForReportForm form, final Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.empty", "Заполните, пожалуйста, Ваше имя");
    }

    private void validateSecondName(final ApplyForReportForm form, final Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "secondName", "secondName.empty", "Заполните, пожалуйста, Вашу фамилию");
    }

    private void validateEmail(final ApplyForReportForm form, final Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.empty", "Заполните, пожалуйста, Ваш E-mail");
        if (errors.getFieldErrorCount("email") != 0) {
            return;
        }
        if (!EmailValidator.getInstance().isValid(form.getEmail())) {
            errors.rejectValue("email", "email.notValid", "Некорректный email.");
        }
        if (isUserExists(form.getEmail())) {
            errors.rejectValue("email", "email.alreadyExists", "Такой email уже существует.");
        }
    }

    private void validatePassword(final ApplyForReportForm form, final Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty", "Пароль не должен быть пустым");
    }

    private void validateJobPosition(final ApplyForReportForm form, final Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobPosition", "jobPosition.empty", "Укажите, пожалуйста, Вашу роль в компании/команде");
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
    private void validateCompany(final ApplyForReportForm form, final Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "company", "company.empty", "Поле должно быть заполнено.");
        String companyName = form.getCompany();
        if (!isCompanyExists(companyName)) {
            errors.rejectValue("company", "company.notExists", "Такой компании не существует.");
        }
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

    private boolean isUserExists(final String email) {
        try {
            userService.findUserByEmail(email);
        } catch (UsernameNotFoundException e) {
            return false;
        }
        return true;
    }

    private boolean isCompanyExists(final String companyName) {
        if (companyService.findCompanyByName(companyName) != null) {
            return true;
        }
        return false;
    }
}
