package it.sevenbits.conferences.model;

/**
 * Subscriptions Model.
 */
public class Subscription {

    private Long id;
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }
}
