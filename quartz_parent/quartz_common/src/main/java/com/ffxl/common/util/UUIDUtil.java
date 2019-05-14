package com.ffxl.common.util;

import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.time.DateFormatUtils;

/**
 * UUID生成
 * 
 */
public class UUIDUtil {

    private UUIDUtil() {
    }

    public final static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 获取16位主键（日期+4位随机数）
    * @return
    * @author: jiawei
    * @2015年9月21日
     */
    public final static String getRequestId(){
        Date date =  new Date();
        String dateStr = DateFormatUtils.format(date, "yyMMddHHmmss");
        String s = RandomStringUtils.randomNumeric(4);  
        return dateStr+s;
    }
}
