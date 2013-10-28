package it.sevenbits.conferences.utils.comparator;

import it.sevenbits.conferences.domain.Conference;

import java.util.Comparator;

/**
 * Compares two Conferences by their ordinal number.
 */
public class ConferenceComparator implements Comparator<Conference> {

    @Override
    public int compare(Conference o1, Conference o2) {

        return o1.getOrdinalNumber().compareTo(o2.getOrdinalNumber());
    }
}
