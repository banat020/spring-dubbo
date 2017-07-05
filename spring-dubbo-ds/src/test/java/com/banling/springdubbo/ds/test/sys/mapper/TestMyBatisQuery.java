package com.banling.springdubbo.ds.test.sys.mapper;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.banling.springdubbo.ds.base.query.IQuery;
import com.banling.springdubbo.ds.sys.mapper.SysUsersMapper;

public class TestMyBatisQuery {
	private static BeanFactory beanFactory = null;
	private static IQuery query=null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		beanFactory = new ClassPathXmlApplicationContext("config/ds/applicationContext-ds.xml");
		query=(IQuery)beanFactory.getBean("query");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindAll() {
		List<Map<String,Object>> list=query.queryForList(SysUsersMapper.FIND_ALL);
		System.out.println("--------------------------------------------------------------");
		System.out.println("findAll()");
		for(Map<String,Object> map:list){
			//在SQL中如果用*代替返回列，那么所有Key默认会被小写
			System.out.println("UserName="+map.get("user_name")+";  userAge="+map.get("user_age"));
		}
	}

	@Test
	public void testFindByIds(){
		List<String> ids=new ArrayList<String>();
		ids.add("id_1");
		ids.add("id_2");
		ids.add("id_3");
		
		Map<String,Object> paramsMaps=new HashMap<String,Object>();
		paramsMaps.put("listUser", ids);
		List<Map<String,Object>> list=query.queryForList(SysUsersMapper.FIND_BY_IDS,paramsMaps);
		System.out.println("--------------------------------------------------------------");
		System.out.println("testFindByIds()");
		for(Map<String,Object> map:list){
			//显列声明返回列，那Key必须与返回列完全一样
			System.out.println("UserName="+map.get("USER_NAME")+";  userAge="+map.get("USER_age"));
		}
	}
	
	@Test
	public void testFindByWhere(){
		Map<String,Object> paramsMaps=new HashMap<String,Object>();
		paramsMaps.put("userName", "%user%");
		paramsMaps.put("userAge", 22);
		//不分页
		List<Map<String,Object>> list=query.queryForList(SysUsersMapper.FIND_BY_WHERE,paramsMaps);
		System.out.println("--------------------------------------------------------------");
		System.out.println("testFindByWherAndPage()");
		for(Map<String,Object> map:list){
			//在SQL中如果用*代替返回列，那么所有Key默认会被小写
			System.out.println("UserName="+map.get("user_name")+";  userAge="+map.get("user_age"));
		}
	}
	
	@Test
	public void testFindByWherAndPage(){
		Map<String,Object> paramsMaps=new HashMap<String,Object>();
		paramsMaps.put("userName", "%user%");
		paramsMaps.put("userAge", 22);
		//分页
		List<Map<String,Object>> list=query.queryForPage(SysUsersMapper.FIND_BY_WHERE,paramsMaps,1,2);
		System.out.println("--------------------------------------------------------------");
		System.out.println("testFindByWherAndPage()");
		for(Map<String,Object> map:list){
			//在SQL中如果用*代替返回列，那么所有Key默认会被小写
			System.out.println("UserName="+map.get("user_name")+";  userAge="+map.get("user_age"));
		}
	}
}
