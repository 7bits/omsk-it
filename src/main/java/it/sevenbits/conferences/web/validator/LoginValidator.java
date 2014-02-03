package it.sevenbits.conferences.web.validator;

import it.sevenbits.conferences.web.form.LoginForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *  Validator for login's form.
 */
@Component
public class LoginValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz){
        return LoginForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LoginForm form = (LoginForm) target;
        validateLogin(errors);
        validatePassword(errors);
    }

    private void validateLogin(Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "login.empty", "Логин не должен быть пустым");
    }

    private void validatePassword(Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty", "Пароль не должен быть пустым");
    }

}
