package it.sevenbits.conferences.dao;

import it.sevenbits.conferences.domain.Company;

import java.util.List;

public interface CompanyDao {

    Company addCompany(final Company company);

    boolean removeCompany(final Long id);

    Company updateCompany(final Company company);

    List<Company> findAllCompanies();

    Company findCompanyById(final Long id);
}
