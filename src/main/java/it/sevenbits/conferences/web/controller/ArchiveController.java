package it.sevenbits.conferences.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArchiveController {

    @RequestMapping(value = "/archive", method = RequestMethod.GET)
    public ModelAndView showArchive() {

        ModelAndView modelAndView = new ModelAndView("archive");
        return modelAndView;
    }
}
