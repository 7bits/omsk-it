package it.sevenbits.conferences.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for /to-companies page.
 */
@Controller
public class ToCompaniesController {

    @RequestMapping(value = "/to-companies", method = RequestMethod.GET)
    public ModelAndView showToCompanies() {

        ModelAndView modelAndView = new ModelAndView("to-companies");
        return modelAndView;
    }
}
