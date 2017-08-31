package br.com.spring.jaxws.jms.ws;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.util.SerializationUtils;

import br.com.spring.jaxws.jms.pojo.QueueAbstractWrapper;
import br.com.spring.jaxws.jms.utils.MySpringApplicationContext;
import br.com.spring.jaxws.jms.utils.QueueConstants;

public abstract class AbstractWebService {

	private JmsTemplate jmsTemplate;
	
	public JmsTemplate getJmsTemplate() {
		if (jmsTemplate == null) 
			jmsTemplate = MySpringApplicationContext.getBean(JmsTemplate.class);
		return jmsTemplate;
	}

	public void enqueueMethod(QueueAbstractWrapper req) {
		req.setInterfaceType(this.getFunctionalityName());
		getJmsTemplate().convertAndSend(QueueConstants.MESSAGE_TOPIC, SerializationUtils.serialize(req));
	}
	
	abstract String getFunctionalityName();
}
