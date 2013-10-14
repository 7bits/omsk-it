package it.sevenbits.conferences.dao;

import it.sevenbits.conferences.domain.Report;

import java.util.List;

public interface ReportDao {

    Report addReport(final Report report);

    boolean removeReport(final Long id);

    Report updateReport(final Report report);

    List<Report> findAllReports();

    Report findReportById(final Long id);
}
