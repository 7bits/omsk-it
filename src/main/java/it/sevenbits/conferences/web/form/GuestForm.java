package it.sevenbits.conferences.web.form;

/**
 * POJO class for the suggestion form representation.
 */
public class GuestForm {

//    private Conference conference;
    private String firstName;
    private String secondName;
    private String email;
    private String job;
    private String jobPosition;
    private String jobPositionOther;

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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public String getJobPositionOther() {
        return jobPositionOther;
    }

    public void setJobPositionOther(String jobPositionOther) {
        this.jobPositionOther = jobPositionOther;
    }
}
