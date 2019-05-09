package com.ffxl.platform.core;



import java.util.List;

/**
 * @author 
 * 
 * @param <T>
 * @param <PK>
 */
public interface GenericService<T, TE, PK>{
    int countByExample(TE example);

    int deleteByExample(TE example);

    int deleteByPrimaryKey(PK id);

    int insert(T record);

    int insertSelective(T record);

    List<T> selectByExample(TE example);

    T selectByPrimaryKey(PK id);

    int updateByExampleSelective(T record, TE example);

    int updateByExample(T record, TE example);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

    List<T> queryAll();

}
