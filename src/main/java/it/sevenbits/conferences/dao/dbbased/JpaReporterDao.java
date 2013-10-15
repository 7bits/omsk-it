package it.sevenbits.conferences.dao.dbbased;

import it.sevenbits.conferences.dao.ReporterDao;
import it.sevenbits.conferences.domain.Reporter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JpaReporterDao implements ReporterDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Reporter addReporter(Reporter reporter) {

        entityManager.persist(reporter);
        return reporter;
    }

    @Override
    public boolean removeReporter(Long id) {

        Reporter reporter = entityManager.find(Reporter.class, id);

        if (reporter != null) {
            entityManager.remove(reporter);
            return true;
        }
        return false;
    }

    @Override
    public Reporter updateReporter(Reporter reporter) {

        return entityManager.merge(reporter);
    }

    @Override
    public List<Reporter> findAllReporters() {

        return entityManager.
                createQuery("select r from reporter r", Reporter.class).
                getResultList();
    }

    @Override
    public Reporter findReporterById(Long id) {

        return entityManager.find(Reporter.class, id);
    }
}
