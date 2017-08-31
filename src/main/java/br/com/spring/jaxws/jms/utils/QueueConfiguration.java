package br.com.spring.jaxws.jms.utils;

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import br.com.spring.jaxws.jms.service.QueueListenerService;

@Configuration
public class QueueConfiguration {
	private static final String DEFAULT_BROKER_URL = "tcp://localhost:61616";

	@Autowired
	private QueueListenerService receivedMessageListenerService;

	/*// Embedded ActiveMQ
	@Bean(initMethod = "start", destroyMethod = "stop")
	public BrokerService brokerService() throws Exception {
		BrokerService brokerService = new BrokerService();
		brokerService.setPersistent(false);
		brokerService.setUseJmx(false);
		brokerService.addConnector(DEFAULT_BROKER_URL);
		brokerService.setBrokerName("broker");
		brokerService.setUseShutdownHook(false);
		return brokerService;
	}*/

	// Estabilish the connection and URL for the target ActiveMQ
	@Bean
	public ActiveMQConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
		return connectionFactory;
	}

	// Convert Objects into JSON
	/*@Bean
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}*/

	// JMS Template Bean, for sending and consumig the JMS Queue
	@Bean
	public JmsTemplate jmsTemplate() {
		JmsTemplate template = new JmsTemplate();
		template.setConnectionFactory(connectionFactory());
		template.setDefaultDestinationName(QueueConstants.MESSAGE_TOPIC);
		//template.setMessageConverter(jacksonJmsMessageConverter());
		return template;
	}

	@Bean
	public MessageListenerAdapter messageListenerAdapter() {
		MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(receivedMessageListenerService);
		return messageListenerAdapter;
	}
	
	// Create a default listener for the received queue. It seems that for each
	// queue that we are listening, we need a new
	// DefaultMessageListenerContainer Bean
	@Bean
	public DefaultMessageListenerContainer receivedMessageListenerContainer() {
		DefaultMessageListenerContainer defaultMessageListenerContainer = new DefaultMessageListenerContainer();
		defaultMessageListenerContainer.setConnectionFactory(connectionFactory());
		defaultMessageListenerContainer.setDestinationName(QueueConstants.MESSAGE_TOPIC);
		defaultMessageListenerContainer.setMessageListener(messageListenerAdapter());
		return defaultMessageListenerContainer;
	}
}
