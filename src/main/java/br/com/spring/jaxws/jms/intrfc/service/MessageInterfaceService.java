package br.com.spring.jaxws.jms.intrfc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spring.jaxws.jms.pojo.MessageRequest;
import br.com.spring.jaxws.jms.service.MessageService;

@Service("message")
public class MessageInterfaceService implements InterfaceService<MessageRequest> {

	@Autowired
	private MessageService messageService;

	public void processData(MessageRequest message) {
		messageService.addMessageRequest(message);
	}
}
