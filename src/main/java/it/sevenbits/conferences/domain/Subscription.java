package it.sevenbits.conferences.domain;


import javax.persistence.*;

/**
 * POJO class for Subscriptions model.
 */
@Entity
@Table(name = "subscription")
public class Subscription {

    private Long id;
    private String email;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }
}
