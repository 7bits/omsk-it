package it.sevenbits.conferences.web.form;

/**
 * POJO class for the company's form representation.
 */
public class CompanyAddForm {

    private String name;
    private String site;

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
}
