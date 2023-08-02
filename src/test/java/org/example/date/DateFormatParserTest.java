package org.example.date;

import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

import static org.junit.Assert.*;

public class DateFormatParserTest {

    @Test
    public void parseDate() throws ParseException {

        DateFormatParser dateFormatParser = DateFormatParser.getInstance();

        final Date date = dateFormatParser.parseDate("2012-01-01");
        assertEquals(date.getYear(), 112);
        assertEquals(date.getMonth(), 0);
        assertEquals(date.getDate(), 1);
    }

    @Test(expected = ParseException.class)
    public void invalidFormatDate() throws ParseException {

        DateFormatParser dateFormatParser = DateFormatParser.getInstance();

        dateFormatParser.parseDate("2012D01D01");

    }



}
