package it.sevenbits.conferences.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it.sevenbits.conferences.domain.Company;
import it.sevenbits.conferences.service.CompanyService;
import it.sevenbits.conferences.web.form.CompanyAddForm;
import it.sevenbits.conferences.web.form.JsonResponse;

/**
 * Controller for company's requests.
 */
@Controller
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    @Qualifier("companyValidator")
    private Validator companyValidator;

    @RequestMapping(value = "/company/getCompanies", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse getAllCompanies() {
        JsonResponse jsonResponse = new JsonResponse();
        List<String> companiesNames = new ArrayList<>();
        List<Company> companies = new ArrayList<>();
        companies = companyService.findAllCompanies();
        for (Company company : companies) {
            companiesNames.add(company.getName());
        }
        jsonResponse.setResult(companiesNames);
        jsonResponse.setStatus(JsonResponse.STATUS_SUCCESS);
        return jsonResponse;
    }

    @RequestMapping(value = "/company/new", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse addNewCompany(
            @ModelAttribute(value = "companyAddForm") final CompanyAddForm companyAddForm,
            final BindingResult bindingResult
    ) {
        companyValidator.validate(companyAddForm, bindingResult);
        JsonResponse response = new JsonResponse();
        if (bindingResult.hasErrors()) {
            response.setStatus(JsonResponse.STATUS_FAIL);
            Map<String, String> errors = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                if (!errors.containsKey(fieldError.getField())) {
                    errors.put(fieldError.getField(), fieldError.getDefaultMessage());
                }
            }
            errors.put("message", "Форма заполнена неверно");
            response.setResult(errors);
        } else {
            Company company = new Company();
            company.setName(companyAddForm.getName());
            company.setSite(companyAddForm.getSite());
            companyService.addCompany(company);
            response.setStatus(JsonResponse.STATUS_SUCCESS);
        }
        return response;
    }
}
