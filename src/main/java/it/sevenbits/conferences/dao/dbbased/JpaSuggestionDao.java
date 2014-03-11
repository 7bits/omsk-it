package it.sevenbits.conferences.dao.dbbased;

import it.sevenbits.conferences.dao.SuggestionDao;
import it.sevenbits.conferences.domain.Suggestion;
import org.springframework.stereotype.Repository;

/**
 * Java Persistence API based implementation of the SuggestionDao.
 */
@Repository
public class JpaSuggestionDao extends JpaEntityDao<Suggestion> implements SuggestionDao {

    /**
     * Default constructor for the spring framework annotation based configuration.
     */
    public JpaSuggestionDao() {

        super(Suggestion.class);
    }

    /**
     * Constructor from generic JpaEntityDao.
     * @param suggestionClass generic class type.
     */
    public JpaSuggestionDao(final Class<Suggestion> suggestionClass) {

        super(suggestionClass);
    }
}
