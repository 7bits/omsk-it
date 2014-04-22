package it.sevenbits.conferences.utils.vkontakteAuthorization;

import java.util.ArrayList;

/**
 * Entity class which represent massive of profiles from Vkontakte's API
 */
public class VkontakteProfiles {
    private ArrayList<VkontakteProfile> response;

    public ArrayList<VkontakteProfile> getProfiles() {
        return response;
    }
    public void setResponse(final ArrayList<VkontakteProfile> response) {
        this.response = response;
    }
}
