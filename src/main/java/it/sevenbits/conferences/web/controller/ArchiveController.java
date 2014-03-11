package it.sevenbits.conferences.web.controller;

import it.sevenbits.conferences.domain.Conference;
import it.sevenbits.conferences.service.ConferenceService;
import it.sevenbits.conferences.service.ReportService;
import it.sevenbits.conferences.utils.comparator.ConferenceComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

/**
 * Controller for /archive page.
 */
@Controller
public class ArchiveController {

    private static final ConferenceComparator CONFERENCE_COMPARATOR = new ConferenceComparator();

    @Autowired
    private ConferenceService conferenceService;

    @Autowired
    private ReportService reportService;

    @RequestMapping(value = "/archive", method = RequestMethod.GET)
    public ModelAndView showArchive() {

        ModelAndView modelAndView = new ModelAndView("archive");

        List<Conference> pastConferences = conferenceService.findPastConference();
//        List<Conference> pastConferences = conferenceService.findAllConferences();
        Collections.sort(pastConferences, Collections.reverseOrder(CONFERENCE_COMPARATOR));
        modelAndView.addObject("conferences", pastConferences);
        modelAndView.addObject("reports", reportService.findAllReports());

        return modelAndView;
    }
}
