package it.sevenbits.conferences.web.controller;

import it.sevenbits.conferences.domain.Conference;
import it.sevenbits.conferences.domain.Report;
import it.sevenbits.conferences.service.ConferenceService;
import it.sevenbits.conferences.service.ReportService;
import it.sevenbits.conferences.utils.file.FileManager;
import it.sevenbits.conferences.web.form.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static it.sevenbits.conferences.utils.date.NextDateConference.getNextDate;

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

        Conference conference = conferenceService.findNextConference();
        long today = System.currentTimeMillis() / 1000;

        if (conference.getDate() < today) {
            Conference newConference = new Conference();
            newConference.setDate(getNextDate(today));
            newConference.setOrdinalNumber(conference.getOrdinalNumber() + 1);
            conferenceService.addConference(newConference);
            conference = newConference;
        }

        List<Report> reports = reportService.findAllReportsByConference(conference);
        ModelAndView modelAndView;

        if (reports.isEmpty()) {
            modelAndView = new ModelAndView("index-after");
            Conference pastConference = conferenceService.findLastConference();
            modelAndView.addObject("pastConference", pastConference);
            modelAndView.addObject("reports", reportService.findAllReportsByConference(pastConference));
            modelAndView.addObject("conference", conference);
        } else {
            if (conference.isRegistration()) {
                modelAndView = new ModelAndView("index-reg");
            }   else {
                modelAndView = new ModelAndView("index-before");
            }
            modelAndView.addObject("conference", conference);
            modelAndView.addObject("reports", reportService.findAllReportsByConference(conference));
        }
        return modelAndView;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse fileUpload(MultipartHttpServletRequest request, HttpSession httpSession) {
        JsonResponse jsonResponse = new JsonResponse();
        Iterator<String> itr =  request.getFileNames();
        MultipartFile multipartFile = request.getFile(itr.next());
        FileManager fileManager = new FileManager();
        String photosName = fileManager.saveTemporaryPhoto(multipartFile);
        jsonResponse.setStatus(JsonResponse.STATUS_SUCCESS);
        Map<String, String> result = new HashMap<>();
        httpSession.setAttribute("photosName", photosName);
        result.put("name", photosName);
        jsonResponse.setResult(result);
        return jsonResponse;
    }
}
