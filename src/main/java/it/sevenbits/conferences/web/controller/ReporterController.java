package it.sevenbits.conferences.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReporterController {

    @RequestMapping(value = "/reporter/{reporterId}", method = RequestMethod.GET)
    public ModelAndView showReporter(@PathVariable(value = "reporterId") String reporterId) {

        ModelAndView modelAndView = new ModelAndView("reporter");
        return modelAndView;
    }
}
