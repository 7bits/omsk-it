package it.sevenbits.conferences.web.controller.newController;

import it.sevenbits.conferences.model.Report;
import it.sevenbits.conferences.model.User;
import it.sevenbits.conferences.service.exception.ServiceException;
import it.sevenbits.conferences.service.newService.ReportService;
import it.sevenbits.conferences.service.newService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Controller for /user pages.
 */
@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ReportService reportService;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ModelAndView getUserInformation(@PathVariable(value = "userId") final Long userId) throws ServiceException {
        ModelAndView modelAndView = new ModelAndView("user-information");
        User user = userService.findUserWithCompanyById(userId);
        List<Report> reports = reportService.findAllByUser(user);

        modelAndView.addObject("user", user);
        modelAndView.addObject("reports", reports);
        return modelAndView;
    }
}
