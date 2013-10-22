package it.sevenbits.conferences.domain;

import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
@Table(name = "conference")
public class Conference {

    private Long id;
    private Company company;
    private Long ordinalNumber;
    private Long date;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "company_id")
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Column(name = "ordinal_number")
    public Long getOrdinalNumber() {
        return ordinalNumber;
    }

    public void setOrdinalNumber(Long ordinalNumber) {
        this.ordinalNumber = ordinalNumber;
    }

    @Column(name = "date")
    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    @Transient
    public String getHumanReadableDate() {

        if (date == null) {
            return "";
        } else {
            DateTime dateTime = new DateTime(date);
            return dateTime.toString("dd MMMM yyyy");
        }
    }
}
