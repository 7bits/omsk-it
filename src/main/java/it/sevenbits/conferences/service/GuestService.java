package it.sevenbits.conferences.service;

import it.sevenbits.conferences.domain.Guest;

import java.util.List;

/**
 * Interface for service layer, which works with EntityDao.
 * Guest is the primary Entity for that Service.
 */
public interface GuestService {

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#add(Object)
     */
    Guest addGuest(final Guest guest);

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#remove(Long)
     */
    boolean removeGuest(final Long id);

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#update(Object)
     */
    Guest updateGuest(final Guest guest);

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#findAll()
     */
    List<Guest> findAllGuests();

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#findById(Long)
     */
    Guest findGuestById(final Long id);

    /**
     * Search guest which login and conference like necessary.
     * @param login user's login
     * @param conferenceId guest's conference
     * @return guest - if he is exists
     *         null  - if doesnt exist
     */
    Guest findGuestWithLoginAndConferenceLike(final String login, final long conferenceId);
}
