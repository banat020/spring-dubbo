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

import com.banling.spring.dubbo.module.db.sys.SysUsers;
import com.banling.springdubbo.api.ds.service.IDsSysUsersService;

/**测试Hibernate实现的数据操作
 * @author Ban
 *
 */
public class TestDsSysUsersService {
	
	private static BeanFactory beanFactory = null;
	private static IDsSysUsersService dsSysUsersService=null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {		
		beanFactory = new ClassPathXmlApplicationContext("config/client/applicationContext-client.xml");
		dsSysUsersService=(IDsSysUsersService)beanFactory.getBean("dsSysUsersService");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testQuery() {
		Map<String,Object> paramsMap=new HashMap<String,Object>();
		paramsMap.put("userName", "%user%");
		List<SysUsers> list=dsSysUsersService.query(paramsMap, 1, 3);
		for(SysUsers user:list){
			System.out.println(user.getUserId()+":"+user.getUserName()+":"+user.getUserAge());
		}
	}

}
