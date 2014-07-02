package it.sevenbits.conferences.service.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.sevenbits.conferences.dao.CompanyDao;
import it.sevenbits.conferences.domain.Company;
import it.sevenbits.conferences.service.CompanyService;

/**
 * Simple implementation of the CompanyService.
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDao companyDao;

    @Transactional
    @Override
    public Company addCompany(final Company company) {

        return companyDao.add(company);
    }

    @Transactional
    @Override
    public boolean removeCompany(final Long id) {

        return companyDao.remove(id);
    }

    @Transactional
    @Override
    public Company updateCompany(final Company company) {

        return companyDao.update(company);
    }

    @Transactional
    @Override
    public List<Company> findAllCompanies() {

        return companyDao.findAll();
    }

    @Transactional
    @Override
    public Company findCompanyById(final Long id) {

        return companyDao.findById(id);
    }

    @Transactional
    @Override
    public Company findCompanyByName(final String name) {
        String query = "SELECT c FROM Company c WHERE c.name =:name";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("name", name);
        List<Company> usersList = companyDao.findByQuery(query, queryParams);
        if (usersList == null || usersList.isEmpty()) {
            return null;
        }
        return usersList.get(0);
    }
}
