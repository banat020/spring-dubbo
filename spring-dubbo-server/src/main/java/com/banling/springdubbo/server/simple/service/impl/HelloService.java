package com.banling.springdubbo.server.simple.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.banling.spring.dubbo.module.simple.MsgObj;
import com.banling.springdubbo.api.simple.service.IHelloService;

@Service
public class HelloService implements IHelloService {
	Logger logger=Logger.getLogger(getClass());
	@Override
	public String sayHi(String name) {
		// TODO Auto-generated method stub
		return "say hi to "+name;
	}

	@Override
	public MsgObj getMsg() {
		// TODO Auto-generated method stub
		return new MsgObj("1","msg tittle","content");
	}

	@Override
	public void sendMsg(MsgObj msg) {
		// TODO Auto-generated method stub
		if(msg!=null){
			logger.info("收到消息，内容：");
			StringBuilder sb=new StringBuilder();
			sb.append("msgId: ");
			sb.append(msg.getMsgId()==null?"null ":msg.getMsgId());
			sb.append(", msgTittle: ");
			sb.append(msg.getMsgTittle()==null?"null ":msg.getMsgTittle());
			sb.append(", msgContent: ");
			sb.append(msg.getMsgContent()==null?"null ":msg.getMsgContent());
			logger.info(sb.toString());
		}else{
			logger.info("没有收到消息。");
		}
		
	}

	@Override
	public List<MsgObj> getMsgs() {
		// TODO Auto-generated method stub
		List<MsgObj> msgs=new ArrayList<MsgObj>();
		for(int i=10;i<=15;i++){
			msgs.add(new MsgObj(i+"","tittle_"+i,"content+"+i));
		}
		return msgs;
	}

}
