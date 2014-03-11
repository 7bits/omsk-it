package it.sevenbits.conferences.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * POJO class for Reports model.
 */
@Entity
@Table(name = "report")
public class Report {

    private Long id;
    private Conference conference;
    private User user;
    private String title;
    private String description;
    private String presentation;
    private String video;
    private String otherConferences;
    private String keyTechnologies;
    private String reporterWishes;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "conference_id")
    public Conference getConference() {
        return conference;
    }

    public void setConference(final Conference conference) {
        this.conference = conference;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    @Column(name = "description", length = 1000)
    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    @Column(name = "presentation")
    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(final String presentation) {
        this.presentation = presentation;
    }

    @Column(name = "video")
    public String getVideo() {
        return video;
    }

    public void setVideo(final String video) {
        this.video = video;
    }

    @Column(name = "other_conferences")
    public String getOtherConferences() {
        return otherConferences;
    }

    public void setOtherConferences(final String otherConferences) {
        this.otherConferences = otherConferences;
    }

    @Column(name = "key_technologies")
    public String getKeyTechnologies() {
        return keyTechnologies;
    }

    public void setKeyTechnologies(final String keyTechnologies) {
        this.keyTechnologies = keyTechnologies;
    }

    @Column(name = "reporter_wishes")
    public String getReporterWishes() {
        return reporterWishes;
    }

    public void setReporterWishes(final String reporterWishes) {
        this.reporterWishes = reporterWishes;
    }
}
