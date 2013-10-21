package it.sevenbits.conferences.dao.dbbased;

import it.sevenbits.conferences.dao.CompanyDao;
import it.sevenbits.conferences.domain.Company;
import org.springframework.stereotype.Repository;

@Repository
public class JpaCompanyDao extends JpaEntityDao<Company> implements CompanyDao {

    public JpaCompanyDao() {

        super(Company.class);
    }

    public JpaCompanyDao(Class<Company> companyClass) {

        super(companyClass);
    }
}
