package it.sevenbits.conferences.web.validator;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.sevenbits.conferences.service.CompanyService;
import it.sevenbits.conferences.service.UserService;
import it.sevenbits.conferences.web.form.AnonymousGuestForm;

/**
 *  Validator for guest's form.
 */
@Component
public class AnonymousGuestValidator implements Validator {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(final Class<?> clazz) {
        return AnonymousGuestForm.class.equals(clazz);
    }

    @Override
    public void validate(final Object target, final Errors errors) {
        AnonymousGuestForm form = (AnonymousGuestForm) target;
        validateFirstName(errors);
        validateSecondName(errors);
        validateEmail(form, errors);
        validateJobPosition(form, errors);
        validatePassword(errors);
        validateCompany(form, errors);
    }

    private void validatePassword(final Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty", "Пароль не должен быть пустым");
    }

    private void validateFirstName(final Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.empty", "Заполните, пожалуйста, Ваше Имя");
    }

    private void validateSecondName(final Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "secondName", "secondName.empty", "Заполните, пожалуйста, Вашу Фамилию");
    }

    private void validateEmail(final AnonymousGuestForm form, final Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.empty", "Заполните, пожалуйста, Ваш E-mail");
        if (errors.hasErrors()) {
            return;
        }
        if (!EmailValidator.getInstance().isValid(form.getEmail())) {
            errors.rejectValue("email", "email.empty", "Некорректный email.");
        }
        if (isUserExists(form.getEmail())) {
            errors.rejectValue("email", "email.alreadyExists", "Такой email уже существует.");
        }
    }

    private void validateJobPosition(final AnonymousGuestForm form, final Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "jobPosition", "jobPosition.empty", "Укажите, пожалуйста, Вашу роль в компании/команде");
        if (errors.getFieldErrorCount("jobPosition") == 0) {
            if (form.getJobPosition().equals("other")) {
                ValidationUtils.rejectIfEmptyOrWhitespace(
                        errors,
                        "jobPositionOther",
                        "jobPositionOther.empty",
                        "Заполните, пожалуйста, Вашу роль в компании/команде"
                );
            }
        }
    }

    private void validateCompany(final AnonymousGuestForm form, final Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "company", "company.empty", "Поле должно быть заполнено.");
        String companyName = form.getCompany();
        if (!isCompanyExists(companyName)) {
            errors.rejectValue("company", "company.notExists", "Такой компании не существует.");
        }
    }

    private boolean isUserExists(final String email) {
        if (userService.findUserByEmail(email) == null) {
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
