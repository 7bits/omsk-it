package it.sevenbits.conferences.service;

import java.util.List;

import it.sevenbits.conferences.domain.Company;

/**
 * Interface for service layer, which works with EntityDao.
 * Company is the primary Entity for that Service.
 */
public interface CompanyService {

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#add(Object)
     */
    Company addCompany(final Company company);

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#remove(Long)
     */
    boolean removeCompany(final Long id);

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#update(Object)
     */
    Company updateCompany(final Company company);

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#findAll()
     */
    List<Company> findAllCompanies();

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#findById(Long)
     */
    Company findCompanyById(final Long id);

    /**
     * Finds an stored Company by it's name.
     * @param name Company's name.
     * @return the found Company, or null if the Company does not exist or an error occurs.
     * @see it.sevenbits.conferences.dao.EntityDao#findByQuery(String, java.util.Map)
     */
    Company findCompanyByName(final String name);
}
