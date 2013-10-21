package it.sevenbits.conferences.dao.dbbased;

import it.sevenbits.conferences.dao.GuestDao;
import it.sevenbits.conferences.domain.Guest;
import org.springframework.stereotype.Repository;

@Repository
public class JpaGuestDao extends JpaEntityDao<Guest> implements GuestDao {

    public JpaGuestDao() {

        super(Guest.class);
    }

    public JpaGuestDao(Class<Guest> guestClass) {

        super(guestClass);
    }
}
