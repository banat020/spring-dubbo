package com.banling.springdubbo.ds.base.query;

import java.io.Serializable;
import java.util.Map;

/**封装进行MyBatis查询、更新、删除操作的SQL命名与入参。<br>
 * 支持分页。
 * 
 * @author Ban
 *
 */
public class QueryObj implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7492964757145536183L;
	
	/**用于分页。<br>
	 * 第几页。
	 * 注意索引是从1开始。
	 */
	private Integer pageNo;
	/**用于分页。<br>
	 * 每页有多少条记录。默认为15条。
	 */
	private Integer pageSize=15;
	
	private Map<String,Object> paramsMap;

	public Map<String, Object> getParamsMap() {
		if(pageNo!=null&&pageSize!=null&&pageSize.intValue()>0){
			paramsMap.put("pageNo", pageNo.intValue());
			paramsMap.put("pageSize", pageSize.intValue());
		}
		return paramsMap;
	}

	public void setParamsMap(Map<String, Object> paramsMap) {
		this.paramsMap = paramsMap;
	}

	/**每页记录数
	 * @return Integer
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**每页记录数
	 * @param pageSize Integer
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**第几页
	 * @return Integer
	 */
	public Integer getPageNo() {
		return pageNo;
	}

	/**第几页
	 * @param pageNo Integer
	 */
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

}
