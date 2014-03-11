package it.sevenbits.conferences.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * POJO class for Suggestions model.
 */
@Entity
@Table(name = "suggestion")
public class Suggestion {

    private Long id;
    private String senderSpecialization;
    private String favoriteTheme;
    private String themeRequest;
    private String reporterRequest;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    @Column(name = "sender_specialization")
    public String getSenderSpecialization() {
        return senderSpecialization;
    }

    public void setSenderSpecialization(final String senderSpecialization) {
        this.senderSpecialization = senderSpecialization;
    }

    @Column(name = "favorite_theme")
    public String getFavoriteTheme() {
        return favoriteTheme;
    }

    public void setFavoriteTheme(final String favoriteTheme) {
        this.favoriteTheme = favoriteTheme;
    }

    @Column(name = "theme_request")
    public String getThemeRequest() {
        return themeRequest;
    }

    public void setThemeRequest(final String themeRequest) {
        this.themeRequest = themeRequest;
    }

    @Column(name = "reporter_request")
    public String getReporterRequest() {
        return reporterRequest;
    }

    public void setReporterRequest(final String reporterRequest) {
        this.reporterRequest = reporterRequest;
    }
}
