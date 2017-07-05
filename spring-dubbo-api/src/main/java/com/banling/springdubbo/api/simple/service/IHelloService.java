package com.banling.springdubbo.api.simple.service;

import java.util.List;

import com.banling.spring.dubbo.module.simple.MsgObj;

/**定义远程调用接口
 * @author Ban
 *
 */
public interface IHelloService {
	/**打个招呼
	 * @param name String
	 * @return String
	 */
	public String sayHi(String name);
	
	/**得到单个消息
	 * @return MsgObj
	 */
	public MsgObj getMsg();
	
	/**发送消息
	 * @param msg MsgObj
	 */
	public void sendMsg(MsgObj msg);
	
	/**得到消息列表
	 * @return List<MsgObj>
	 */
	public List<MsgObj> getMsgs();	
}
