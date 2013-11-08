package it.sevenbits.conferences.service.common;

import it.sevenbits.conferences.dao.GuestDao;
import it.sevenbits.conferences.domain.Guest;
import it.sevenbits.conferences.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Simple implementation of the GuestService.
 */
@Service
public class SimpleGuestService implements GuestService {

    @Autowired
    private GuestDao guestDao;

    @Transactional
    @Override
    public Guest addGuest(Guest guest) {

        return guestDao.add(guest);
    }

    @Transactional
    @Override
    public boolean removeGuest(Long id) {

        return guestDao.remove(id);
    }

    @Transactional
    @Override
    public Guest updateGuest(Guest guest) {

        return guestDao.update(guest);
    }

    @Transactional
    @Override
    public List<Guest> findAllGuests() {

        return guestDao.findAll();
    }

    @Transactional
    @Override
    public Guest findGuestById(Long id) {

        return guestDao.findById(id);
    }
}
