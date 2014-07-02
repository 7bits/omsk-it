package it.sevenbits.conferences.service;

import java.util.List;

import it.sevenbits.conferences.domain.Company;
import it.sevenbits.conferences.domain.Conference;

/**
 * Interface for service layer, which works with EntityDao.
 * Conference is the primary Entity for that Service.
 */
public interface ConferenceService {

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#add(Object)
     */
    Conference addConference(final Conference conference);

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#remove(Long)
     */
    boolean removeConference(final Long id);

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#update(Object)
     */
    Conference updateConference(final Conference conference);

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#findAll()
     */
    List<Conference> findAllConferences();

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#findById(Long)
     */
    Conference findConferenceById(final Long id);

    /**
     * Finds an Conference with the biggest ordinal number.
     * @return the found Conference, or null if the Conference does not exist or an error occurs.
     * @see it.sevenbits.conferences.dao.EntityDao#findByQuery(String, java.util.Map)
     */
    Conference findLastConference();

    /**
     * Finds an last Conference
     * @return the found last Conference, or null if the Conference does not exist or an error occurs.
     * @see it.sevenbits.conferences.dao.EntityDao#findByQuery(String, java.util.Map)
     */
    Conference findLastConferenceWithReports();

    /**
     * Find an all past Conference
     * @return the found all past Conference, or null if the Conference does not exist or an error occurs.
     * @see it.sevenbits.conferences.dao.EntityDao#findByQuery(String, java.util.Map)
     */
    List<Conference> findPastConference();

    /**
     * Find an all Company
     * @return the found all Company that held the conference, or null if the Conference does not exist or an error occurs.
     * @see it.sevenbits.conferences.dao.EntityDao#findByQuery(String, java.util.Map)
     */
    List<Company> findAllCompany();
}
