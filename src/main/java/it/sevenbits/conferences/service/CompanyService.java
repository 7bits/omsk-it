package it.sevenbits.conferences.service;

import it.sevenbits.conferences.domain.Company;

import java.util.List;

public interface CompanyService {

    Company addCompany(final Company company);

    boolean removeCompany(final Long id);

    Company updateCompany(final Company company);

    List<Company> findAllCompanies();

    Company findCompanyById(final Long id);

    Company findCompanyByName(final String name);
}
