package it.sevenbits.conferences.web.controller;

import it.sevenbits.conferences.utils.vkontakteAuthorization.VkontakteProfile;
import it.sevenbits.conferences.utils.vkontakteAuthorization.VkontakteProfiles;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "oauth")
public class VkAuthorizationController {

    private static final Logger LOGGER = Logger.getLogger(VkAuthorizationController.class);
    private static final String CLIENT_ID = "4193643";
    private static final String CLIENT_SECRET = "C4VA3AUYfyB5wgng2U8o";
    private static final String RESPONSE_TYPE_CODE = "code";
    private static final String REDIRECT_URI = "http://saturdays.omskit.org/oauth/vkAuth";

    @RequestMapping(value = "vkAuthorization", method = RequestMethod.GET)
    public String getAuthorizationUrl() {
        String url =
                "https://oauth.vk.com/authorize?client_id=" + CLIENT_ID +
                "&scope=SETTINGS&redirect_uri=" + REDIRECT_URI +
                "&response_type=" + RESPONSE_TYPE_CODE;
        return "redirect:" + url;
    }

    @RequestMapping(value = "vkAuth", method = RequestMethod.GET)
    public String authetication(final HttpServletRequest request) {
        String code = request.getParameter("code");
        String userIdGetUrl =
                "https://oauth.vk.com/access_token?client_id=" + CLIENT_ID +
                "&client_secret=" + CLIENT_SECRET +
                "&code=" + code +
                "&redirect_uri=" + REDIRECT_URI;
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpUriRequest accessTokenGet = new HttpPost(userIdGetUrl);
        try {
            HttpResponse httpResponse = httpClient.execute(accessTokenGet);
            Map<String, String> map = new HashMap<>();
            ObjectMapper mapper = new ObjectMapper();
            map = mapper.readValue(httpResponse.getEntity().getContent(), new TypeReference<HashMap<String, String>>(){});
            VkontakteProfile vkontakteProfile = getVkontakteProfile(map.get("user_id"), map.get("access_token"));
            if (vkontakteProfile != null) {
                LOGGER.error(vkontakteProfile.getFirst_name());
                LOGGER.error(vkontakteProfile.getLast_name());
                LOGGER.error(vkontakteProfile.getPhoto_100());
            } else {
                LOGGER.error("Vkontakte authorization: User isn't accessible");
            }
        } catch (IOException exception) {
            LOGGER.error("Vkontakte authorization: " + exception.getMessage());
        }
        LOGGER.error(code);
        return "redirect:" + "/";
    }

    private VkontakteProfile getVkontakteProfile(final String userId, final String accessToken) {
        String getProfileRequestUrl =
                "https://api.vk.com/method/users.get?user_id=" + userId +
                "&v=5.14" +
                "&access_token=" + accessToken +
                "&fields=photo_100";
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpUriRequest getProfileRequest = new HttpPost(getProfileRequestUrl);
        Map<String, ArrayList> map = new HashMap<>();
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
