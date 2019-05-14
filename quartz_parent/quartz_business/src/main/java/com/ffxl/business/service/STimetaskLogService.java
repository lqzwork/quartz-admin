package com.ffxl.business.service;

import java.util.Date;

import com.ffxl.dao.model.STimetaskLog;
import com.ffxl.dao.model.STimetaskLogExample;
import com.ffxl.common.core.GenericService;

 /**
 * Generate By liqz and liyj
 **/
public interface STimetaskLogService extends GenericService<STimetaskLog, STimetaskLogExample, String> {
     /**
     * According to the model information query object  
     * @param BaseSTimetaskLog
     * @return 
     **/
    STimetaskLog queryByModel(STimetaskLog sTimetaskLog);
    
    /**
     * 清除指定时间之前的log记录
     * @param deleteDateStr
     *
     */
	int deleteLog(Date deleteDateStr);
}