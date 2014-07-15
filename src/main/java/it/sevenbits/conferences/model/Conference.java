package it.sevenbits.conferences.model;

import it.sevenbits.conferences.utils.converter.DateTimeConverter;
import sun.rmi.runtime.Log;

import java.util.List;

/**
 * Conferences Model.
 */
public class Conference {

    private Long id;
    private Company company;
    private Long ordinalNumber;
    private Long date;
    private boolean registration;


    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }


    public Company getCompany() {
        return company;
    }

    public void setCompany(final Company company) {
        this.company = company;
    }


    public Long getOrdinalNumber() {
        return ordinalNumber;
    }

    public void setOrdinalNumber(final Long ordinalNumber) {
        this.ordinalNumber = ordinalNumber;
    }


    public Long getDate() {
        return date;
    }

    public void setDate(final Long date) {
        this.date = date;
    }


    public boolean isRegistration() {
        return registration;
    }

    public void setRegistration(final boolean registration) {
        this.registration = registration;
    }


    public String getHumanReadableDate() {
        return DateTimeConverter.fromLong(date);
    }
}
