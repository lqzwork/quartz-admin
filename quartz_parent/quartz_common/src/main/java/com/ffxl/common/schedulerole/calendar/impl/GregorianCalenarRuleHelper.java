package com.ffxl.common.schedulerole.calendar.impl;

import java.util.Date;

import org.joda.time.DateTime;

import com.ffxl.common.schedulerole.calendar.utils.DateTimeUtils;

public class GregorianCalenarRuleHelper extends AbstractMutliCalendarRuleHelper {

    @Override
    protected int getMaxDayOfMonth(Date theDay) {
        return new DateTime(theDay).dayOfMonth().getMaximumValue();
    }
    
    @Override
    protected int getMonthFirstDayOfWeek(Date theDay) {
        return new DateTime(DateTimeUtils.theMonthFirst(theDay)).getDayOfWeek();
    }
    
    @Override
    protected int getMonthEndDayOfWeek(Date theDay) {
        int monthEndDayOfWeek = new DateTime(DateTimeUtils.theMonthEnd(theDay)).getDayOfWeek();
        return monthEndDayOfWeek;
    }
}
