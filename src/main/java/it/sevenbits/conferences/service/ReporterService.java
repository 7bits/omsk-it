package it.sevenbits.conferences.service;

import it.sevenbits.conferences.domain.Reporter;

import java.util.List;

/**
 * Interface for service layer, which works with EntityDao.
 * Reporter is the primary Entity for that Service.
 */
public interface ReporterService {

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#add(Object)
     */
    Reporter addReporter(final Reporter reporter);

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#remove(Long)
     */
    boolean removeReporter(final Long id);

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#update(Object)
     */
    Reporter updateReporter(final Reporter reporter);

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#findAll()
     */
    List<Reporter> findAllReporters();

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#findById(Long)
     */
    Reporter findReporterById(final Long id);
}
