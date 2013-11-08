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

    private final static ConferenceComparator CONFERENCE_COMPARATOR = new ConferenceComparator();

    @Autowired
    private ConferenceService conferenceService;

    @Autowired
    private ReportService reportService;

    @RequestMapping(value = "/archive", method = RequestMethod.GET)
    public ModelAndView showArchive() {

        ModelAndView modelAndView = new ModelAndView("archive");

        List<Conference> conferences = conferenceService.findAllConferences();
        Collections.sort(conferences, Collections.reverseOrder(CONFERENCE_COMPARATOR));
        modelAndView.addObject("conferences", conferences);
        modelAndView.addObject("reports", reportService.findAllReports());

        return modelAndView;
    }
}
