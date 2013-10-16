package it.sevenbits.conferences.service.common;

import it.sevenbits.conferences.dao.ConferenceDao;
import it.sevenbits.conferences.domain.Conference;
import it.sevenbits.conferences.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SimpleConferenceService implements ConferenceService {

    @Autowired
    private ConferenceDao conferenceDao;

    @Transactional
    @Override
    public Conference addConference(Conference conference) {

        return conferenceDao.addConference(conference);
    }

    @Transactional
    @Override
    public boolean removeConference(Long id) {

        return conferenceDao.removeConference(id);
    }

    @Transactional
    @Override
    public Conference updateConference(Conference conference) {

        return conferenceDao.updateConference(conference);
    }

    @Transactional
    @Override
    public List<Conference> findAllConferences() {

        return conferenceDao.findAllConferences();
    }

    @Transactional
    @Override
    public Conference findConferenceById(Long id) {

        return conferenceDao.findConferenceById(id);
    }
}
