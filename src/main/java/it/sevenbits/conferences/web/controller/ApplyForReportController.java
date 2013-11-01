package it.sevenbits.conferences.web.controller;

import it.sevenbits.conferences.web.form.JsonResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApplyForReportController {

    @RequestMapping(value = "/apply-for-report", method = RequestMethod.GET)
    public ModelAndView showForm() {

        ModelAndView modelAndView = new ModelAndView("apply-for-report");
        return modelAndView;
    }

    @RequestMapping(value = "/apply-for-report", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse submitForm() {

        return null;
    }
}
