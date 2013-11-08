package it.sevenbits.conferences.dao.dbbased;

import it.sevenbits.conferences.dao.ReporterDao;
import it.sevenbits.conferences.domain.Reporter;
import org.springframework.stereotype.Repository;

/**
 * Java Persistence API based implementation of the ReporterDao.
 */
@Repository
public class JpaReporterDao extends JpaEntityDao<Reporter> implements ReporterDao {

    /**
     * Default constructor for the spring framework annotation based configuration.
     */
    public JpaReporterDao() {

        super(Reporter.class);
    }

    /**
     * Constructor from generic JpaEntityDao.
     * @param reporterClass generic class type.
     */
    public JpaReporterDao(Class<Reporter> reporterClass) {

        super(reporterClass);
    }
}
