package it.sevenbits.conferences.dao;

import it.sevenbits.conferences.domain.Guest;

import java.util.List;

public interface GuestDao {

    Guest addGuest(final Guest guest);

    boolean removeGuest(final Long id);

    Guest updateGuest(final Guest guest);

    List<Guest> findAllGuests();

    Guest findGuestById(final Long id);
}
