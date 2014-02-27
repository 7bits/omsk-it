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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeyTechnologies() {
        return keyTechnologies;
    }

    public void setKeyTechnologies(String keyTechnologies) {
        this.keyTechnologies = keyTechnologies;
    }

    public String getOtherConferences() {
        return otherConferences;
    }

    public void setOtherConferences(String otherConferences) {
        this.otherConferences = otherConferences;
    }

    public String getSpeechExperience() {
        return speechExperience;
    }

    public void setSpeechExperience(String speechExperience) {
        this.speechExperience = speechExperience;
    }

    public String getReporterWishes() {
        return reporterWishes;
    }

    public void setReporterWishes(String reporterWishes) {
        this.reporterWishes = reporterWishes;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
