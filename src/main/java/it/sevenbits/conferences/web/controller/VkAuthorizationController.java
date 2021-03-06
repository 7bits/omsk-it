package it.sevenbits.conferences.web.controller;

import it.sevenbits.conferences.domain.Company;
import it.sevenbits.conferences.domain.Role;
import it.sevenbits.conferences.domain.User;
import it.sevenbits.conferences.service.CompanyService;
import it.sevenbits.conferences.service.RoleService;
import it.sevenbits.conferences.service.UserService;
import it.sevenbits.conferences.service.VkontakteProfileService;
import it.sevenbits.conferences.utils.file.FileManager;
import it.sevenbits.conferences.utils.mail.MailSenderUtility;
import it.sevenbits.conferences.utils.mail.exception.MailSenderException;
import it.sevenbits.conferences.utils.vkontakteAuthorization.VkontakteProfile;
import it.sevenbits.conferences.utils.vkontakteAuthorization.VkontakteProfiles;
import it.sevenbits.conferences.web.form.JsonResponse;
import it.sevenbits.conferences.web.form.UserRegistrationForm;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Controller which provide access to vkontakte's API.
 */
@Controller
@RequestMapping(value = "social")
public class VkAuthorizationController {

    private static final Logger LOGGER = Logger.getLogger(VkAuthorizationController.class);
    private static final String CLIENT_ID = "4193643";
    private static final String CLIENT_SECRET = "C4VA3AUYfyB5wgng2U8o";
    private static final String RESPONSE_TYPE_CODE = "code";
    private static final String REDIRECT_URI = "http://saturdays.omskit.org/social/vkAuthentication";
    private static final String PHOTO_SIZE = "photo_200";
    private static final int RANDOM_PASSWORD_LENGTH = 15;

    @Autowired
    private UserService userService;
    @Autowired
    private UserDetailsService customUserDetailsService;
    @Autowired
    private VkontakteProfileService vkontakteProfileService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private MailSenderUtility mailSenderUtility;
    @Autowired
    private RoleService roleService;
    @Autowired
    @Qualifier("userSocialRegistrationValidator")
    private Validator userSocialRegistrationValidator;


    /**
     * Request for code for receiving access token.
     * @return Redirect on url with code from vkontakte's API which process authentication.
     */
    @RequestMapping(value = "vkAuthorization", method = RequestMethod.GET)
    public String getAuthorizationUrl() {
        String url =
                "https://oauth.vk.com/authorize?client_id=" + CLIENT_ID +
                "&scope=SETTINGS&redirect_uri=" + REDIRECT_URI +
                "&response_type=" + RESPONSE_TYPE_CODE;
        return "redirect:" + url;
    }

    /**
     * Authentication with vkontakte's profile
     * @param referer Address from which request was come;
     * @param request Http request
     * @return Redirect on address from which request was come (referer) if user exists.
     *         Redirect on account-not-enabled page if user not enabled.
     *         Redirect on registration page if user not exists;
     */
    @RequestMapping(value = "vkAuthentication", method = RequestMethod.GET)
    public ModelAndView authetication(
            @RequestHeader(value = "referer", required = false) final String referer, final HttpServletRequest request
    ) {
        String code = request.getParameter("code");
        String userIdGetUrl =
                "https://oauth.vk.com/access_token?client_id=" + CLIENT_ID +
                "&client_secret=" + CLIENT_SECRET +
                "&code=" + code +
                "&redirect_uri=" + REDIRECT_URI;
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpUriRequest accessTokenGet = new HttpPost(userIdGetUrl);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:" + referer);
        try {
            HttpResponse httpResponse = httpClient.execute(accessTokenGet);
            Map<String, String> map;
            ObjectMapper mapper = new ObjectMapper();
            map = mapper.readValue(httpResponse.getEntity().getContent(), new TypeReference<HashMap<String, String>>() {} );
            VkontakteProfile vkontakteProfile = getVkontakteProfile(map.get("user_id"), map.get("access_token"));
            if (vkontakteProfile != null) {
                User user = userService.findUserByVkontakteId(Long.parseLong(vkontakteProfile.getId()));
                if (user != null && user.getEnabled()) {
                    UserDetails userDetails = customUserDetailsService.loadUserByUsername(user.getEmail());
                    authorizeUser(userDetails);
                } else if (user != null && !user.getEnabled()) {
                    modelAndView = new ModelAndView("account-not-enabled");
                } else {
                    request.getSession().setAttribute("vkontakteUserId", vkontakteProfile.getId());
                    BufferedImage image;
                    String temporaryPhotoName = null;
                    try {
                        URL url = new URL(vkontakteProfile.getPhoto_200());
                        image = ImageIO.read(url);
                        FileManager fileManager = new FileManager();
                        temporaryPhotoName = fileManager.saveTemporaryPhoto(image);
                    } catch (IOException e) {
                        LOGGER.error("Upload image fail: " + e.getMessage());
                    }
                    HttpSession httpSession = request.getSession();
                    httpSession.setAttribute("photosName", temporaryPhotoName);
                    modelAndView = new ModelAndView("user-social-registration");
                    modelAndView.addObject("userVkontakteFirstName", vkontakteProfile.getFirst_name());
                    modelAndView.addObject("userVkontakteSecondName", vkontakteProfile.getLast_name());
                    modelAndView.addObject("userVkontaktePhotoName", temporaryPhotoName);
                }
            } else {
                LOGGER.error("Vkontakte authorization: User isn't accessible");
            }
        } catch (IOException exception) {
            LOGGER.error("Vkontakte authorization: " + exception.getMessage());
        }
        return modelAndView;
    }

    @RequestMapping(value = "social-registration", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse socialUserRegistration(
            @ModelAttribute(value = "userRegistrationForm") final UserRegistrationForm userSocialRegistrationForm,
            final BindingResult bindingResult,
            final HttpSession httpSession
    ) {
        JsonResponse jsonResponse = new JsonResponse();
        userSocialRegistrationValidator.validate(userSocialRegistrationForm, bindingResult);
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError fieldError: bindingResult.getFieldErrors()) {
                if (!errors.containsKey(fieldError.getField())) {
                    errors.put(fieldError.getField(), fieldError.getDefaultMessage());
                }
            }
            errors.put("message", "Форма заполнена неверно");
            jsonResponse.setStatus(JsonResponse.STATUS_FAIL);
            jsonResponse.setResult(errors);
        } else {
            User user = new User();
            user.setFirstName(userSocialRegistrationForm.getFirstName());
            user.setSecondName(userSocialRegistrationForm.getSecondName());
            user.setEmail(userSocialRegistrationForm.getEmail());
            user.setLogin(userSocialRegistrationForm.getEmail());
            String randomPassword = RandomStringUtils.random(RANDOM_PASSWORD_LENGTH, true, true);
            PasswordEncoder encoder = new BCryptPasswordEncoder();
            String encodedRandomPassword = encoder.encode(randomPassword);
            user.setPassword(encodedRandomPassword);
            Company company = companyService.findCompanyByName(userSocialRegistrationForm.getCompany());
            user.setCompany(company);
            user.setJobPosition(userSocialRegistrationForm.getJobPosition());
            user.setEnabled(false);
            if (httpSession.getAttribute("photosName") != null) {
                FileManager fileManager = new FileManager();
                String photosName = httpSession.getAttribute("photosName").toString();
                boolean copyResult = fileManager.replaceFromTemporary(photosName);
                if (copyResult) {
                    user.setPhoto(photosName);
                } else {
                    user.setPhoto(null);
                }
                httpSession.setAttribute("photosName", null);
            } else {
                user.setPhoto(null);
            }
            //TODO: Kill this 3L hardcode
            Role role = roleService.findRoleById(3L);
            user.setRole(role);
            String confirmationToken = UUID.randomUUID().toString();
            user.setConfirmationToken(confirmationToken);
            User updatedUser = userService.updateUser(user);
            it.sevenbits.conferences.domain.VkontakteProfile vkontakteProfile = new it.sevenbits.conferences.domain.VkontakteProfile();
            Long vkontakteUserId = Long.parseLong(httpSession.getAttribute("vkontakteUserId").toString());
            vkontakteProfile.setVkontakteId(vkontakteUserId);
            vkontakteProfile.setUser(updatedUser);
            vkontakteProfileService.updateVkontakteProfile(vkontakteProfile);
            try {
                mailSenderUtility.sendConfirmationToken(userSocialRegistrationForm.getEmail(), confirmationToken);
            } catch (MailSenderException e) {
                Map<String, String> result = new HashMap<>();
                result.put("message", "Произошла ошибка на сервере, пожалуйста, повторите Ваши действия.");
                jsonResponse.setResult(result);
                jsonResponse.setStatus(JsonResponse.STATUS_FAIL);
                return jsonResponse;
            }
            jsonResponse.setStatus(JsonResponse.STATUS_SUCCESS);
            Map<String, String> result = new HashMap<>();
            result.put("message", "На Ваш email выслана ссылка для подтверждения");
            jsonResponse.setResult(result);
        }
        return jsonResponse;
    }

    private void authorizeUser(final UserDetails userDetails) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                userDetails, userDetails.getPassword(), userDetails.getAuthorities()
        );
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(authentication);
    }

    /**
     * Get user's vkontakte profile.
     * @param userId User's vkontakte id.
     * @param accessToken Vkontakte's API access token
     * @return Vkontakte's profile object.
     */
    private VkontakteProfile getVkontakteProfile(final String userId, final String accessToken) {
        String getProfileRequestUrl =
                "https://api.vk.com/method/users.get?user_id=" + userId +
                "&v=5.14" +
                "&access_token=" + accessToken +
                "&fields=" + PHOTO_SIZE;
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpUriRequest getProfileRequest = new HttpPost(getProfileRequestUrl);
        VkontakteProfile vkontakteProfile = null;
        try {
            HttpResponse getProfileResponse = httpClient.execute(getProfileRequest);
            ObjectMapper mapper = new ObjectMapper();
            VkontakteProfiles vkontakteProfiles = mapper.readValue(getProfileResponse.getEntity().getContent(), VkontakteProfiles.class);
            if (!vkontakteProfiles.getProfiles().isEmpty()) {
                vkontakteProfile = vkontakteProfiles.getProfiles().get(0);
            }
        } catch (IOException exception) {
            LOGGER.error("Vkontakte profile information: " + exception.getMessage());
        }
        return vkontakteProfile;
    }

}
