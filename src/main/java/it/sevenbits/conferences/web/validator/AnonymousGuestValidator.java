package it.sevenbits.conferences.web.validator;

import it.sevenbits.conferences.service.CompanyService;
import it.sevenbits.conferences.service.UserService;
import it.sevenbits.conferences.web.form.AnonymousGuestForm;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

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
    public boolean supports(Class<?> clazz){
        return AnonymousGuestForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AnonymousGuestForm form = (AnonymousGuestForm) target;
        validateFirstName(errors);
        validateSecondName(errors);
        validateEmail(form, errors);
        validateJobPosition(form, errors);
        validatePassword(errors);
        validateCompany(form, errors);
    }

    private void validatePassword(Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty", "Пароль не должен быть пустым");
    }

    private void validateFirstName(Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.empty", "Заполните, пожалуйста, Ваше Имя");
    }

    private void validateSecondName(Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "secondName", "secondName.empty", "Заполните, пожалуйста, Вашу Фамилию");
    }

    private void validateEmail(AnonymousGuestForm form, Errors errors) {
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

    private void validateJobPosition(AnonymousGuestForm form, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "jobPosition", "jobPosition.empty", "Укажите, пожалуйста, Вашу роль в компании/команде");
        if (errors.getFieldErrorCount("jobPosition") == 0) {
            if (form.getJobPosition().equals("other")) {
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobPositionOther", "jobPositionOther.empty", "Заполните, пожалуйста, Вашу роль в компании/команде");
            }
        }
    }

    private void validateCompany(AnonymousGuestForm form, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "company", "company.empty", "Поле должно быть заполнено.");
        String companyName = form.getCompany();
        if (!isCompanyExists(companyName)) {
            errors.rejectValue("company", "company.notExists", "Такой компании не существует.");
        }
    }

    private boolean isUserExists(final String email) {
        if (userService.getUserByEmail(email) != null) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isCompanyExists(final String companyName) {
        if (companyService.findCompanyByName(companyName) != null) {
            return true;
        } else {
            return false;
        }
    }
}
