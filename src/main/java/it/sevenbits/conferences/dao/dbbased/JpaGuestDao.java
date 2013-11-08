package it.sevenbits.conferences.dao.dbbased;

import it.sevenbits.conferences.dao.GuestDao;
import it.sevenbits.conferences.domain.Guest;
import org.springframework.stereotype.Repository;

/**
 * Java Persistence API based implementation of the GuestDao.
 */
@Repository
public class JpaGuestDao extends JpaEntityDao<Guest> implements GuestDao {

    /**
     * Default constructor for the spring framework annotation based configuration.
     */
    public JpaGuestDao() {

        super(Guest.class);
    }

    /**
     * Constructor from generic JpaEntityDao.
     * @param guestClass generic class type.
     */
    public JpaGuestDao(Class<Guest> guestClass) {

        super(guestClass);
    }
}
