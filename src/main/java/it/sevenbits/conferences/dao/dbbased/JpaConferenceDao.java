package it.sevenbits.conferences.dao.dbbased;

import it.sevenbits.conferences.dao.ConferenceDao;
import it.sevenbits.conferences.domain.Conference;
import org.springframework.stereotype.Repository;

@Repository
public class JpaConferenceDao extends JpaEntityDao<Conference> implements ConferenceDao {

    public JpaConferenceDao() {

        super(Conference.class);
    }

    public JpaConferenceDao(Class<Conference> conferenceClass) {

        super(conferenceClass);
    }
}
