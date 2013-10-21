package it.sevenbits.conferences.dao.dbbased;

import it.sevenbits.conferences.dao.ReportDao;
import it.sevenbits.conferences.domain.Report;
import org.springframework.stereotype.Repository;

@Repository
public class JpaReportDao extends JpaEntityDao<Report> implements ReportDao {

    public JpaReportDao() {

        super(Report.class);
    }

    public JpaReportDao(Class<Report> reportClass) {

        super(reportClass);
    }
}
