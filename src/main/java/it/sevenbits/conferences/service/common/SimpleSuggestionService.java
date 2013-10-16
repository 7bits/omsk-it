package it.sevenbits.conferences.service.common;

import it.sevenbits.conferences.dao.SuggestionDao;
import it.sevenbits.conferences.domain.Suggestion;
import it.sevenbits.conferences.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SimpleSuggestionService implements SuggestionService {

    @Autowired
    private SuggestionDao suggestionDao;

    @Transactional
    @Override
    public Suggestion addSuggestion(Suggestion suggestion) {

        return suggestionDao.addSuggestion(suggestion);
    }

    @Transactional
    @Override
    public boolean removeSuggestion(Long id) {

        return suggestionDao.removeSuggestion(id);
    }

    @Transactional
    @Override
    public Suggestion updateSuggestion(Suggestion suggestion) {

        return suggestionDao.updateSuggestion(suggestion);
    }

    @Transactional
    @Override
    public List<Suggestion> findAllSuggestions() {

        return suggestionDao.findAllSuggestions();
    }

    @Transactional
    @Override
    public Suggestion findSuggestionById(Long id) {

        return suggestionDao.findSuggestionById(id);
    }
}
