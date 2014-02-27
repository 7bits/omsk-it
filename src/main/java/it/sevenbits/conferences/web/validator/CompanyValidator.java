package it.sevenbits.conferences.web.validator;

import it.sevenbits.conferences.service.CompanyService;
import it.sevenbits.conferences.web.form.CompanyAddForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CompanyValidator implements Validator {

    @Autowired
    private CompanyService companyService;

    @Override
    public boolean supports(Class<?> aClass) {
        return CompanyAddForm.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CompanyAddForm companyAddForm = (CompanyAddForm) target;
        validateName(companyAddForm, errors);
    }

    private void validateName(CompanyAddForm companyAddForm, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty", "Введите, пожалуйста, название.");
        if (isCompanyExists(companyAddForm.getName())) {
            errors.rejectValue("name","name.alreadyExists","Такая компания уже существует.");
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
