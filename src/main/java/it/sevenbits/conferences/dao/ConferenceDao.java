package it.sevenbits.conferences.dao;

import it.sevenbits.conferences.domain.Conference;

import java.util.List;

public interface ConferenceDao {

    Conference addConference(final Conference conference);

    boolean removeConference(final Long id);

    Conference updateConference(final Conference conference);

    List<Conference> findAllConferences();

    Conference findConferenceById(final Long id);
}
