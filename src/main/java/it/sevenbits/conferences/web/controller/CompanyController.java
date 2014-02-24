package it.sevenbits.conferences.web.controller;

import it.sevenbits.conferences.domain.Company;
import it.sevenbits.conferences.service.CompanyService;
import it.sevenbits.conferences.web.form.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller for company's requests.
 */
@Controller
public class CompanyController {

    @Autowired
    private CompanyService companyService;

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
}
