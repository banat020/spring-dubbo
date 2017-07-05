package com.banling.springdubbo.api.ds.base;

import java.util.List;
import java.util.Map;

/**Mybatis查询接口
 * @author Ban
 *
 */
public interface IQueryService {
	/** 获取记录总数
	 * @param statementName	查询语句名称
	 * @param paramsMap		查询条件,Map键值对
	 * @return int
	 */
	int queryForCount(String statementName, Map<String,Object> paramsMap);

	
	/** 是否已有记录
	 * @param statementName	查询语句名称
	 * @param paramsMap		查询条件,Map键值对
	 * @return boolean
	 */
	boolean isExists(String statementName, Map<String,Object> paramsMap);
	
	
	/** 获取记录列表，不分页
	 * @param statementName	查询语句名称
	 * @param paramsMap		查询条件,Map键值对
	 * @return List<Map<String, Object>>
	 */
	List<Map<String, Object>> queryForList(String statementName, Map<String,Object> paramsMap);
	
	/**获取记录列表，不分页
	 * @param statementName 查询语句名称
	 * @return List<Map<String, Object>>
	 */
	List<Map<String, Object>> queryForList(String statementName);
	
	
	/** （根据跳过记录与每页记录数）获取分页列表
	 * @param statementName	查询语句名称
	 * @param paramsMap		查询条件,Map键值对
	 * @param skip int 起始记录,索引从1开始
	 * @param size int 返回记录数
	 * @return
	 */
	List<Map<String, Object>> queryForPage(String statementName, Map<String,Object> paramsMap,int skip, int size);
	
	/** 获取单个对象
	 * @param statementName	查询语句名称
	 * @param paramsMap		查询条件,Map键值对
	 * @return Map<String, Object>
	 */
	Map<String, Object> queryForObject(String statementName, Map<String,Object> paramsMap);
}
