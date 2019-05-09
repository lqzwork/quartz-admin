package com.ffxl.platform.schedulerole.calendar.impl;

import java.util.Date;

import org.joda.time.DateTime;

import com.ffxl.platform.schedulerole.calendar.Event;
import com.ffxl.platform.schedulerole.calendar.utils.Lunar;
import com.ffxl.platform.schedulerole.calendar.utils.LunarMap;

public class LunarYearlyRule extends AbstractYearlyRule {

    public LunarYearlyRule(Event calendar) {
        super(calendar);
    }


    @Override
    protected Date getNextYearFirst(Date theDay) {
        Lunar theDayL = new Lunar(theDay);
        return new DateTime(LunarMap.getDate(new Lunar(theDayL.getYear() + 1, 1, 1, false))).toDate();
    }

    @Override
    protected Date getNextYearMonthFirst(Date theDay) {
        Lunar theDayL = new Lunar(theDay);
        int year = theDayL.getYear() + 1;
        int month = getByMonthSet().iterator().next();
        Lunar theNextYearMonthFirstL = new Lunar(year, month, 1, false);
        return new DateTime(LunarMap.getDate(theNextYearMonthFirstL)).withMillisOfDay(getStartTime() * 60 * 1000).toDate();
        
    }

    @Override
    public Date computeTheLastCountOccurDate() {
        return null;
    }


}
