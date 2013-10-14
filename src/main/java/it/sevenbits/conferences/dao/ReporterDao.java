package it.sevenbits.conferences.dao;

import it.sevenbits.conferences.domain.Reporter;

import java.util.List;

public interface ReporterDao {

    Reporter addReporter(final Reporter reporter);

    boolean removeReporter(final Long id);

    Reporter updateReporter(final Reporter reporter);

    List<Reporter> findAllReporters();

    Reporter findReporterById(final Long id);
}
