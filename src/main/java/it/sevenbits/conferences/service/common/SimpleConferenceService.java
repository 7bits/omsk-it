package it.sevenbits.conferences.service.common;

import it.sevenbits.conferences.dao.ConferenceDao;
import it.sevenbits.conferences.dao.ReportDao;
import it.sevenbits.conferences.domain.Conference;
import it.sevenbits.conferences.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Simple implementation of the ConferenceService.
 */
@Service
public class SimpleConferenceService implements ConferenceService {

    @Autowired
    private ConferenceDao conferenceDao;

    @Autowired
    private ReportDao reportDao;

    @Transactional
    @Override
    public Conference addConference(Conference conference) {

        return conferenceDao.add(conference);
    }

    @Transactional
    @Override
    public boolean removeConference(Long id) {

        return conferenceDao.remove(id);
    }

    @Transactional
    @Override
    public Conference updateConference(Conference conference) {

        return conferenceDao.update(conference);
    }

    @Transactional
    @Override
    public List<Conference> findAllConferences() {

        return conferenceDao.findAll();
    }

    @Transactional
    @Override
    public Conference findConferenceById(Long id) {

        return conferenceDao.findById(id);
    }

    @Override
    public Conference findNextConference() {

        return conferenceDao.findByQuery("select c from Conference c where c.ordinalNumber = (select max(ordinalNumber) from Conference)", null).iterator().next();
    }

    @Override
    public Conference findPastConference() {
        return conferenceDao.findByQuery("select c from Conference c where c.ordinalNumber = (select max(ordinalNumber) from Conference) - 1", null).iterator().next();
    }
}
