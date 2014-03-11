package it.sevenbits.conferences.domain;

import it.sevenbits.conferences.utils.converter.DateTimeConverter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * POJO class for Conferences model.
 */
@Entity
@Table(name = "conference")
public class Conference {

    private Long id;
    private Company company;
    private Long ordinalNumber;
    private Long date;
    private boolean registration;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "company_id")
    public Company getCompany() {
        return company;
    }

    public void setCompany(final Company company) {
        this.company = company;
    }

    @Column(name = "ordinal_number")
    public Long getOrdinalNumber() {
        return ordinalNumber;
    }

    public void setOrdinalNumber(final Long ordinalNumber) {
        this.ordinalNumber = ordinalNumber;
    }

    @Column(name = "date")
    public Long getDate() {
        return date;
    }

    @Basic
    @Column(name = "registration", columnDefinition = "BIT", length = 1)
    public boolean isRegistration() {
        return registration;
    }

    public void setRegistration(final boolean registration) {
        this.registration = registration;
    }

    public void setDate(final Long date) {
        this.date = date;
    }

    @Transient
    public String getHumanReadableDate() {

        return DateTimeConverter.fromLong(date);
    }
}
