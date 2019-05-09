package com.ffxl.platform.util.eap;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.ffxl.platform.schedulerole.calendar.field.ByDay;
import com.ffxl.platform.schedulerole.calendar.field.FrequencyEnum;
import com.ffxl.platform.schedulerole.calendar.field.WeekDayEnum;
import com.ffxl.platform.schedulerole.calendar.impl.DailyRule;
import com.ffxl.platform.schedulerole.calendar.impl.GregorianMonthlyRule;
import com.ffxl.platform.schedulerole.calendar.impl.GregorianYearlyRule;
import com.ffxl.platform.schedulerole.calendar.impl.LunarMonthlyRule;
import com.ffxl.platform.schedulerole.calendar.impl.LunarYearlyRule;
import com.ffxl.platform.schedulerole.calendar.impl.OnceTimeRule;
import com.ffxl.platform.schedulerole.calendar.impl.WeeklyRule;

public class IdGeneratorFactory {

    public static IdGenerator createIdGenerator(){
    	IdGenerator idGenerator = new DefaultIdGenerator();
        return idGenerator;
    }
    
    public static IdGenerator createIdGenerator(IdGeneratorConfig config){
    	IdGenerator idGenerator = new DefaultIdGenerator(config);
        return idGenerator;
    }

}
