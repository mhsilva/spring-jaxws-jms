package br.com.spring.jaxws.jms.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.jms.core.JmsTemplate;

import br.com.spring.jaxws.jms.pojo.MessageRequest;
import br.com.spring.jaxws.jms.pojo.MessageResponse;
import br.com.spring.jaxws.jms.utils.MySpringApplicationContext;

@WebService(serviceName = "MessageWS")
public class MessageWS extends AbstractWebService {

	private String functionalityName = "message";
	private JmsTemplate jmsTemplate;

	@WebMethod
	public MessageResponse sendMessage(MessageRequest req) {
		this.setJmsTemplate(MySpringApplicationContext.getBean(JmsTemplate.class));
		this.enqueueMethod(req);
		return new MessageResponse("Message Sent");
	}

	String getFunctionalityName() {
		return functionalityName;
	}

	JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	private void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
}
