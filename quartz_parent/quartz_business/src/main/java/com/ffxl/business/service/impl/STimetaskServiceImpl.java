package com.ffxl.business.service.impl;

import com.ffxl.business.annotation.ServiceLogAnnotation;
import com.ffxl.business.mapper.STimetaskMapper;
import com.ffxl.business.model.STimetask;
import com.ffxl.business.model.STimetaskExample;
import com.ffxl.business.model.base.BaseSTimetaskExample.Criteria;
import com.ffxl.business.service.STimetaskService;
import com.ffxl.platform.core.GenericMapper;
import com.ffxl.platform.core.GenericServiceImpl;
import com.ffxl.platform.core.Page;
import com.ffxl.platform.exception.BusinessException;
import com.ffxl.platform.util.StringUtil;
import com.ffxl.platform.util.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Generate By liqz and liyj for serviceImpl
 **/
@Service
public class STimetaskServiceImpl extends GenericServiceImpl<STimetask, STimetaskExample, String> implements STimetaskService {
    private static final Logger LOGGER = LoggerFactory.getLogger(STimetaskServiceImpl.class);
    
    @Autowired
    private STimetaskMapper sTimetaskMapper;
    
    @Override
    public GenericMapper<STimetask, STimetaskExample, String> getGenericMapper() {
        return sTimetaskMapper;
    }
    
    public STimetask queryByModel(STimetask sTimetask) {
        STimetaskExample example = new STimetaskExample();
        Criteria c = example.createCriteria();
        List<STimetask> modelList = sTimetaskMapper.selectByExample(example);
        if(modelList.size() > 0) {
            return modelList.get(0);
        } else {
            return null;
        }
    }
    
    @Override
    public List<STimetask> selectByPage(STimetask model, Page page) {
        STimetaskExample example = new STimetaskExample();
        Criteria c = example.createCriteria();
        if(!StringUtil.isEmpty(model.getName())) {
            c.andNameLike("%" + model.getName() + "%");
        }
        if(!StringUtil.isEmpty(model.getJobStatus())) {
            c.andJobStatusEqualTo(model.getJobStatus());
        }
        example.setPage(page);
        example.setOrderByClause(" group_name asc, create_date desc");
        List<STimetask> modelList = sTimetaskMapper.selectByExample(example);
        return modelList;
    }
    
    @Override
    public int updatebyOperate(List<String> idList, String type) {
        int ret = sTimetaskMapper.updateByIds(idList, type);
        return ret;
    }
    
    @Override
    @ServiceLogAnnotation(description = "批量删除")
    public int deleteByIds(List<String> idList) {
        int ret = sTimetaskMapper.deleteByIds(idList);
        return ret;
    }
    
    @Override
    public int insertOrUpdateByUser(STimetask model, String loginName) {
        int ret = 0;
        //插入
        if(StringUtil.isEmpty(model.getId())) {
            model.setId(UUIDUtil.getUUID());
            model.setJobStatus("0");
            model.setConcurrent(false);
            model.setCreateUserId(loginName);
            model.setModifyUserId(loginName);
            ret = sTimetaskMapper.insertSelective(model);
            if(ret <= 0) {
                throw new BusinessException("任务创建失败");
            }
        } else {
            model.setModifyUserId(loginName);
            ret = sTimetaskMapper.updateByPrimaryKeySelective(model);
        }
        return ret;
    }
    
    @Override
    public STimetask checkName(STimetask task) {
        STimetaskExample example = new STimetaskExample();
        Criteria c = example.createCriteria();
        if(!StringUtil.isEmpty(task.getId())) {
            //编辑
            c.andIdNotEqualTo(task.getId());
        }
        if(!StringUtil.isEmpty(task.getGroupName())) {
            c.andGroupNameEqualTo(task.getGroupName());
        }
        if(!StringUtil.isEmpty(task.getName())) {
            c.andNameEqualTo(task.getName());
        }
        List<STimetask> modelList = sTimetaskMapper.selectByExample(example);
        if(modelList.size() > 0) {
            return modelList.get(0);
        } else {
            return null;
        }
    }
}