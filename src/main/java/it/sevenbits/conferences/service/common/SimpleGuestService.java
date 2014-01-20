package it.sevenbits.conferences.service.common;

import it.sevenbits.conferences.dao.GuestDao;
import it.sevenbits.conferences.domain.Guest;
import it.sevenbits.conferences.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Transactional
    @Override
    public Guest findGuestWithLoginAndConferenceLike(final String login, final long conference_id) {
        Map<String, Object> params = new HashMap<>();
        params.put("login", login);
        params.put("conference_id", conference_id);
        String query = "SELECT g FROM Guest g WHERE g.conference.id =:conference_id AND g.user.login =:login";
        List<Guest> guestsList = guestDao.findByQuery(query,params);
        if (guestsList == null || guestsList.isEmpty()) {
            return null;
        }
        return guestsList.get(0);
    }
}
