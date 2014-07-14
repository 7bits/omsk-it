package it.sevenbits.conferences.model;

import javax.persistence.ManyToOne;

/**
 * Guests Model.
 */
public class Guest {

    private Long id;
    private Conference conference;
    private User user;


    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }


    public Conference getConference() {
        return conference;
    }

    public void setConference(final Conference conference) {
        this.conference = conference;
    }


    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }
}
