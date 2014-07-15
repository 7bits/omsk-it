package it.sevenbits.conferences.service.newService;

import it.sevenbits.conferences.model.Report;
import it.sevenbits.conferences.model.User;
import it.sevenbits.conferences.repository.ReportRepository;
import it.sevenbits.conferences.repository.exception.RepositoryException;
import it.sevenbits.conferences.service.exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    /** Default message for ServiceException */
    private static final String SERVICE_EXCEPTION_MESSAGE = "Report Service general exception. ";

    /** Logger */
    private static final Logger LOG = Logger.getLogger(ReportService.class);

    @Autowired
    private ReportRepository reportRepository;

    public List<Report> findAllByUser (final User user) throws ServiceException {
        LOG.info("Searching for reports with user: " + user);
        try {
            return reportRepository.findAllByUser(user);
        } catch (RepositoryException e) {
            LOG.error(SERVICE_EXCEPTION_MESSAGE + "Cannot find report by user.", e);
            throw new ServiceException(SERVICE_EXCEPTION_MESSAGE, e);
        }
    }
}
