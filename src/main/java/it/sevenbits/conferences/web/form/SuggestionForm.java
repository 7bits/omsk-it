package it.sevenbits.conferences.web.form;

/**
 * POJO class for the suggestion form representation.
 */
public class SuggestionForm {

    private String senderSpecialization;
    private String senderSpecializationOther;
    private String[] favoriteTheme;
    private String favoriteThemeOther;
    private String themeRequest;
//    private String reporterRequest;

    public String getSenderSpecialization() {
        return senderSpecialization;
    }

    public void setSenderSpecialization(String senderSpecialization) {
        this.senderSpecialization = senderSpecialization;
    }

    public String getSenderSpecializationOther() {
        return senderSpecializationOther;
    }

    public void setSenderSpecializationOther(String senderSpecializationOther) {
        this.senderSpecializationOther = senderSpecializationOther;
    }

    public String[] getFavoriteTheme() {
        return favoriteTheme;
    }

    public void setFavoriteTheme(String favoriteTheme[]) {
        this.favoriteTheme = favoriteTheme;
    }

    public String getFavoriteThemeOther() {
        return favoriteThemeOther;
    }

    public void setFavoriteThemeOther(String favoriteThemeOther) {
        this.favoriteThemeOther = favoriteThemeOther;
    }

    public String getThemeRequest() {
        return themeRequest;
    }

    public void setThemeRequest(String themeRequest) {
        this.themeRequest = themeRequest;
    }
}
