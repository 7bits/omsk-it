package it.sevenbits.conferences.service;

import it.sevenbits.conferences.domain.Reporter;

import java.util.List;

public interface ReporterService {

    Reporter addReporter(final Reporter reporter);

    boolean removeReporter(final Long id);

    Reporter updateReporter(final Reporter reporter);

    List<Reporter> findAllReporters();

    Reporter findReporterById(final Long id);
}
