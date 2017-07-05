package com.banling.springdubbo.ds.test.sys.service;

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

import com.banling.spring.dubbo.module.db.sys.SysUsers;
import com.banling.springdubbo.ds.sys.service.ISysUsersService;


public class SysUsersServiceTest {
	
	private static BeanFactory beanFactory=null;
	private static ISysUsersService service=null;

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		beanFactory = new ClassPathXmlApplicationContext("config/ds/applicationContext-ds.xml");
		service=(ISysUsersService)beanFactory.getBean("sysUsersService");
	
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
	public void test() {		
		service.findAll(true, 0, 100);
	}
	
	@Test
	public void testFindByProperty(){
		List<SysUsers> list=service.findByProperty("userName", "user_name_1");
		System.out.println("findByProperty >>> "+list.size());
		for(SysUsers user:list){
			System.out.println("用户名："+user.getUserName());
		}
	}
	
	@Test
	public void findByJPQLQuery(){
		Map<String,Object> paramsMap=new HashMap<String,Object>();
		paramsMap.put("userName", "user_name%");
		paramsMap.put("userAge", 22);
		List<SysUsers> list=service.findByJPQLQuery("select a from SysUsers a where a.userName like :userName and a.userAge>:userAge", SysUsers.class, 0, 20, paramsMap);
		System.out.println("findByJPQLQuery >>> "+list.size());
		for(SysUsers user:list){
			System.out.println("用户名："+user.getUserName()+", age: "+user.getUserAge().intValue());
		}
	}
	
	@Test
	public void testInsert(){
		SysUsers user=new SysUsers();
		user.setUserName("inset name");
		user.setUserAge(20);
		user=service.save(user);
		System.out.println("testSave >>> "+user.getUserId());
	}
	
	@Test
	public void testIn(){
		List<SysUsers> list=service.findByWhere("select a from SysUsers a where a.userId in ( 'id_1','id_2','id_3' )", null);
		System.out.println("testIn >>> "+list.size());
		for(SysUsers user:list){
			System.out.println("用户名："+user.getUserName()+", age: "+user.getUserAge().intValue());
		}
	}
	
	@Test
	public void removeUndifiedId(){
		//删除不存在的ID就会异常
		//因为后台是通getReference的方式查，如果查不到就报异常
		service.removeByIds("aaa","bbb");
	}
	
	@Test
	public void testFind(){
		//根据ID查询，如果查不到返回空（不报异常）
		service.find("aaa");
	}

}
