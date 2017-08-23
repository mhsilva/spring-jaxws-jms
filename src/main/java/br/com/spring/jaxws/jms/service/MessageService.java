package br.com.spring.jaxws.jms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import br.com.spring.jaxws.jms.pojo.MessageRequest;

@Service
public class MessageService {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	public void enqueueMethod(MessageRequest req){
		jmsTemplate.convertAndSend("received", req);
	}
}
