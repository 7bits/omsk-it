package it.sevenbits.conferences.utils.date;

import java.util.Calendar;


public class NextDateConference {

    public static long getNextDate(long date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date * 1000);
        int month = calendar.get(Calendar.MONTH);
        while ((calendar.get(Calendar.DAY_OF_WEEK) != 7) || (calendar.get(Calendar.MONTH)) == month) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        return calendar.getTimeInMillis()/1000;
    }
}
