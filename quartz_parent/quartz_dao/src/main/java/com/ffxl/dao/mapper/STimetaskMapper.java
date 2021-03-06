package com.ffxl.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ffxl.dao.model.STimetask;
import com.ffxl.dao.model.STimetaskExample;
import com.ffxl.common.core.GenericMapper;

 /**
 * Generate By liqz and liyj
 **/
public interface STimetaskMapper extends GenericMapper<STimetask, STimetaskExample, String> {

  /**
   * 更新状态
   * @param idList
   * @return 
   */
  int updateByIds(@Param("idList") List<String> idList, @Param("type") String type);
  
  /**
   * 更新状态
   * @param idList
   * @return 
   */
  int deleteByIds(@Param("idList") List<String> idList);
}