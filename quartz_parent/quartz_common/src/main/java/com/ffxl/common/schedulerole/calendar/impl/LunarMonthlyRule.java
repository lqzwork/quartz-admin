package com.ffxl.common.schedulerole.calendar.impl;

import java.util.Date;

import org.joda.time.DateTime;

import com.ffxl.common.schedulerole.calendar.Event;
import com.ffxl.common.schedulerole.calendar.utils.Lunar;
import com.ffxl.common.schedulerole.calendar.utils.LunarMap;

public class LunarMonthlyRule extends AbstractMonthlyRule {

    public LunarMonthlyRule(Event calendar) {
        super(calendar);
        this.ruleHelper = new LunarCalenarRuleHelper();
    }

    @Override
    protected Date getNextMonthFirst(Date theDay) {
        Lunar theDayL = new Lunar(theDay).nextMonthFirst();
        return new DateTime(LunarMap.getDate(theDayL)).toDate();
    }

    @Override
    protected Date getNextOccurMonthFirst(Date theDay) {
        Lunar theDayL = new Lunar(theDay);
        Lunar nextOccurMonthFirstL =
                new Lunar(theDayL.getYear(), theDayL.getMonth(), 1, theDayL.isLeap());
        return new DateTime(LunarMap.getDate(nextOccurMonthFirstL)).withMillisOfDay(getStartTime() * 60 * 1000).toDate();
    }

    @Override
    public Date computeTheLastCountOccurDate() {
        return null;
    }
}
