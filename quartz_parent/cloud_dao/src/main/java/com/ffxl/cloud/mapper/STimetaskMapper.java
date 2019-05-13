package com.ffxl.cloud.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ffxl.cloud.model.STimetask;
import com.ffxl.cloud.model.STimetaskExample;
import com.ffxl.platform.core.GenericMapper;

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