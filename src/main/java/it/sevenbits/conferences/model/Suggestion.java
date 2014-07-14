package it.sevenbits.conferences.model;

/**
 * Suggestions Model.
 */
public class Suggestion {

    private Long id;
    private String senderSpecialization;
    private String favoriteTheme;
    private String themeRequest;
    private String reporterRequest;


    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }


    public String getSenderSpecialization() {
        return senderSpecialization;
    }

    public void setSenderSpecialization(final String senderSpecialization) {
        this.senderSpecialization = senderSpecialization;
    }


    public String getFavoriteTheme() {
        return favoriteTheme;
    }

    public void setFavoriteTheme(final String favoriteTheme) {
        this.favoriteTheme = favoriteTheme;
    }


    public String getThemeRequest() {
        return themeRequest;
    }

    public void setThemeRequest(final String themeRequest) {
        this.themeRequest = themeRequest;
    }


    public String getReporterRequest() {
        return reporterRequest;
    }

    public void setReporterRequest(final String reporterRequest) {
        this.reporterRequest = reporterRequest;
    }
}
