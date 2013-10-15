package it.sevenbits.conferences.dao.dbbased;

import it.sevenbits.conferences.dao.ConferenceDao;
import it.sevenbits.conferences.domain.Conference;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JpaConferenceDao implements ConferenceDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Conference addConference(Conference conference) {

        entityManager.persist(conference);
        return conference;
    }

    @Override
    public boolean removeConference(Long id) {

        Conference conference = entityManager.find(Conference.class, id);

        if (conference != null) {
            entityManager.remove(conference);
            return true;
        }
        return false;
    }

    @Override
    public Conference updateConference(Conference conference) {

        return entityManager.merge(conference);
    }

    @Override
    public List<Conference> findAllConferences() {

        return entityManager.
                createQuery("select c from conference c", Conference.class).
                getResultList();
    }

    @Override
    public Conference findConferenceById(Long id) {

        return entityManager.find(Conference.class, id);
    }
}
