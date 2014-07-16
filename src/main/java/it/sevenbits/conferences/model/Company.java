package it.sevenbits.conferences.model;


/**
 * Companies Model.
 */
public class Company {

    private Long id;
    private String name;
    private String site;
    private String location;


    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }


    public String getSite() {
        return site;
    }

    public void setSite(final String site) {
        this.site = site;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(final String location) {
        this.location = location;
    }

    public Boolean isHaveLink() {
        return  !((site == null) || (site.replaceAll("\\s+", "").equals("")));
    }
}
