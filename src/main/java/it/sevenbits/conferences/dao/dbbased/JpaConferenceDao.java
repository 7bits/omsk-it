package it.sevenbits.conferences.dao.dbbased;

import it.sevenbits.conferences.dao.ConferenceDao;
import it.sevenbits.conferences.domain.Conference;
import org.springframework.stereotype.Repository;

/**
 * Java Persistence API based implementation of the ConferenceDao.
 */
@Repository
public class JpaConferenceDao extends JpaEntityDao<Conference> implements ConferenceDao {

    /**
     * Default constructor for the spring framework annotation based configuration.
     */
    public JpaConferenceDao() {

        super(Conference.class);
    }

    /**
     * Constructor from generic JpaEntityDao.
     * @param conferenceClass generic class type.
     */
    public JpaConferenceDao(Class<Conference> conferenceClass) {

        super(conferenceClass);
    }
}
