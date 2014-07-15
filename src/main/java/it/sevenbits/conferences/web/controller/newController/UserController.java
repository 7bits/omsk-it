package it.sevenbits.conferences.web.controller.newController;

import it.sevenbits.conferences.model.User;
import it.sevenbits.conferences.service.exception.ServiceException;
import it.sevenbits.conferences.service.newService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for /user pages.
 */
@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ModelAndView getUserInformation(@PathVariable(value = "userId") final Long userId) throws ServiceException {
        ModelAndView modelAndView = new ModelAndView("user-information");
        User user = userService.findUserWithCompanyById(userId);
        modelAndView.addObject("user", user);
        return modelAndView;
    }
}
