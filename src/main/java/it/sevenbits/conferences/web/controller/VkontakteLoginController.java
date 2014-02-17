package it.sevenbits.conferences.web.controller;

import it.sevenbits.conferences.dao.dbbased.JpaEntityDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for /vklogin page
 */
@Controller
public class VkontakteLoginController {

    private static final Logger logger = Logger.getLogger(JpaEntityDao.class);

    @RequestMapping(value = "/vklogin", method = RequestMethod.GET)
    public ModelAndView showToReporters(@RequestBody String jsonString) {
        logger.error(jsonString);
        return new ModelAndView("redirect:/user/login/");
    }
}
