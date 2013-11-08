package it.sevenbits.conferences.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for /to-reporters page.
 */
@Controller
public class ToReportersController {

    @RequestMapping(value = "/to-reporters", method = RequestMethod.GET)
    public ModelAndView showToReporters() {

        ModelAndView modelAndView = new ModelAndView("to-reporters");
        return modelAndView;
    }
}
