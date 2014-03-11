package it.sevenbits.conferences.web.form;

/**
 * POJO class for the apply-for-report form representation.
 */
public class ApplyForReportForm {

    private String firstName;
    private String secondName;
    private String email;
    private String password;
    private String company;
    private String jobPosition;
    private String title;
    private String description;
    private String keyTechnologies;
    private String otherConferences;
    private String speechExperience;
    private String reporterWishes;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(final String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(final String company) {
        this.company = company;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(final String jobPosition) {
        this.jobPosition = jobPosition;
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

    public String getKeyTechnologies() {
        return keyTechnologies;
    }

    public void setKeyTechnologies(final String keyTechnologies) {
        this.keyTechnologies = keyTechnologies;
    }

    public String getOtherConferences() {
        return otherConferences;
    }

    public void setOtherConferences(final String otherConferences) {
        this.otherConferences = otherConferences;
    }

    public String getSpeechExperience() {
        return speechExperience;
    }

    public void setSpeechExperience(final String speechExperience) {
        this.speechExperience = speechExperience;
    }

    public String getReporterWishes() {
        return reporterWishes;
    }

    public void setReporterWishes(final String reporterWishes) {
        this.reporterWishes = reporterWishes;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }
}
