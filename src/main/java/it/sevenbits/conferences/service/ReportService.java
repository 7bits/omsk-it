package it.sevenbits.conferences.service;

import it.sevenbits.conferences.domain.Report;

import java.util.List;

public interface ReportService {

    Report addReport(final Report report);

    boolean removeReport(final Long id);

    Report updateReport(final Report report);

    List<Report> findAllReports();

    Report findReportById(final Long id);
}
