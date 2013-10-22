package it.sevenbits.conferences.dao.dbbased;

import it.sevenbits.conferences.dao.CompanyDao;
import it.sevenbits.conferences.domain.Company;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Integration Test for it.sevenbits.conferences.dao.dbbased.JpaCompanyDao
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/config/root-context.xml", "file:src/main/webapp/WEB-INF/config/data-context.xml"})
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
@Transactional
public class JpaCompanyDaoIT {

    @Autowired
    private CompanyDao companyDao;

    private Company testCompany;
    private Long testCompanyId;
    private final String testCompanyName = "testCompany";

    @Before
    public void setUp() {

        testCompany = new Company();
        testCompany.setName(testCompanyName);
        companyDao.add(testCompany);
        testCompanyId = testCompany.getId();
    }

    @Test
    public void testAdd() {

        Company company = new Company();
        company.setName("someCompany");

        assertNull(company.getId());
        assertEquals(companyDao.add(company), company);
        assertNotNull(company.getId());
    }

    @Test
    public void testDoubleAdd() {

        Company company = new Company();
        company.setName("someCompany");
        assertEquals(companyDao.add(company), company);

        company.setName("newName");
        assertNull(companyDao.add(company));
    }

    @Test
    public void testAddNull() {

        assertNull(companyDao.add(null));
    }

    @Test
    public void testRemove() {

        assertTrue(companyDao.remove(testCompanyId));
        assertFalse(companyDao.remove(testCompanyId));
    }

    @Test
    public void testRemoveNull() {

        assertFalse(companyDao.remove(null));
    }

    @Test
    public void testUpdate() {

        testCompany.setName("anotherName");

        assertEquals(companyDao.update(testCompany), testCompany);
        assertEquals(testCompany.getName(), companyDao.findById(testCompanyId).getName());
    }

    @Test
    public void testUpdateNull() {

        assertNull(companyDao.update(null));
    }

    @Test
    public void testFindAll() {

        List<Company> companies = companyDao.findAll();

        assertNotNull(companies);
        assertFalse(companies.isEmpty());
        assertTrue(companies.contains(testCompany));
    }

    @Test
    public void testFindById() {

        assertEquals(companyDao.findById(testCompanyId), testCompany);
    }

    @Test
    public void testFindByNullId() {

        assertNull(companyDao.findById(null));
    }

    @Test
    public void testFindByQuery() {

        assertNull(companyDao.findByQuery("", null));
        assertNull(companyDao.findByQuery(null, null));

        final String query = "select c from Company c where c.name = 'testCompany'";
        final String query2 = "select c from Company c where c.name = :name";

        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", "testCompany");

        assertEquals(testCompany, companyDao.findByQuery(query, null).iterator().next());
        assertEquals(testCompany, companyDao.findByQuery(query2, parameters).get(0));
    }
}
