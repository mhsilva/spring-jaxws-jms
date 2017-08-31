package br.com.spring.jaxws.jms.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.com.spring.jaxws.jms.pojo.MessageRequest;
import br.com.spring.jaxws.jms.pojo.MessageResponse;

@WebService(serviceName = "MessageWS")
public class MessageWS extends AbstractWebService {

	private String functionalityName = "message";

	@WebMethod
	public MessageResponse sendMessage(MessageRequest req) {
		this.enqueueMethod(req);
		return new MessageResponse("Message Sent");
	}

	String getFunctionalityName() {
		return functionalityName;
	}
}
