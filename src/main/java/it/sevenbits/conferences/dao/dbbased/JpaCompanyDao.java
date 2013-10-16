package it.sevenbits.conferences.dao.dbbased;

import it.sevenbits.conferences.dao.CompanyDao;
import it.sevenbits.conferences.domain.Company;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JpaCompanyDao implements CompanyDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Company addCompany(Company company) {

        entityManager.persist(company);
        return company;
    }

    @Override
    public boolean removeCompany(Long id) {

        Company company = entityManager.find(Company.class, id);

        if (company != null) {
            entityManager.remove(company);
            return true;
        }
        return false;
    }

    @Override
    public Company updateCompany(Company company) {

        return entityManager.merge(company);
    }

    @Override
    public List<Company> findAllCompanies() {

        return entityManager.
                createQuery("select c from company c", Company.class).
                getResultList();
    }

    @Override
    public Company findCompanyById(Long id) {

        return entityManager.find(Company.class, id);
    }

    //public Company findByQuery(String query, Map<String, Object> parameters, Class modelClass);

    @Override
    public Company findCompanyByName(String name) {

        List<Company> result = entityManager.
                createQuery("select c from company c where c.name = :name", Company.class).
                setParameter("name", name).
                getResultList();

        if (result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }
}
