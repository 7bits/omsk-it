package it.sevenbits.conferences.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReportController {

    @RequestMapping(value = "/report/{reportId}", method = RequestMethod.GET)
    public ModelAndView showReport(@PathVariable(value = "reportId") String reportId) {

        ModelAndView modelAndView = new ModelAndView("report");
        return modelAndView;
    }
}
