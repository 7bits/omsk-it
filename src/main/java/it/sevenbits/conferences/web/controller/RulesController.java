package it.sevenbits.conferences.web.controller;

import it.sevenbits.conferences.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RulesController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/rules", method = RequestMethod.GET)
    public ModelAndView showRules() {

        ModelAndView modelAndView = new ModelAndView("rules");
        modelAndView.addObject("companies", companyService.findAllCompanies());

        return modelAndView;
    }
}
