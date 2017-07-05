package com.banling.spring.dubbo.module.simple;

import java.io.Serializable;


/**消息实体，用于测试。
 * @author Ban
 *
 */
public class MsgObj implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String msgId;
	private String msgTittle;
	private String msgContent;
	
	public MsgObj(){}
	
	public MsgObj(String msgId,String msgTittle,String msgContent){
		this.msgId=msgId;
		this.msgTittle=msgTittle;
		this.msgContent=msgContent;
	}
	
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	public String getMsgTittle() {
		return msgTittle;
	}
	public void setMsgTittle(String msgTittle) {
		this.msgTittle = msgTittle;
	}
	public String getMsgContent() {
		return msgContent;
	}
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

}
