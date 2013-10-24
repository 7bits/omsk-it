package it.sevenbits.conferences.web.controller;

import it.sevenbits.conferences.domain.Conference;
import it.sevenbits.conferences.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

    @Autowired
    private ConferenceService conferenceService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showIndex() {

        ModelAndView modelAndView = new ModelAndView("index");

        Conference conference = conferenceService.findNextConference();
        modelAndView.addObject("conference", conference);
        modelAndView.addObject("reports", conferenceService.findAllReportsByConference(conference));

        return modelAndView;
    }
}
