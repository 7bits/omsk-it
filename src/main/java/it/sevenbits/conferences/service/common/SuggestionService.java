package it.sevenbits.conferences.service.common;

import it.sevenbits.conferences.dao.SuggestionDao;
import it.sevenbits.conferences.domain.Suggestion;
import it.sevenbits.conferences.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Simple implementation of the SuggestionService.
 */
@Service
public class SuggestionService implements SuggestionService {

    @Autowired
    private SuggestionDao suggestionDao;

    @Transactional
    @Override
    public Suggestion addSuggestion(final Suggestion suggestion) {

        return suggestionDao.add(suggestion);
    }

    @Transactional
    @Override
    public boolean removeSuggestion(final Long id) {

        return suggestionDao.remove(id);
    }

    @Transactional
    @Override
    public Suggestion updateSuggestion(final Suggestion suggestion) {

        return suggestionDao.update(suggestion);
    }

    @Transactional
    @Override
    public List<Suggestion> findAllSuggestions() {

        return suggestionDao.findAll();
    }

    @Transactional
    @Override
    public Suggestion findSuggestionById(final Long id) {

        return suggestionDao.findById(id);
    }
}
