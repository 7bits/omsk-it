package it.sevenbits.conferences.repository;

import it.sevenbits.conferences.model.Conference;
import it.sevenbits.conferences.repository.exception.RepositoryException;
import it.sevenbits.conferences.repository.mapper.ConferenceMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
* Repository implementing all methods related to
* Conference entity manipulations
*/
@Repository
public class ConferenceRepository {
    /** Logger */
    private static final Logger LOG = Logger.getLogger(ConferenceRepository.class);

    @Autowired
    private ConferenceMapper conferenceMapper;


    public Conference findLast() throws RepositoryException {
        LOG.info("Searching in database last conference");
        return conferenceMapper.findLast();
    }

    public Conference findLastWithReports() throws RepositoryException{
        LOG.info("Searching in database last conference with reports");
        return conferenceMapper.findLastWithReports();
    }

    public ConferenceMapper getConferenceMapper() {
        return conferenceMapper;
    }

    public void setConferenceMapper(ConferenceMapper conferenceMapper) {
        this.conferenceMapper = conferenceMapper;
    }
}