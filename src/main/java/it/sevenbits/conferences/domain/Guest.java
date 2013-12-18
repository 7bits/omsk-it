package it.sevenbits.conferences.domain;

import javax.persistence.*;

/**
 * POJO class for Guests model.
 */
@Entity
@Table(name = "guest")
public class Guest {

    private Long id;
    private Conference conference;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "conference_id")
    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }

}
