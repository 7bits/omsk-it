package it.sevenbits.conferences.web.controller;

import it.sevenbits.conferences.domain.Conference;
import it.sevenbits.conferences.domain.Report;
import it.sevenbits.conferences.service.ConferenceService;
import it.sevenbits.conferences.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Controller for main page.
 */
@Controller
public class WelcomeController {
    @Autowired
    private ConferenceService conferenceService;

    @Autowired
    private ReportService reportService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showIndex() {
        ModelAndView modelAndView;
        Conference lastConferenceWithReports = conferenceService.findLastConferenceWithReports();
        List<Report> reports = reportService.findAllReportsByConference(lastConferenceWithReports);
        long today = System.currentTimeMillis() / 1000;

        if (lastConferenceWithReports.getDate() >= today) {
            if (lastConferenceWithReports.isRegistration()) {
                modelAndView = new ModelAndView("index-reg");
            } else {
                modelAndView = new ModelAndView("index-before");
            }
            modelAndView.addObject("reports", reports);
            modelAndView.addObject("nextConference", lastConferenceWithReports);
        } else {
            Conference lastConference = conferenceService.findLastConference();

            if (lastConference.getDate() >= today) {
                modelAndView = new ModelAndView("index-after");
                
                modelAndView.addObject("reports", reports);
                modelAndView.addObject("lastConference", lastConferenceWithReports);
            } else {
                if (lastConference == lastConferenceWithReports) {
                    modelAndView = new ModelAndView("index-after");

                    modelAndView.addObject("reports", reports);
                    modelAndView.addObject("lastConference", lastConferenceWithReports);
                } else {
                    if (lastConference.isRegistration()) {
                        modelAndView = new ModelAndView("index-reg");
                    } else {
                        modelAndView = new ModelAndView("index-after");
                    }
                }
                modelAndView.addObject("nextConference", lastConference);
            }
        }
        return modelAndView;
    }

}
