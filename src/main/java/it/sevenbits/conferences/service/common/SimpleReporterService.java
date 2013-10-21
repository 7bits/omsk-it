package it.sevenbits.conferences.service.common;

import it.sevenbits.conferences.dao.ReporterDao;
import it.sevenbits.conferences.domain.Reporter;
import it.sevenbits.conferences.service.ReporterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SimpleReporterService implements ReporterService {

    @Autowired
    private ReporterDao reporterDao;

    @Transactional
    @Override
    public Reporter addReporter(Reporter reporter) {

        return reporterDao.add(reporter);
    }

    @Transactional
    @Override
    public boolean removeReporter(Long id) {

        return reporterDao.remove(id);
    }

    @Transactional
    @Override
    public Reporter updateReporter(Reporter reporter) {

        return reporterDao.update(reporter);
    }

    @Transactional
    @Override
    public List<Reporter> findAllReporters() {

        return reporterDao.findAll();
    }

    @Transactional
    @Override
    public Reporter findReporterById(Long id) {

        return reporterDao.findById(id);
    }
}
