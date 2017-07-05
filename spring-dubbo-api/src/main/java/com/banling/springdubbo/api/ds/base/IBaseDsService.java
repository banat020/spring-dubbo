package com.banling.springdubbo.api.ds.base;

import java.util.List;
import java.util.Map;

/**业务服务基本的通用的接口定义（也就是细粒度的业务接口）<br>
 * 被用于请求控制层（Controller）。<br>
 * Controller层通过调用这里的接口，实现功能。<br>
 * <b>注意，如果这里提供的接口不能满足功能的实现，就要在具体的业务接口中扩展。<br>
 * @author Ban
 *
 * @param <T>
 */
public interface IBaseDsService<T,ID extends java.io.Serializable> {
	/** 保存实体
	 * @param entity
	 * @return T
	 */
	T save(T entity);
	
	/** 更新实体
	 * @param entity
	 * @return T
	 */
	T update(T entity);
		
	/** 根据ID列表删除实体
	 * @param ids List<ID>	主键
	 */
	boolean delete(List<ID> ids);	
	
	/**分页查询
	 * @param paramsMap Map<String,Object>,查询参数
	 * @param skip int, 起始记录
	 * @param size int, 每页记录数
	 * @return List<T> 
	 */
	List<T> query(Map<String,Object> paramsMap,int skip,int size);

	
}
