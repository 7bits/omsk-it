package it.sevenbits.conferences.dao.dbbased;

import it.sevenbits.conferences.dao.SuggestionDao;
import it.sevenbits.conferences.domain.Suggestion;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JpaSuggestionDao implements SuggestionDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Suggestion addSuggestion(Suggestion suggestion) {

        entityManager.persist(suggestion);
        return suggestion;
    }

    @Override
    public boolean removeSuggestion(Long id) {

        Suggestion suggestion = entityManager.find(Suggestion.class, id);

        if (suggestion != null) {
            entityManager.remove(suggestion);
            return true;
        }
        return false;
    }

    @Override
    public Suggestion updateSuggestion(Suggestion suggestion) {

        return entityManager.merge(suggestion);
    }

    @Override
    public List<Suggestion> findAllSuggestions() {

        return entityManager.
                createQuery("select s from suggestion s", Suggestion.class).
                getResultList();
    }

    @Override
    public Suggestion findSuggestionById(Long id) {

        return entityManager.find(Suggestion.class, id);
    }
}
