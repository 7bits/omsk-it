package it.sevenbits.conferences.domain;

import javax.persistence.*;

/**
 * POJO class for Suggestions model.
 */
@Entity
@Table(name = "suggestion")
public class Suggestion {

    private Long id;
    private String[] senderSpecialization;
    private String[] favoriteTheme;
    private String themeRequest;
    private String reporterRequest;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "sender_specialization")
    public String[] getSenderSpecialization() {
        return senderSpecialization;
    }

    public void setSenderSpecialization(String[] senderSpecialization) {
        this.senderSpecialization = senderSpecialization;
    }

    @Column(name = "favorite_theme")
    public String[] getFavoriteTheme() {
        return favoriteTheme;
    }

    public void setFavoriteTheme(String[] favoriteTheme) {
        this.favoriteTheme = favoriteTheme;
    }

    @Column(name = "theme_request")
    public String getThemeRequest() {
        return themeRequest;
    }

    public void setThemeRequest(String themeRequest) {
        this.themeRequest = themeRequest;
    }

    @Column(name = "reporter_request")
    public String getReporterRequest() {
        return reporterRequest;
    }

    public void setReporterRequest(String reporterRequest) {
        this.reporterRequest = reporterRequest;
    }
}
