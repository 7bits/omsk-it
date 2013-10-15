package it.sevenbits.conferences.dao.dbbased;

import it.sevenbits.conferences.dao.ReportDao;
import it.sevenbits.conferences.domain.Report;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JpaReportDao implements ReportDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Report addReport(Report report) {

        entityManager.persist(report);
        return report;
    }

    @Override
    public boolean removeReport(Long id) {

        Report report = entityManager.find(Report.class, id);

        if (report != null) {
            entityManager.remove(report);
            return true;
        }
        return false;
    }

    @Override
    public Report updateReport(Report report) {

        return entityManager.merge(report);
    }

    @Override
    public List<Report> findAllReports() {

        return entityManager.
                createQuery("select r from report r", Report.class).
                getResultList();
    }

    @Override
    public Report findReportById(Long id) {

        return entityManager.find(Report.class, id);
    }
}
