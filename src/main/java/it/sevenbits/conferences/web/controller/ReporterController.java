package it.sevenbits.conferences.web.controller;

import it.sevenbits.conferences.domain.Reporter;
import it.sevenbits.conferences.service.ReportService;
import it.sevenbits.conferences.service.ReporterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for /reporter/{id} page.
 */
@Controller
public class ReporterController {

    @Autowired
    private ReporterService reporterService;

    @Autowired
    private ReportService reportService;

    @RequestMapping(value = "/reporter/{reporterId}", method = RequestMethod.GET)
    public ModelAndView showReporter(@PathVariable(value = "reporterId") String reporterId) {

        ModelAndView modelAndView = new ModelAndView("reporter");

        Reporter reporter = reporterService.findReporterById(Long.parseLong(reporterId));
        modelAndView.addObject("reporter", reporter);
        modelAndView.addObject("reports", reportService.findAllReportsByReporter(reporter));

        return modelAndView;
    }
}
