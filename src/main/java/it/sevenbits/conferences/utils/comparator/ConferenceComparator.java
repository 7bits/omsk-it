package it.sevenbits.conferences.utils.comparator;

import java.util.Comparator;

import it.sevenbits.conferences.domain.Conference;

/**
 * Compares two Conferences by their ordinal number.
 */
public class ConferenceComparator implements Comparator<Conference> {

    @Override
    public int compare(final Conference o1, final Conference o2) {

        return o1.getOrdinalNumber().compareTo(o2.getOrdinalNumber());
    }
}
