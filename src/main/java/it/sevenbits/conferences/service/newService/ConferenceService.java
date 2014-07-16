package it.sevenbits.conferences.service.newService;

import it.sevenbits.conferences.model.Conference;
import it.sevenbits.conferences.repository.ConferenceRepository;
import it.sevenbits.conferences.repository.exception.RepositoryException;
import it.sevenbits.conferences.service.exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ConferenceService {
    /** Default message for ServiceException */
    private static final String SERVICE_EXCEPTION_MESSAGE = "Conference Service general exception";

    /** Logger */
    private static final Logger LOG = Logger.getLogger(ConferenceService.class);

    @Autowired
    private ConferenceRepository conferenceRepository;

    public Conference findLast() throws ServiceException {
        LOG.info("Searching last conference");
        try {
            return conferenceRepository.findLast();
        } catch (RepositoryException e) {
            LOG.error(SERVICE_EXCEPTION_MESSAGE + "Cannot find last conference.", e);
            throw new ServiceException(SERVICE_EXCEPTION_MESSAGE, e);
        }
    }

    public Conference findLastWithReports() throws ServiceException {
        LOG.info("Searching last conference with report");
        try {
            return conferenceRepository.findLastWithReports();
        } catch (RepositoryException e) {
            LOG.error(SERVICE_EXCEPTION_MESSAGE + "Cannot find last conference with reports.", e);
            throw new ServiceException(SERVICE_EXCEPTION_MESSAGE, e);
        }
    }
}