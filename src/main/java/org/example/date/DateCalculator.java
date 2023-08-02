package org.example.date;

import java.util.Calendar;
import java.util.Date;

public class DateCalculator {
    public int calculateOverlapMonths(Date firstEmployeeDateFrom, Date firstEmployeeDateTo, Date secondEmployeeDateFrom, Date secondEmployeeDateTo) {
        // If any of the date ranges is null or there is no overlap, return 0
        if (firstEmployeeDateFrom == null || firstEmployeeDateTo == null || secondEmployeeDateFrom == null || secondEmployeeDateTo == null
                || firstEmployeeDateFrom.after(secondEmployeeDateTo) || firstEmployeeDateTo.before(secondEmployeeDateFrom)) {
            return 0;
        }

        // Find the start and end dates of the overlap
        Date start = firstEmployeeDateFrom.after(secondEmployeeDateFrom) ? firstEmployeeDateFrom : secondEmployeeDateFrom;
        Date end = firstEmployeeDateTo.before(secondEmployeeDateTo) ? firstEmployeeDateTo : secondEmployeeDateTo;

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
