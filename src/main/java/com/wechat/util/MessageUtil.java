package com.wechat.util;

import com.wechat.model.TextMessageRes;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zxc on 2018/2/19.
 */
public class MessageUtil {
	//接收消息类型
	public static final String REQ_MESSAGE_TYPE_TEXT = "text";									//文本
	public static final String REQ_MESSAGE_TYPE_IMAGE = "image";							//图片
	public static final String REQ_MESSAGE_TYPE_VOICE = "voice";								//语音
	public static final String REQ_MESSAGE_TYPE_VIDEO = "video";								//视频
	public static final String REQ_MESSAGE_TYPE_LOCATION = "location";				//位置
	public static final String REQ_MESSAGE_TYPE_LINK = "link";									//链接
	public static final String REQ_MESSAGE_TYPE_EVENT = "event";							//事件

	//事件类型
	public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";							//关注事件
	public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";					//取消关注
	public static final String EVENT_TYPE_SCAN = "scan";												//
	public static final String EVENT_TYPE_LOCATION = "location";								//发送位置
	public static final String EVENT_TYPE_CLICK = "click";												//点链接

	//回复消息类型
	public static final String RESP_MESSAGE_TYPE_TEXT = "text";									//文本
	public static final String RESP_MESSAGE_TYPE_IMAGE = "image";							//图片
	public static final String RESP_MESSAGE_TYPE_VOICE = "voice";							//语音
	public static final String RESP_MESSAGE_TYPE_VIDEO = "video";							//视频
	public static final String RESP_MESSAGE_TYPE_MUSIC = "music";							//音乐
	public static final String RESP_MESSAGE_TYPE_NEWS = "news";							//图文

	public static Map<String, String> parseXml(HttpServletRequest request)throws Exception{

		Map<String, String> map = new HashMap<String,String>();
		//从reques请求中获取输入流
		InputStream inputStream = request.getInputStream();
		//解析输入流
		SAXReader reader = new SAXReader();
		Document document = reader.read(inputStream);
		//解析文档
		Element root = document.getRootElement();
		List<Element> elementList =root.elements();
		//遍历获取元素
		for(Element e: elementList){
			map.put(e.getName(),e.getText());
		}
		//�ͷ���Դ
		inputStream.close();
		inputStream = null;

		return map;
	}
	private static XStream xstream = new XStream(new XppDriver(){
		public HierarchicalStreamWriter createWriter(Writer out){
			return new PrettyPrintWriter(out){

				boolean cdata = true;
				public void startNode(String name,Class clazz){
					super.startNode(name,clazz);
				}
				protected void writeText(QuickWriter writer, String text){
					if(cdata){

						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					}else{
						writer.write(text);
					}
				}
			};
		}
	});

	//文本消息转化XML
	public static String messageToXml(TextMessageRes textMessage){
		xstream.alias("xml",textMessage.getClass());
		return xstream.toXML(textMessage);
	}
	/*//图片消息转化XML
	public static String messageToXml(imageMessage imageMessage){
		xstream.alias("xml",imageMessage.getClass());
		return xstream.toXML(imageMessage);
	}
	//语音消息转化XML
	public static String messageToXml(voiceMessage voiceMessage){
		xstream.alias("xml",voiceMessage.getClass());
		return xstream.toXML(voiceMessage);
	}
	//视频消息转化XML
	public static String messageToXml(videoMessage videoMessage){
		xstream.alias("xml",videoMessage.getClass());
		return xstream.toXML(videoMessage);
	}
	//音乐消息转化XML
	public static String messageToXml(MusicMessage musicMessage){
		xstream.alias("xml",musicMessage.getClass());
		return xstream.toXML(musicMessage);
	}
	//图文消息转化XML
	public static String messageToXml(NewsMessage newsMessage){
		xstream.alias("xml",newsMessage.getClass());
		xstream.alias("item", new Article().getClass());
		return xstream.toXML(newsMessage);
	}*/
}
