package it.sevenbits.conferences.model;


import it.sevenbits.conferences.model.Role;

/**
 * User Model
 */
public class User {

    private Long id;
    private String password;
    private String firstName;
    private String secondName;
    private String email;
    private String jobPosition;
    private String confirmationToken;
    private String photo;
    private String selfDescription;
    private boolean enabled;
    private Company company;
    private Role role;
    private VkontakteProfile vkontakteProfile;


    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }


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


    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(final String jobPosition) {
        this.jobPosition = jobPosition;
    }


    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(final String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }


    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
    }


    public String getPhoto() {
        return photo;
    }

    public void setPhoto(final String photo) {
        this.photo = photo;
    }


    public Company getCompany() {
        return company;
    }

    public void setCompany(final Company company) {
        this.company = company;
    }


    public String getSelfDescription() {
        return selfDescription;
    }

    public void setSelfDescription(final String selfDescription) {
        this.selfDescription = selfDescription;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public VkontakteProfile getVkontakteProfile() {
        return vkontakteProfile;
    }

    public void setVkontakteProfile(VkontakteProfile vkontakteProfile) {
        this.vkontakteProfile = vkontakteProfile;
    }
}
