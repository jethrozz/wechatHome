package com.wechat.serviceImpl;

import com.wechat.model.*;
import com.wechat.service.WechatService;
import com.wechat.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * Created by zxc on 2018/2/19.
 */
@Service
public class WechatServiceImpl implements WechatService {


	@Override
	public String weixinPost(HttpServletRequest request) {
		String respMessage = null;
		try {

			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(request);

			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");
			// 消息内容
			String content = requestMap.get("Content");


			System.err.println("FromUserName is:" + fromUserName + ", ToUserName is:" + toUserName + ", MsgType is:" + msgType);

			// 文本消息
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				//这里根据关键字执行相应的逻辑，只有你想不到的，没有做不到的
				if(content.equals("xxx")){

				}
				else{


					//

				}

				//自动回复
				TextMessageRes text = new TextMessageRes();
				text.setContent("the text is" + content);
				text.setToUserName(fromUserName);
				text.setFromUserName(toUserName);
				text.setCreateTime(new Date().getTime());
				text.setMsgType(msgType);

				respMessage = MessageUtil.messageToXml(text);

			} /*else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {// 事件推送
                String eventType = requestMap.get("Event");// 事件类型

                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {// 订阅
                    respContent = "欢迎关注xxx公众号！";
                    return MessageResponse.getTextMessage(fromUserName , toUserName , respContent);
                } else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {// 自定义菜单点击事件
                    String eventKey = requestMap.get("EventKey");// 事件KEY值，与创建自定义菜单时指定的KEY值对应
                    logger.info("eventKey is:" +eventKey);
                    return xxx;
                }
            }
            //开启微信声音识别测试
            else if(msgType.equals("voice"))
            {
                String recvMessage = requestMap.get("Recognition");
                //respContent = "收到的语音解析结果："+recvMessage;
                if(recvMessage!=null){
                    respContent = TulingApiProcess.getTulingResult(recvMessage);
                }else{
                    respContent = "您说的太模糊了，能不能重新说下呢？";
                }
                return MessageResponse.getTextMessage(fromUserName , toUserName , respContent);
            }
            //拍照功能
            else if(msgType.equals("pic_sysphoto"))
            {

            }
            else
            {
                return MessageResponse.getTextMessage(fromUserName , toUserName , "返回为空");
            }*/
			// 事件推送
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				String eventType = requestMap.get("Event");// 事件类型
				// 订阅
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {

					TextMessageRes text = new TextMessageRes();
					text.setContent("欢迎关注，xxx");
					text.setToUserName(fromUserName);
					text.setFromUserName(toUserName);
					text.setCreateTime(new Date().getTime());
					text.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);

					respMessage = MessageUtil.messageToXml(text);
				}
				// TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {// 取消订阅


				}
				// 自定义菜单点击事件
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					String eventKey = requestMap.get("EventKey");// 事件KEY值，与创建自定义菜单时指定的KEY值对应
					if (eventKey.equals("customer_telephone")) {
						TextMessageRes text = new TextMessageRes();
						text.setContent("0755-86671980");
						text.setToUserName(fromUserName);
						text.setFromUserName(toUserName);
						text.setCreateTime(new Date().getTime());
						text.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);

						respMessage = MessageUtil.messageToXml(text);
					}
				}
			}
		}
		catch (Exception e) {
			System.err.println("error......");
		}
		return respMessage;
	}
}
