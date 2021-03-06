package com.ffxl.common.schedulerole.calendar.impl;

import java.util.Date;

import org.joda.time.DateTime;

import com.ffxl.common.schedulerole.calendar.Event;
import com.ffxl.common.schedulerole.calendar.utils.DateTimeUtils;

public class GregorianYearlyRule extends AbstractYearlyRule {

    public GregorianYearlyRule(Event calendar) {
        super(calendar);
    }


    @Override
    protected Date getNextYearFirst(Date offsetDate) {
        return DateTimeUtils
                .theNextYearFirst(offsetDate);
    }

    @Override
    protected Date getNextYearMonthFirst(Date offsetDate) {
        DateTime offSetDt = new DateTime(offsetDate);
        DateTime startTime = new DateTime(getStartDateTime());
        int year = offSetDt.getYear() + (offSetDt.getYear() - startTime.getYear()) % getInterval();
        int month = getByMonthSet().iterator().next();
        
        Date nextOccurMonthFirst = new DateTime(year, month, 1, getStartTime()/60, getStartTime()%60).toDate();
        
        return nextOccurMonthFirst;
    }

    @Override
    public Date computeTheLastCountOccurDate() {
        int years = (getCount() - 1) * getInterval();
        return DateTimeUtils.theYearEnd(DateTimeUtils.plusYears(getStartDateTime(), years));
    }


}
