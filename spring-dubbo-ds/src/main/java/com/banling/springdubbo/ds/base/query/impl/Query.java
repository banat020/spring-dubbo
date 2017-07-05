package com.banling.springdubbo.ds.base.query.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.banling.springdubbo.ds.base.query.IQuery;


/**MyBatis数据访问通用工具实现。
 * @author Ban
 *
 */
@Service
public class Query implements IQuery {

	@Resource
	private SqlSessionTemplate sqlSession;

	@Override
	public int queryForCount(String statementName, Map<String, Object> paramsMap) {
		// TODO Auto-generated method stub
		Integer result=0;
		try{
			result=sqlSession.selectOne(statementName, paramsMap);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result.intValue();
	}
	
	@Override
	public boolean isExists(String statementName, Map<String, Object> paramsMap) {
		// TODO Auto-generated method stub
		return this.queryForCount(statementName, paramsMap) > 0;
	}

	@Override
	public List<Map<String, Object>> queryForList(String statementName,
			Map<String, Object> paramsMap) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(statementName, paramsMap);
	}


	@Override
	public Map<String,Object> queryForObject(String statementName,Map<String, Object> paramsMap) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(statementName, paramsMap);
	}

	@Override
	public boolean updateData(final String statementName,
			final Map<String, Object> paramsMap) {
		// TODO Auto-generated method stub
		boolean result=false;
		try{
			//编程式事务
			sqlSession.update(statementName, paramsMap);
			sqlSession.commit();
			result=true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			sqlSession.rollback();
						
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> queryForPage(String statementName,
			Map<String, Object> paramsMap, int skip, int size) {
		// TODO Auto-generated method stub
		RowBounds rowBounds=null;
		if(paramsMap!=null&&skip>0&&size>0){
			rowBounds=new RowBounds(skip,size);
		}
		if(rowBounds!=null){
			return sqlSession.selectList(statementName, paramsMap,rowBounds);
		}else{
			return sqlSession.selectList(statementName, paramsMap);
		}
	}

	@Override
	public List<Map<String, Object>> queryForList(String statementName) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(statementName);
	}

}
