package org.example.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatParser {

    private static DateFormatParser instance = new DateFormatParser(
            new SimpleDateFormat("yyyy-MM-dd"),
            new SimpleDateFormat("yyyy/MM/dd"),
            new SimpleDateFormat("yyyy.MM.dd"),
            new SimpleDateFormat("dd-MM-yyyy"),
            new SimpleDateFormat("dd/MM/yyyy"),
            new SimpleDateFormat("dd.MM.yyyy"),
            new SimpleDateFormat("dd/MMM/yyyy"),
            new SimpleDateFormat("dd-MMM-yyyy"),
            new SimpleDateFormat("dd/MMMM/yyyy"),
            new SimpleDateFormat("dd-MMMM-yyyy"),
            new SimpleDateFormat("dd MMMM yyyy"),
            new SimpleDateFormat("dd MMMM, yyyy"),
            new SimpleDateFormat("dd MMMM,yyyy"),
            new SimpleDateFormat("dd MMMM,yyyy"),
            new SimpleDateFormat("dd MMMM,yyyy"));

    private final DateFormat[] dateFormats;

    private DateFormatParser(DateFormat... dateFormats) {
        this.dateFormats = dateFormats;
    }

    public static DateFormatParser getInstance() {
        return instance;
    }

    public Date parseDate(String dateString) throws ParseException {
        for (DateFormat dateFormat : dateFormats) {
            try {
                return dateFormat.parse(dateString);
            } catch (ParseException ignored) {
            }
        }
        throw new ParseException(String.format("Date format not supported or recognized for this date : %s .", dateString), 0);
    }
}
