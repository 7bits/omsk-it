package it.sevenbits.conferences.service;

import it.sevenbits.conferences.domain.Suggestion;

import java.util.List;

/**
 * Interface for service layer, which works with EntityDao.
 * Suggestion is the primary Entity for that Service.
 */
public interface SuggestionService {

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#add(Object)
     */
    Suggestion addSuggestion(final Suggestion suggestion);

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#remove(Long)
     */
    boolean removeSuggestion(final Long id);

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#update(Object)
     */
    Suggestion updateSuggestion(final Suggestion suggestion);

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#findAll()
     */
    List<Suggestion> findAllSuggestions();

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#findById(Long)
     */
    Suggestion findSuggestionById(final Long id);
}
