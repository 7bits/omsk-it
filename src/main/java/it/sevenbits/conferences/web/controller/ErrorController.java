package it.sevenbits.conferences.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for errors handling.
 */
@Controller
@RequestMapping(value = "error")
public class ErrorController {

    @RequestMapping(value = "404", method = RequestMethod.GET)
    public ModelAndView getNotFoundErrorPage() {
        ModelAndView modelAndView = new ModelAndView("error-404");
        return modelAndView;
    }

    @RequestMapping(value = "403", method = RequestMethod.GET)
    public ModelAndView getForbiddenErrorPage() {
        ModelAndView modelAndView = new ModelAndView("error-403");
        return modelAndView;
    }

    @RequestMapping(value = "400", method = RequestMethod.GET)
    public ModelAndView getBadRequestErrorPage() {
        ModelAndView modelAndView = new ModelAndView("error-400");
        return modelAndView;
    }

    @RequestMapping(value = "500", method = RequestMethod.GET)
    public ModelAndView getInternalServerErrorPage() {
        ModelAndView modelAndView = new ModelAndView("error-500");
        return modelAndView;
    }
}
