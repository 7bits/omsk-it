package it.sevenbits.conferences.dao.dbbased;

import org.springframework.stereotype.Repository;

import it.sevenbits.conferences.dao.CompanyDao;
import it.sevenbits.conferences.domain.Company;

/**
 * Java Persistence API based implementation of the CompanyDao.
 */
@Repository
public class JpaCompanyDao extends JpaEntityDao<Company> implements CompanyDao {

    /**
     * Default constructor for the spring framework annotation based configuration.
     */
    public JpaCompanyDao() {

        super(Company.class);
    }

    /**
     * Constructor from generic JpaEntityDao.
     * @param companyClass generic class type.
     */
    public JpaCompanyDao(final Class<Company> companyClass) {

        super(companyClass);
    }
}
