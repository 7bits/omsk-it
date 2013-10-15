package it.sevenbits.conferences.service;

import it.sevenbits.conferences.domain.Conference;

import java.util.List;

public interface ConferenceService {

    Conference addConference(final Conference conference);

    boolean removeConference(final Long id);

    Conference updateConference(final Conference conference);

    List<Conference> findAllConferences();

    Conference findConferenceById(final Long id);
}
