package it.sevenbits.conferences.web.controller.newController;


import it.sevenbits.conferences.model.Conference;
import it.sevenbits.conferences.service.exception.ServiceException;
import it.sevenbits.conferences.service.newService.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for main page.
 */
@Controller
public class WelcomeController {
    @Autowired
    private ConferenceService conferenceService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showIndex() throws ServiceException {
        long today = System.currentTimeMillis() / 1000;
        ModelAndView modelAndView;
        Conference nextConference = conferenceService.findLast();

        if (nextConference.getDate() > today) {
            if (nextConference.isRegistration()) {
                modelAndView = new ModelAndView("index-reg");
                modelAndView.addObject("conference", nextConference);
            } else {
                if (nextConference.getReports().size() != 0) {
                    modelAndView = new ModelAndView("index-before");
                    modelAndView.addObject("conference", nextConference);
                } else {
                    modelAndView = new ModelAndView("index-after");
                    modelAndView.addObject("nextConference", nextConference);
                    Conference conferenceWithReports = conferenceService.findLastWithReports();
                    modelAndView.addObject("conference", conferenceWithReports);
                }
            }
        } else {
            modelAndView = new ModelAndView("index-after");
            if (nextConference.getReports().size() == 0) {
                nextConference = conferenceService.findLastWithReports();
            }
            modelAndView.addObject("conference", nextConference);
        }
        return modelAndView;
    }

}
