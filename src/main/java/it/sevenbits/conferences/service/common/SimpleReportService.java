package it.sevenbits.conferences.service.common;

import it.sevenbits.conferences.dao.ReportDao;
import it.sevenbits.conferences.domain.Report;
import it.sevenbits.conferences.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SimpleReportService implements ReportService {

    @Autowired
    private ReportDao reportDao;

    @Transactional
    @Override
    public Report addReport(Report report) {

        return reportDao.addReport(report);
    }

    @Transactional
    @Override
    public boolean removeReport(Long id) {

        return reportDao.removeReport(id);
    }

    @Transactional
    @Override
    public Report updateReport(Report report) {

        return reportDao.updateReport(report);
    }

    @Transactional
    @Override
    public List<Report> findAllReports() {

        return reportDao.findAllReports();
    }

    @Transactional
    @Override
    public Report findReportById(Long id) {

        return reportDao.findReportById(id);
    }
}
