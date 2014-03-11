package it.sevenbits.conferences.web.form;

/**
 * POJO class for the suggestion form representation.
 */
public class SuggestionForm {

    private String[] senderSpecialization;
    private String senderSpecializationOther;
    private String[] favoriteTheme;
    private String favoriteThemeOther;
    private String themeRequest;
    private String reporterRequest;

    public String[] getSenderSpecialization() {
        return senderSpecialization;
    }

    public void setSenderSpecialization(final String[] senderSpecialization) {
        this.senderSpecialization = senderSpecialization;
    }

    public String getSenderSpecializationOther() {
        return senderSpecializationOther;
    }

    public void setSenderSpecializationOther(final String senderSpecializationOther) {
        this.senderSpecializationOther = senderSpecializationOther;
    }

    public String[] getFavoriteTheme() {
        return favoriteTheme;
    }

    public void setFavoriteTheme(final String[] favoriteTheme) {
        this.favoriteTheme = favoriteTheme;
    }

    public String getFavoriteThemeOther() {
        return favoriteThemeOther;
    }

    public void setFavoriteThemeOther(final String favoriteThemeOther) {
        this.favoriteThemeOther = favoriteThemeOther;
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
