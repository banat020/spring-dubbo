package com.banling.springdubbo.ds.base.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

//import org.springframework.transaction.annotation.Transactional;







import org.springframework.transaction.annotation.Transactional;

import com.banling.springdubbo.ds.base.dao.IGenericDao;
import com.banling.springdubbo.ds.base.service.IGenericService;

/**Hibernate数据操作通用工具实现。<br>
 * <b>不实现事务。事务放在ppms_server的Bussiness中实现。</b>
 * @author Ban
 *
 * @param <T>
 */
@Transactional
public abstract class GenericService<T extends Serializable> implements IGenericService<T> {
	
	/**得到DAO，下放到子类中实现。
	 * @return IGenericDao<T>, 注意：如果对DAO做了定制，那么返回定制的DAO
	 */
	@Transactional(readOnly=true)
	public abstract IGenericDao<T> getDao();
	
	@Override
	public T save(T entity) {
		return getDao().save(entity);
	}

	@Override
	public T update(T entity) {
		return getDao().update(entity);
	}
	
	@Override
	public boolean updateByBatch(List<T> list){
		boolean result=true;
		try{
			for(T t:list){
				if(t!=null){
					getDao().update(t);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void remove(Object id) {
		getDao().remove(id);
	}
	
	@Override
	public void removeByIds(Object... ids){
		getDao().removeByIds(ids);
	}

	@Override
	@Transactional(readOnly=true)
	public T find(Object id) {
		return getDao().find(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<T> findAll(boolean distinct, int skip, int size) {
		return getDao().findAll(distinct, skip, size);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<T> findAll(boolean distinct) {
		return getDao().findAll(distinct);
	}

	@Override
	@Transactional(readOnly=true)
	public List<T> findByProperty(String field, Object value, int skip, int size) {
		return getDao().findByProperty(field, value, skip, size);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<T> findByProperty(String field, Object value) {
		return getDao().findByProperty(field, value);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<T> findByWhere(String jpql,Map<String,Object> paramsMap, int skip, int size){
		return getDao().findByWhere(jpql, paramsMap, skip, size);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<T> findByWhere(String jpql,Map<String,Object> paramsMap){
		return getDao().findByWhere(jpql, paramsMap);
	}

	@Override
	@Transactional(readOnly=true)
	public int countAll(boolean distinct) {
		return getDao().countAll(distinct);
	}

	@Override
	@Transactional(readOnly=true)
	public int countByProperty(String field, Object value) {
		return getDao().countByProperty(field, value);
	}
	
	@Override
	@Transactional(readOnly=true)
	public <X> X getReference(Class<X> clazz, Object id) {
		return getDao().getReference(clazz, id);
	}

	@Override
	@Transactional(readOnly=true)
	public <X> List<X> findByJPQLQuery(String jpql, Class<X> clazz, int skip, int size, Object... params) {
		return getDao().findByJPQLQuery(jpql, clazz, skip, size, params);
	}

	@Override
	@Transactional(readOnly=true)
	public <X> List<X> findByJPQLQuery(String jpql, Class<X> clazz, int skip, int size, Map<String, Object> paramsMap) {
		return getDao().findByJPQLQuery(jpql, clazz, skip, size, paramsMap);
	}

	@Override
	@Transactional(readOnly=true)
	public <X> List<X> findByNamedQuery(String name, Class<X> clazz, int skip, int size, Object... params) {
		return getDao().findByNamedQuery(name, clazz, skip, size, params);
	}

	@Override
	@Transactional(readOnly=true)
	public <X> List<X> findByNamedQuery(String name, Class<X> clazz, int skip, int size, Map<String, Object> paramsMap) {
		return getDao().findByNamedQuery(name, clazz, skip, size, paramsMap);
	}

	@Override
	@Transactional(readOnly=true)
	public <X> List<X> findByNativeQuery(String sql, Class<X> clazz, int skip, int size, Object... params) {
		return getDao().findByNativeQuery(sql, clazz, skip, size, params);
	}

	@Override
	@Transactional(readOnly=true)
	public <X> List<X> findByNativeQuery(String sql, Class<X> clazz, int skip, int size, Map<String, Object> params) {
		return getDao().findByNativeQuery(sql, clazz, skip, size, params);
	}

	@Override
	@Transactional(readOnly=true)
	public int countByJPQLQuery(String jpql, Object... params) {
		return getDao().countByJPQLQuery(jpql, params);
	}

	@Override
	@Transactional(readOnly=true)
	public int countByJPQLQuery(String jpql, Map<String, Object> params) {
		return getDao().countByJPQLQuery(jpql, params);
	}

	@Override
	@Transactional(readOnly=true)
	public int countByNamedQuery(String name, Object... params) {
		return getDao().countByNamedQuery(name, params);
	}

	@Override
	@Transactional(readOnly=true)
	public int countByNamedQuery(String name, Map<String, Object> params) {
		return getDao().countByNamedQuery(name, params);
	}

	@Override
	@Transactional(readOnly=true)
	public int countByNativeQuery(String sql, Object... params) {
		return getDao().countByNativeQuery(sql, params);
	}

	@Override
	@Transactional(readOnly=true)
	public int countByNativeQuery(String sql, Map<String, Object> params) {
		return getDao().countByNativeQuery(sql, params);
	}

	@Override
	@Transactional(readOnly=true)
	public int executeByJPQL(String jpql, Object... params) {
		return getDao().executeByJPQL(jpql, params);
	}

	@Override
	@Transactional(readOnly=true)
	public int executeByJPQL(String jpql, Map<String, Object> params) {
		return getDao().executeByJPQL(jpql, params);
	}

	@Override
	@Transactional(readOnly=true)
	public int executeBySQL(String sql, Object... params) {
		return getDao().executeBySQL(sql, params);
	}

	@Override
	@Transactional(readOnly=true)
	public int executeBySQL(String sql, Map<String, Object> params) {
		return getDao().executeBySQL(sql, params);
	}

}
