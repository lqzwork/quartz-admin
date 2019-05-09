package com.ffxl.cloud.service.impl;

import com.ffxl.cloud.mapper.STimetaskLogMapper;
import com.ffxl.cloud.model.STimetaskLog;
import com.ffxl.cloud.model.STimetaskLogExample;
import com.ffxl.cloud.model.base.BaseSTimetaskLogExample.Criteria;
import com.ffxl.cloud.service.STimetaskLogService;
import com.ffxl.platform.core.GenericMapper;
import com.ffxl.platform.core.GenericServiceImpl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 /**
 * Generate By MBG for serviceImpl
 **/
@Service
public class STimetaskLogServiceImpl extends GenericServiceImpl<STimetaskLog, STimetaskLogExample, String> implements STimetaskLogService {
    private static final Logger LOGGER = LoggerFactory.getLogger(STimetaskLogServiceImpl.class);

    @Autowired
    private STimetaskLogMapper sTimetaskLogMapper;

    @Override
    public GenericMapper<STimetaskLog, STimetaskLogExample, String> getGenericMapper() {
        return sTimetaskLogMapper;
    }

    public STimetaskLog queryByModel(STimetaskLog sTimetaskLog) {
        STimetaskLogExample example = new STimetaskLogExample();
        Criteria c= example.createCriteria();
        List<STimetaskLog> modelList =  sTimetaskLogMapper.selectByExample(example);
        if(modelList.size() > 0){
            return modelList.get(0);
        }else{
            return null;
        }
    }

	@Override
	public int deleteLog(Date deleteDateStr) {
		STimetaskLogExample example = new STimetaskLogExample();
		Criteria c= example.createCriteria();
		c.andCreateDateLessThanOrEqualTo(deleteDateStr);
		int ret = sTimetaskLogMapper.deleteByExample(example);
		return ret;
	}
}