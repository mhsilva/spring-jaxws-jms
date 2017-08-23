package br.com.spring.jaxws.jms.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.com.spring.jaxws.jms.pojo.MessageRequest;
import br.com.spring.jaxws.jms.pojo.MessageResponse;
import br.com.spring.jaxws.jms.service.MessageService;
import br.com.spring.jaxws.jms.utils.MySpringApplicationContext;

@WebService(serviceName="MessageWS")
public class MessageWS {

	@WebMethod
	public MessageResponse sendMessage(MessageRequest req) {
		MessageService service = MySpringApplicationContext.getBean(MessageService.class);
		service.enqueueMethod(req);
		return new MessageResponse("Message Sent");
	}
}
