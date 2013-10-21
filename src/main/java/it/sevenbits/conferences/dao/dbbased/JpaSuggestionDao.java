package it.sevenbits.conferences.dao.dbbased;

import it.sevenbits.conferences.dao.SuggestionDao;
import it.sevenbits.conferences.domain.Suggestion;
import org.springframework.stereotype.Repository;

@Repository
public class JpaSuggestionDao extends JpaEntityDao<Suggestion> implements SuggestionDao {

    public JpaSuggestionDao() {

        super(Suggestion.class);
    }

    public JpaSuggestionDao(Class<Suggestion> suggestionClass) {

        super(suggestionClass);
    }
}
