package com.ffxl.platform.schedulerole.calendar.impl;

import java.util.Date;

import org.joda.time.DateTime;

import com.ffxl.platform.schedulerole.calendar.Event;
import com.ffxl.platform.schedulerole.calendar.utils.DateTimeUtils;

public class DailyRule extends AbstractRecurRule {


    public DailyRule(Event calendar) {
        super(calendar);
    }

    @Override
    public Date computeNextOccurDate(Date offsetDate) {
        Date startDateTime = getStartDateTime();
        int periodDays = DateTimeUtils.periodDays(startDateTime, offsetDate);
        int nextDays = periodDays + (getInterval() - periodDays % getInterval());
        return DateTimeUtils.plusDays(startDateTime, nextDays);
    }

    @Override
    public Date computeTheLastCountOccurDate() {
        Date recurEndDate = null;
        if(getUntil() != null){
            recurEndDate = getUntil();
        }else if(getCount() != null){
            int days = (getCount() - 1) * getInterval();
            recurEndDate = new DateTime(getStartDateTime()).plusDays(days).toDate();
        }
        return recurEndDate;
        
    }

}
