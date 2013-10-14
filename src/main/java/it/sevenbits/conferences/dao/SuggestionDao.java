package it.sevenbits.conferences.dao;

import it.sevenbits.conferences.domain.Suggestion;

import java.util.List;

public interface SuggestionDao {

    Suggestion addSuggestion(final Suggestion suggestion);

    boolean removeSuggestion(final Long id);

    Suggestion updateSuggestion(final Suggestion suggestion);

    List<Suggestion> findAllSuggestions();

    Suggestion findSuggestionById(final Long id);
}
