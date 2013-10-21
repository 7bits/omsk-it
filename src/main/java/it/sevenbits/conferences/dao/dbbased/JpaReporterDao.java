package it.sevenbits.conferences.dao.dbbased;

import it.sevenbits.conferences.dao.ReporterDao;
import it.sevenbits.conferences.domain.Reporter;
import org.springframework.stereotype.Repository;

@Repository
public class JpaReporterDao extends JpaEntityDao<Reporter> implements ReporterDao {

    public JpaReporterDao() {

        super(Reporter.class);
    }

    public JpaReporterDao(Class<Reporter> reporterClass) {

        super(reporterClass);
    }
}
