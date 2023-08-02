package org.example.date;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
public class DateCalculatorTest {

    @Test
    public void calculateOverlapMonths() {

        DateCalculator dateCalculator = new DateCalculator();

        final Date firstEmployeeDateFrom = new Date(2012, 1, 1);
        final Date firstEmployeeDateTo = new Date(2022, 12, 31);

        final Date secondEmployeeDateFrom = new Date(2015, 1, 1);
        final Date secondEmployeeDateTo = new Date(2015, 8, 31);

        final int overlappedMonths = dateCalculator.calculateOverlapMonths(firstEmployeeDateFrom, firstEmployeeDateTo,
                secondEmployeeDateFrom, secondEmployeeDateTo);

        assertEquals(overlappedMonths, 9);
    }
}
