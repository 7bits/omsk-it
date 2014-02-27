package it.sevenbits.conferences.web.controller;

import it.sevenbits.conferences.domain.Company;
import it.sevenbits.conferences.domain.Report;
import it.sevenbits.conferences.domain.Role;
import it.sevenbits.conferences.domain.User;
import it.sevenbits.conferences.service.CompanyService;
import it.sevenbits.conferences.service.ReportService;
import it.sevenbits.conferences.service.RoleService;
import it.sevenbits.conferences.service.UserService;
import it.sevenbits.conferences.utils.mail.MailSenderUtility;
import it.sevenbits.conferences.web.form.ApplyForReportForm;
import it.sevenbits.conferences.web.form.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Controller for /apply-for-report page.
 */
@Controller
public class ApplyForReportController {

    @Autowired
    private CompanyService companyService;
    @Autowired
    private ReportService reportService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private MailSenderUtility mailSenderUtility;

    @Autowired
    @Qualifier("anonymousApplyForReportValidator")
    private Validator anonymousApplyForReportValidator;
    @Autowired
    @Qualifier("userApplyForReportValidator")
    private Validator userApplyForReportValidator;

    @RequestMapping(value = "/apply-for-report", method = RequestMethod.GET)
    public ModelAndView showForm() {

        ModelAndView modelAndView = new ModelAndView("apply-for-report");
        return modelAndView;
    }


    /**
     * Try to get logged user
     * @return user - if any user is logged
     *         null - if user isn/t logged
     */
    private User getLoggedUser() {
        String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
        User loggedUser = userService.getUser(userLogin);
        return  loggedUser;
    }

    @RequestMapping(value = "/apply-for-report", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse submitForm(@ModelAttribute(value = "applyForReportForm") ApplyForReportForm applyForReportForm, BindingResult bindingResult) {

        JsonResponse response = new JsonResponse();
        boolean isLogged = false;

        if (getLoggedUser() != null) {
            userApplyForReportValidator.validate(applyForReportForm, bindingResult);
            isLogged = true;
        } else {
            anonymousApplyForReportValidator.validate(applyForReportForm, bindingResult);
        }

        if (bindingResult.hasErrors()) {
            response.setStatus("FAIL");
            Map<String, String> errors = new HashMap<>();
            for (FieldError fieldError: bindingResult.getFieldErrors()) {
                if (!errors.containsKey(fieldError.getField())) {
                    errors.put(fieldError.getField(), fieldError.getDefaultMessage());
                }
            }
            errors.put("message", "Форма заполнена неверно.");
            response.setResult(errors);
        } else {

            if (isLogged) {
                User currentUser = getLoggedUser();

                Company company = new Company();
                company.setName(applyForReportForm.getCompany());
                companyService.addCompany(company);

                Report report = new Report();
                report.setUser(currentUser);
                report.setTitle(applyForReportForm.getTitle());
                report.setDescription(applyForReportForm.getDescription());
                report.setKeyTechnologies(applyForReportForm.getKeyTechnologies());
                report.setOtherConferences(applyForReportForm.getOtherConferences());
                report.setReporterWishes(applyForReportForm.getReporterWishes());

                reportService.addReport(report);
                response.setResult(Collections.singletonMap("message", "Заявка отправлена."));
            } else {
                User user = new User();
                user.setFirstName(applyForReportForm.getFirstName());
                user.setSecondName(applyForReportForm.getSecondName());
                user.setEmail(applyForReportForm.getEmail());
                user.setLogin(applyForReportForm.getEmail());
                user.setPassword(applyForReportForm.getPassword());
                user.setJobPosition(applyForReportForm.getJobPosition());
                user.setEnabled(false);
                Role role = roleService.findRoleById(1l);
                user.setRole(role);
                String confirmation_token = UUID.randomUUID().toString();
                user.setConfirmationToken(confirmation_token);
                userService.updateUser(user);

                Report report = new Report();
                report.setTitle(applyForReportForm.getTitle());
                report.setDescription(applyForReportForm.getDescription());
                report.setKeyTechnologies(applyForReportForm.getKeyTechnologies());
                report.setOtherConferences(applyForReportForm.getOtherConferences());
                report.setReporterWishes(applyForReportForm.getReporterWishes());
                Report addedReport = reportService.addReport(report);
                mailSenderUtility.sendConfirmationTokenAndReportStatus(user.getEmail(), confirmation_token, addedReport.getId());
                response.setResult(Collections.singletonMap("message", "Вам на почту выслано письмо для подтверждения регистрации."));
            }
            response.setStatus("SUCCESS");
        }

        return response;
    }
}
