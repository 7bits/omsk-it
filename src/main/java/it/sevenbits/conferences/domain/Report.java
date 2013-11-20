package it.sevenbits.conferences.domain;

import javax.persistence.*;

/**
 * POJO class for Reports model.
 */
@Entity
@Table(name = "report")
public class Report {

    private Long id;
    private Conference conference;
    private Reporter reporter;
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

    @ManyToOne
    @JoinColumn(name = "reporter_id")
    public Reporter getReporter() {
        return reporter;
    }

    public void setReporter(Reporter reporter) {
        this.reporter = reporter;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "description", length = 1000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "presentation")
    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    @Column(name = "video")
    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    @Column(name = "other_conferences")
    public String getOtherConferences() {
        return otherConferences;
    }

    public void setOtherConferences(String otherConferences) {
        this.otherConferences = otherConferences;
    }

    @Column(name = "key_technologies")
    public String getKeyTechnologies() {
        return keyTechnologies;
    }

    public void setKeyTechnologies(String keyTechnologies) {
        this.keyTechnologies = keyTechnologies;
    }

    @Column(name = "reporter_wishes")
    public String getReporterWishes() {
        return reporterWishes;
    }

    public void setReporterWishes(String reporterWishes) {
        this.reporterWishes = reporterWishes;
    }
}
