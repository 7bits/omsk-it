package it.sevenbits.conferences.web.controller;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Controller
@RequestMapping(value = "oauth")
public class VkAuthorizationController {

    private static final Logger LOGGER = Logger.getLogger(VkAuthorizationController.class);

    @RequestMapping(value = "vkAuthorization", method = RequestMethod.GET)
    public String getAuthorizationUrl() {
        String url = "https://oauth.vk.com/authorize?client_id=4193643&scope=SETTINGS&redirect_uri=http://saturdays.omskit.org/oauth/vkAuth&response_type=code";
        return "redirect:" + url;
    }

    @RequestMapping(value = "vkAuth", method = RequestMethod.GET)
    public void authetication(final HttpServletRequest request, final HttpServletResponse response) {
        String code = request.getParameter("code");
        HttpClient httpClient = HttpClientBuilder.create().build();
        String userIdGetUrl = "https://oauth.vk.com/access_token?client_id=4193643&client_secret=C4VA3AUYfyB5wgng2U8o&code=" + code + "&redirect_uri=http://saturdays.omskit.org/oauth/vkAuth";
        HttpUriRequest accessTokenGet = new HttpPost(userIdGetUrl);
        try {
            HttpResponse httpResponse = httpClient.execute(accessTokenGet);

            // Deal with the response.Use caution: ensure correct character encoding and is
            // not binary data
            BufferedReader rd = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));

            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            LOGGER.error(result.toString());
        } catch (IOException exception) {
            LOGGER.error(exception.getMessage());
        }

        LOGGER.error(code);
        int k = 10;
    }

}
