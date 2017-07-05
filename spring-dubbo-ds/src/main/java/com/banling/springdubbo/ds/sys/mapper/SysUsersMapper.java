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
	String COUNT_ALL="com.banling.springdubbo.ds.sys.mapper.SysUsersMapper.countAll";
	String COUNT_BY_WHERE="com.banling.springdubbo.ds.sys.mapper.SysUsersMapper.countByWhere";
	String FIND_BY_ID="com.banling.springdubbo.ds.sys.mapper.SysUsersMapper.findById";
	String FIND_BY_IDS="com.banling.springdubbo.ds.sys.mapper.SysUsersMapper.findByIds";
	String FIND_ALL="com.banling.springdubbo.ds.sys.mapper.SysUsersMapper.findAll";
	String FIND_BY_WHERE="com.banling.springdubbo.ds.sys.mapper.SysUsersMapper.findByWhere";
	String FIND_BY_NAME="com.banling.springdubbo.ds.sys.mapper.SysUsersMapper.findByName";
	
//	List<Map<String,Object>> getAllUsers();
//	
//	Map<String,Object> getUser(String id);
//	
//	List<Map<String,Object>> geUsersByName(Map<String,Object> params);
//	
//	Integer countAll();
}
