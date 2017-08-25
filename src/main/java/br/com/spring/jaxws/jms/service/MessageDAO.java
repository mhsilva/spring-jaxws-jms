package br.com.spring.jaxws.jms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.spring.jaxws.jms.pojo.MessageRequest;

@Repository
public class MessageDAO {
	private List<MessageRequest> messageRequestCollection;

	public List<MessageRequest> getMessageRequestCollection() {
		return messageRequestCollection;
	}

	public void setMessageRequestCollection(List<MessageRequest> messageRequestCollection) {
		this.messageRequestCollection = messageRequestCollection;
	}
	
	public void addMessageRequest(MessageRequest messageRequest) {
		if (this.messageRequestCollection == null)
			this.messageRequestCollection = new ArrayList<MessageRequest>();
		messageRequestCollection.add(messageRequest);
	}
}
