package it.sevenbits.conferences.dao.dbbased;

import it.sevenbits.conferences.dao.ReportDao;
import it.sevenbits.conferences.domain.Report;
import org.springframework.stereotype.Repository;

/**
 * Java Persistence API based implementation of the ReportDao.
 */
@Repository
public class JpaReportDao extends JpaEntityDao<Report> implements ReportDao {

    /**
     * Default constructor for the spring framework annotation based configuration.
     */
    public JpaReportDao() {

        super(Report.class);
    }

    /**
     * Constructor from generic JpaEntityDao.
     * @param reportClass generic class type.
     */
    public JpaReportDao(Class<Report> reportClass) {

        super(reportClass);
    }
}
