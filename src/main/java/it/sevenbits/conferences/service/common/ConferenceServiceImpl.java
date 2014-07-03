package it.sevenbits.conferences.service.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.sevenbits.conferences.dao.ConferenceDao;
import it.sevenbits.conferences.dao.ReportDao;
import it.sevenbits.conferences.domain.Company;
import it.sevenbits.conferences.domain.Conference;
import it.sevenbits.conferences.service.ConferenceService;

/**
 * Simple implementation of the ConferenceService.
 */
@Service
public class ConferenceServiceImpl implements ConferenceService {

    @Autowired
    private ConferenceDao conferenceDao;

    @Autowired
    private ReportDao reportDao;

    @Transactional
    @Override
    public Conference addConference(final Conference conference) {

        return conferenceDao.add(conference);
    }

    @Transactional
    @Override
    public boolean removeConference(final Long id) {

        return conferenceDao.remove(id);
    }

    @Transactional
    @Override
    public Conference updateConference(final Conference conference) {

        return conferenceDao.update(conference);
    }

    @Transactional
    @Override
    public List<Conference> findAllConferences() {

        return conferenceDao.findAll();
    }

    @Transactional
    @Override
    public Conference findConferenceById(final Long id) {

        return conferenceDao.findById(id);
    }

    @Override
    public Conference findLastConference() {

        return conferenceDao.findByQuery(
                "select c from Conference c where c.ordinalNumber = (select max(ordinalNumber) from Conference)", null
        ).iterator().next();
    }

    @Override
    public Conference findLastConferenceWithReports() {
        return conferenceDao.findByQuery(
                "SELECT c FROM Report as r INNER JOIN r.conference as c GROUP BY c.id ORDER BY date desc", null
        ).iterator().next();
    }

    @Override
    public List<Conference> findPastConference() {
        List<Conference> conferences = findAllConferences();
        List<Conference> pastConferences = new Vector<Conference>();
        long today = System.currentTimeMillis() / 1000;

        for (Conference conference : conferences) {
            if (conference.getDate() < today) {
                pastConferences.add(conference);
            }
        }
        return pastConferences;
    }

    @Override
    public List<Company> findAllCompany() {
        List<Conference>  conferences = conferenceDao.findByQuery("select c from Conference c group by c.company", null);
        Iterator<Conference> conferenceIterator = conferences.iterator();
        List<Company> companies = new ArrayList<Company>();
        Company company;
        while (conferenceIterator.hasNext()) {
            company = conferenceIterator.next().getCompany();
            if (null != company) {
                companies.add(company);
            }
        }
        return companies;
    }

    @Override
    public List<Conference> findConferenceWithReports() {
        return conferenceDao.findByQuery(
                "SELECT c FROM Report as r INNER JOIN r.conference as c GROUP BY c.id ORDER BY date desc", null
        );
    }
}
