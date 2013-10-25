package it.sevenbits.conferences.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RulesController {

    @RequestMapping(value = "/rules", method = RequestMethod.GET)
    public ModelAndView showRules() {

        ModelAndView modelAndView = new ModelAndView("rules");
        return modelAndView;
    }
}
