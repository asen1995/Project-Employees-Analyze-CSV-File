package org.example.date;

import java.util.Calendar;
import java.util.Date;

public class DateCalculator {
    public int calculateOverlapMonths(Date dateFrom1, Date dateTo1, Date dateFrom2, Date dateTo2) {
        // If any of the date ranges is null or there is no overlap, return 0
        if (dateFrom1 == null || dateTo1 == null || dateFrom2 == null || dateTo2 == null
                || dateFrom1.after(dateTo2) || dateTo1.before(dateFrom2)) {
            return 0;
        }

        // Find the start and end dates of the overlap
        Date start = dateFrom1.after(dateFrom2) ? dateFrom1 : dateFrom2;
        Date end = dateTo1.before(dateTo2) ? dateTo1 : dateTo2;

        // Calculate the overlapping duration in months
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(start);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(end);
        int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
        return diffMonth + 1; // +1 to include the end month in the overlap
    }
}
