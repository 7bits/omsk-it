package it.sevenbits.conferences.domain;


import javax.persistence.*;

/**
 * POJO class for Companies model.
 */
@Entity
@Table(name = "company")
public class Company {

    private Long id;
    private String name;
    private String site;
    private String location;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Column(name = "site")
    public String getSite() {
        return site;
    }

    public void setSite(final String site) {
        this.site = site;
    }

    @Column(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(final String location) {
        this.location = location;
    }

    @Transient
    public Boolean isHaveLink(){
        return  !((site == null) || (site.replaceAll("\\s+", "").equals("")));
    }
}
