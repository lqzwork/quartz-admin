package com.ffxl.common.core;



import java.util.List;

/**
 * @author 
 *
 * @param <T>
 * @param <TE>
 * @param <PK>
 */
public abstract class GenericServiceImpl<T extends Object, TE extends Object, PK> implements
		GenericService<T, TE, PK> {

	protected abstract GenericMapper<T, TE, PK> getGenericMapper();

	public int deleteByPrimaryKey(PK id) {
		return this.getGenericMapper().deleteByPrimaryKey(id);
	}


	public int insert(T entity) {
		return this.getGenericMapper().insert(entity);
	}


	public int insertSelective(T entity) {
		return this.getGenericMapper().insertSelective(entity);
	}


	public T selectByPrimaryKey(PK id) {
		return this.getGenericMapper().selectByPrimaryKey(id);
	}


	public int updateByPrimaryKeySelective(T entity) {
		return this.getGenericMapper().updateByPrimaryKeySelective(entity);
	}


	public int updateByPrimaryKey(T entity) {
		return this.getGenericMapper().updateByPrimaryKey(entity);
	}


	public List<T> selectByExample(TE entity) {
		return this.getGenericMapper().selectByExample(entity);
	}


    public int countByExample(TE example) {
        return this.getGenericMapper().countByExample(example);
    }


    public int deleteByExample(TE example) {
        return this.getGenericMapper().deleteByExample(example);
    }


    public int updateByExampleSelective(T record, TE example) {
        return this.getGenericMapper().updateByExampleSelective(record, example);
    }


    public int updateByExample(T record, TE example) {
        return this.getGenericMapper().updateByExample(record, example);
    }


	public List<T> queryAll() {
		return this.getGenericMapper().selectByExample(null);
	}

}
