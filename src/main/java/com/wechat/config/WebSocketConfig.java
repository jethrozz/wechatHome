package com.wechat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * 配置WebSocket
 */
@Configuration
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {//注册STOMP协议的节点(endpoint),并映射指定的url
		//注册一个STOMP的endpoint,并指定使用SockJS协议
		registry.addEndpoint("/endpointAric").withSockJS();

	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {//配置消息代理(Message Broker)
		//广播式应配置一个/topic消息代理
		registry.enableSimpleBroker("/topic");

	}
}
