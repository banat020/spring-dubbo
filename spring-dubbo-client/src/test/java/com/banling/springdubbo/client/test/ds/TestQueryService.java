package com.banling.springdubbo.client.test.ds;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.banling.springdubbo.api.ds.base.IQueryService;

public class TestQueryService {
	
	private static BeanFactory beanFactory = null;
	private static IQueryService queryService=null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		beanFactory = new ClassPathXmlApplicationContext("config/client/applicationContext-client.xml");
		queryService=(IQueryService)beanFactory.getBean("queryService");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		Map<String,Object> paramsMap=new HashMap<String,Object>();
		paramsMap.put("userName", "%user%");
		List<Map<String,Object>> list=queryService.queryForPage("com.banling.springdubbo.ds.sys.mapper.SysUsersMapper.findByName", paramsMap, 1, 3);
		if(list!=null&&list.size()>0){
			System.out.println(list.size());
			for(Map<String,Object> map:list){
				System.out.println("UserName: "+map.get("user_name")+", userage: "+map.get("user_age"));
			}
			
		}
	}

}
