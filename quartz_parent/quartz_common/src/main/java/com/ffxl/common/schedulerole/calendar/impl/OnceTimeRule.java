package com.ffxl.common.schedulerole.calendar.impl;

import java.util.Date;

import com.ffxl.common.schedulerole.calendar.Event;
import com.ffxl.common.schedulerole.calendar.utils.DateTimeUtils;

public class OnceTimeRule extends AbstractRule {

    public OnceTimeRule(Event calendar) {
        super(calendar);
    }

    public boolean includes(Date theDate) {
        if(theDate == null)
            return false;
        return (DateTimeUtils.isSameDay(getStartDate(), theDate));
    }

    public Date nextOccurDate(Date offsetDate) {
        if(offsetDate == null)
            return null;
        if(DateTimeUtils.compareTo(offsetDate, getStartDateTime()) < 0){
            return getStartDateTime();
        }else{
            return null;
        }
    }

    public Date getRecurEndDate() {
        return getStartDateTime();
    }

}
