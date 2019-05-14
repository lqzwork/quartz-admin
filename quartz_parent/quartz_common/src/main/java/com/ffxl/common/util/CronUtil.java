package com.ffxl.common.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public  class CronUtil {
  
  private static final Logger logger = LoggerFactory.getLogger(CronUtil.class);
  
  /**
   * 解析cron表达式出指定条数的时间
   * @param cron
   * @param dateStr
   * @param nums
   * @return
   * @throws Exception
   */
  public  static List<String> cronAlgBuNums(String cron, String dateStr,int nums) throws Exception { 
    List<String> resultList = new ArrayList<String>();
    String nextDateStr = null;
    for(int i=0; i<nums; i++){
      if(i==0){
        nextDateStr = cronAlg( cron,  dateStr);
        resultList.add(nextDateStr);
      }else{
        nextDateStr = cronAlg( cron,  nextDateStr);
        resultList.add(nextDateStr);
      }
    }
    return resultList;
  }
  /**
   * 解析cron表达式
   * @param map key:cron表达式
   *                          value:开始时间
   * @return 
   * @throws Exception
   */
  public static String cronAlg(String cron, String dateStr) throws Exception {  
        CronSequence cronSequence = new CronSequence(cron);  
        Date date =  DateUtil.parseDate(dateStr);
        long nanoTime3 = System.nanoTime();  
        Date date2 = null;  
        try {  
            date2 = cronSequence.next(date);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        long nanoTime4 = System.nanoTime();  
        String str2 = null;  
        if (date2 != null) {  
            str2 = DateUtil.formatStandardDatetime(date2);  
        }  
        logger.info("new method : result date = " + str2 + " , consume " + (nanoTime4 - nanoTime3)/1000 + "us");
        return str2;
}  
  
  
  
}
