package it.sevenbits.conferences.utils.vkontakteAuthorization;

/**
 * Entity class which represent profile from Vkontakte
 */
public class VkontakteProfile {
    private String id;
    private String first_name;
    private String last_name;
    private String photo_200;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(final String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(final String last_name) {
        this.last_name = last_name;
    }

    public String getPhoto_200() {
        return photo_200;
    }

    public void setPhoto_200(final String photo_200) {
        this.photo_200 = photo_200;
    }
}
