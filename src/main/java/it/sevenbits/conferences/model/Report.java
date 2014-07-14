package it.sevenbits.conferences.model;


/**
 * Reports Model.
 */
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


    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }


    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(final String presentation) {
        this.presentation = presentation;
    }


    public String getVideo() {
        return video;
    }

    public void setVideo(final String video) {
        this.video = video;
    }


    public String getOtherConferences() {
        return otherConferences;
    }

    public void setOtherConferences(final String otherConferences) {
        this.otherConferences = otherConferences;
    }


    public String getKeyTechnologies() {
        return keyTechnologies;
    }

    public void setKeyTechnologies(final String keyTechnologies) {
        this.keyTechnologies = keyTechnologies;
    }


    public String getReporterWishes() {
        return reporterWishes;
    }

    public void setReporterWishes(final String reporterWishes) {
        this.reporterWishes = reporterWishes;
    }
}
