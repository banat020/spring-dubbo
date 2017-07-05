package com.banling.springdubbo.server.ds.service.base;

import java.util.List;
import java.util.Map;

import com.banling.springdubbo.api.ds.base.IBaseDsService;
import com.banling.springdubbo.ds.base.service.IGenericService;

public abstract class BaseDsService<T,ID extends java.io.Serializable> implements IBaseDsService<T, ID> {
	
	protected abstract IGenericService<T> getGenericService();
	
	@Override
	public T save(T entity) {
		// TODO Auto-generated method stub
		return getGenericService().save(entity);
	}

	@Override
	public T update(T entity) {
		// TODO Auto-generated method stub
		return getGenericService().update(entity);
	}

	@Override
	public boolean delete(List<ID> ids) {
		// TODO Auto-generated method stub
		boolean result=false;
		try{
			getGenericService().removeByIds(ids);
			result=true;
		}catch(Exception e){
			
		}
		return result;
	}

	@Override
	public List<T> query(Map<String, Object> paramsMap, int skip, int size) {
		// TODO Auto-generated method stub
		return getGenericService().findByWhere(createJpql(), paramsMap, skip, size);
	}
	
	/**下放到实现类中实现动态JPQL
	 * @return String
	 */
	public abstract String createJpql();

}
