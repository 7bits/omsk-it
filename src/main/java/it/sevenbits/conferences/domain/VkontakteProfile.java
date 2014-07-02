package it.sevenbits.conferences.domain;


import javax.persistence.*;

/**
 * POJO class for Vkontakte's profile model.
 */
@Entity
@Table(name = "vkontakteProfile")
public class VkontakteProfile {

    private Long id;
    private Long vkontakteId;
    private User user;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    @Column(name = "vkontakte_id")
    public Long getVkontakteId() {
        return vkontakteId;
    }

    public void setVkontakteId(final Long vkontakteId) {
        this.vkontakteId = vkontakteId;
    }

    @OneToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }
}
