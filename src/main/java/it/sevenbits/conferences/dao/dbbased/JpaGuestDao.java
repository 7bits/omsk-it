package it.sevenbits.conferences.dao.dbbased;

import it.sevenbits.conferences.dao.GuestDao;
import it.sevenbits.conferences.domain.Guest;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JpaGuestDao implements GuestDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Guest addGuest(Guest guest) {

        entityManager.persist(guest);
        return guest;
    }

    @Override
    public boolean removeGuest(Long id) {

        Guest guest = entityManager.find(Guest.class, id);

        if (guest != null) {
            entityManager.remove(guest);
            return true;
        }
        return false;
    }

    @Override
    public Guest updateGuest(Guest guest) {

        return entityManager.merge(guest);
    }

    @Override
    public List<Guest> findAllGuests() {

        return entityManager.
                createQuery("select g from guest g", Guest.class).
                getResultList();
    }

    @Override
    public Guest findGuestById(Long id) {

        return entityManager.find(Guest.class, id);
    }
}
