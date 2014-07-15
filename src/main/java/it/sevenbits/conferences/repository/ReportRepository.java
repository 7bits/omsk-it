package it.sevenbits.conferences.repository;

import it.sevenbits.conferences.model.Report;
import it.sevenbits.conferences.model.User;
import it.sevenbits.conferences.repository.exception.RepositoryException;
import it.sevenbits.conferences.repository.mapper.ReportMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository implementing all methods related to
 * Report entity manipulations
 */
@Repository
public class ReportRepository {

    /** Logger */
    private static final Logger LOG = Logger.getLogger(ReportRepository.class);

    /** Message for RepositoryException */
    private static final String REPOSITORY_USER_IS_NULL_MESSAGE = "User is null";

    @Autowired
    private ReportMapper reportMapper;


    public List<Report> findAllByUser (final User user) throws RepositoryException {
        LOG.info("Searching in database for report with user:" + user);
        if (user == null || user.getId() == null) {
            LOG.error("Cannot lookup report with null user in database");
            throw new RepositoryException(REPOSITORY_USER_IS_NULL_MESSAGE);
        }
        return reportMapper.findAllByUser(user);
    }


    public ReportMapper getReportMapper() {
        return reportMapper;
    }

    public void setReportMapper(ReportMapper reportMapper) {
        this.reportMapper = reportMapper;
    }
}
