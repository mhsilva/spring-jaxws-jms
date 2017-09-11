package br.com.spring.jaxws.jms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spring.jaxws.jms.pojo.MessageRequest;

@Service
public class MessageService {

	@Autowired
	private MessageDAO messageDAO;
	
	public void addMessageRequest(MessageRequest messageRequest) {
		messageDAO.addMessageRequest(messageRequest);
	}
	
	public List<MessageRequest> getMessageRequestCollection() {
		return messageDAO.getMessageRequestCollection();
	}
}
