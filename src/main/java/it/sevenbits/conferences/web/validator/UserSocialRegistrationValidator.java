package it.sevenbits.conferences.web.validator;

import it.sevenbits.conferences.service.CompanyService;
import it.sevenbits.conferences.service.UserService;
import it.sevenbits.conferences.web.form.UserRegistrationForm;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *  Validator for users registration form
 */
@Component
public class UserSocialRegistrationValidator implements Validator {

    @Autowired
    private UserService userService;
    @Autowired
    private CompanyService companyService;

    @Override
    public boolean supports(final Class<?> clazz) {

        return UserRegistrationForm.class.equals(clazz);
    }

    @Override
    public void validate(final Object target, final Errors errors) {
        UserRegistrationForm form = (UserRegistrationForm) target;
        validateFirstName(errors);
        validateSecondName(errors);
        validateEmail(form, errors);
        validateJobPosition(form, errors);
        validateCompany(form, errors);
    }

    private void validateFirstName(final Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.empty", "Заполните, пожалуйста, Ваше Имя");
    }

    private void validateSecondName(final Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "secondName", "secondName.empty", "Заполните, пожалуйста, Вашу Фамилию");
    }

    private void validateEmail(final UserRegistrationForm form, final Errors errors) {
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

    private void validateCompany(final UserRegistrationForm form, final Errors errors) {
        if (!isCompanyExists(form.getCompany())) {
            errors.rejectValue("company", "company.notExists", "Такой компании не существует.");
        }
    }

    private void validateJobPosition(final UserRegistrationForm form, final Errors errors) {
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

    private boolean isUserExists(final String email) {
        if (userService.getUserByEmail(email) != null) {
            return true;
        }
        return false;
    }

    private boolean isCompanyExists(final String companyName) {
        if (companyService.findCompanyByName(companyName) != null) {
            return true;
        }
        return false;
    }
}
