package com.banling.springdubbo.ds.sys.mapper;


/**如果是直接通过SqlSessionTemplate去执行SQL，那么：<br>
 * 只需要声明接口，不用声明接口中的方法也可以。<br>
 * 如果是通过Mapper去调用，那么，就必须声明方法了。<br>
 * <br>
 * <b>
 * 另外注意，mapper对应的xml文件的路径在src/main/resources根目录下。
 * </b>
 * @author Ban
 *
 */
public interface SysUsersMapper {
	String COUNT_ALL="countAll";
	String COUNT_BY_WHERE="countByWhere";
	String FIND_BY_ID="findById";
	String FIND_BY_IDS="findByIds";
	String FIND_ALL="findAll";
	String FIND_BY_WHERE="findByWhere";
	String FIND_BY_NAME="findByName";
	
//	List<Map<String,Object>> getAllUsers();
//	
//	Map<String,Object> getUser(String id);
//	
//	List<Map<String,Object>> geUsersByName(Map<String,Object> params);
//	
//	Integer countAll();
}
