package org.example.model;

import java.util.Date;

public class EmploymentPeriod {
    private final Date dateFrom;
    private final Date dateTo;

    public EmploymentPeriod(Date dateFrom, Date dateTo) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }
}

