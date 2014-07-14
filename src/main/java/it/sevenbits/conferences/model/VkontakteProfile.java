package it.sevenbits.conferences.model;

/**
 * VkontakteProfile Model;
 */
public class VkontakteProfile {

    private Long id;
    private Long vkontakteId;
    private User user;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getVkontakteId() {
        return vkontakteId;
    }

    public void setVkontakteId(Long vkontakteId) {
        this.vkontakteId = vkontakteId;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
