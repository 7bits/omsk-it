package it.sevenbits.conferences.dao.dbbased;

import it.sevenbits.conferences.dao.CompanyDao;
import it.sevenbits.conferences.domain.Company;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import static org.junit.Assert.*;

/**
 * Integration Test for it.sevenbits.conferences.dao.dbbased.JpaCompanyDao
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/config/root-context.xml", "file:src/main/webapp/WEB-INF/config/data-context.xml"})
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
public class JpaCompanyDaoIT {

    @Autowired
    private CompanyDao companyDao;

    @Test
    public void testFindById() {

        Company company = companyDao.findById(1L);
        assertEquals(company.getName(), "7bits");
    }
}
