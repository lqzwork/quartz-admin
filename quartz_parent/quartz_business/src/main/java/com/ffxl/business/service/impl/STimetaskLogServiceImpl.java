package com.ffxl.business.service.impl;

import com.ffxl.dao.mapper.STimetaskLogMapper;
import com.ffxl.dao.model.STimetaskLog;
import com.ffxl.dao.model.STimetaskLogExample;
import com.ffxl.dao.model.base.BaseSTimetaskLogExample.Criteria;
import com.ffxl.business.service.STimetaskLogService;
import com.ffxl.common.core.GenericMapper;
import com.ffxl.common.core.GenericServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Generate By liqz and liyj for serviceImpl
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
        Criteria c = example.createCriteria();
        List<STimetaskLog> modelList = sTimetaskLogMapper.selectByExample(example);
        if(modelList.size() > 0) {
            return modelList.get(0);
        } else {
            return null;
        }
    }
    
    @Override
    public int deleteLog(Date deleteDateStr) {
        STimetaskLogExample example = new STimetaskLogExample();
        Criteria c = example.createCriteria();
        c.andCreateDateLessThanOrEqualTo(deleteDateStr);
        int ret = sTimetaskLogMapper.deleteByExample(example);
        return ret;
    }
}