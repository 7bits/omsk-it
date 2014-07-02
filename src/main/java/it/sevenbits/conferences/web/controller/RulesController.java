package it.sevenbits.conferences.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import it.sevenbits.conferences.service.ConferenceService;

/**
 * Controller for /rules page.
 */
@Controller
public class RulesController {

    @Autowired
    private ConferenceService conferenceService;

    @RequestMapping(value = "/rules", method = RequestMethod.GET)
    public ModelAndView showRules() {

        ModelAndView modelAndView = new ModelAndView("rules");
        modelAndView.addObject("companies", conferenceService.findAllCompany());

        return modelAndView;
    }
}
