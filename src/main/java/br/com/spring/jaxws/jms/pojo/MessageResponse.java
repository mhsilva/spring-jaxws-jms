package br.com.spring.jaxws.jms.pojo;

public class MessageResponse {
	private String messageStatus;
	
	public MessageResponse(String messageStatus) {
		this.messageStatus = messageStatus;
	}

	public String getMessageStatus() {
		return messageStatus;
	}

	public void setMessageStatus(String messageStatus) {
		this.messageStatus = messageStatus;
	}
}
