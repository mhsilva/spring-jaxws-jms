package br.com.spring.jaxws.jms.ws;

import org.springframework.jms.core.JmsTemplate;

import br.com.spring.jaxws.jms.pojo.MessageRequest;
import br.com.spring.jaxws.jms.pojo.QueueWrapper;
import br.com.spring.jaxws.jms.utils.MessageConstants;

public abstract class AbstractWebService {
	
	abstract JmsTemplate getJmsTemplate();
	
	public void enqueueMethod(MessageRequest req){
		getJmsTemplate().convertAndSend(MessageConstants.MESSAGE_TOPIC, new QueueWrapper(getFunctionalityName(), req));
	}
	
	abstract String getFunctionalityName();
}
