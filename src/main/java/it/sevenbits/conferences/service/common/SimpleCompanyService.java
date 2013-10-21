package it.sevenbits.conferences.service.common;

import it.sevenbits.conferences.dao.CompanyDao;
import it.sevenbits.conferences.domain.Company;
import it.sevenbits.conferences.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SimpleCompanyService implements CompanyService {

    @Autowired
    private CompanyDao companyDao;

    @Transactional
    @Override
    public Company addCompany(Company company) {

        return companyDao.add(company);
    }

    @Transactional
    @Override
    public boolean removeCompany(Long id) {

        return companyDao.remove(id);
    }

    @Transactional
    @Override
    public Company updateCompany(Company company) {

        return companyDao.update(company);
    }

    @Transactional
    @Override
    public List<Company> findAllCompanies() {

        return companyDao.findAll();
    }

    @Transactional
    @Override
    public Company findCompanyById(Long id) {

        return companyDao.findById(id);
    }

    @Transactional
    @Override
    public Company findCompanyByName(String name) {

//        return companyDao.findByName(name);
        return null;
    }
}
