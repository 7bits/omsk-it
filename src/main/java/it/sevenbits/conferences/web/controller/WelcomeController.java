package it.sevenbits.conferences.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

    @RequestMapping(value = {"/index.html", "/"}, method = RequestMethod.GET)
    public String showIndex(Model model) {

        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "index";
    }
}
