package com.banling.springdubbo.client.test.simple;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.banling.spring.dubbo.module.simple.MsgObj;
import com.banling.springdubbo.api.simple.service.IHelloService;

public class TestHelloService {
	private static BeanFactory beanFactory = null;
	private static IHelloService helloService=null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		beanFactory = new ClassPathXmlApplicationContext("config/client/applicationContext-client.xml");
		helloService=(IHelloService)beanFactory.getBean("helloService");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Test
	public void testSayHi() {
		System.out.println("返回信息："+helloService.sayHi("BanLing"));
	}
	
	@Test
	public void testGetMsg(){
		MsgObj msg=helloService.getMsg();
		System.out.println("返回信息实体："+msg.getMsgId()+":"+msg.getMsgTittle()+":"+msg.getMsgContent());
	}
	
	@Test
	public void testSendMsg(){
		MsgObj msg=new MsgObj("100","tittle","content");
		helloService.sendMsg(msg);
	}
	
	@Test
	public void testGetMsgList(){
		List<MsgObj> list=helloService.getMsgs();
		System.out.println("取得消息列表：");
		for(MsgObj msg:list){
			System.out.println("实体："+msg.getMsgId()+":"+msg.getMsgTittle()+":"+msg.getMsgContent());
		}
	}

}
