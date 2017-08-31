package br.com.spring.jaxws.jms.pojo;

public class MessageRequest extends QueueAbstractWrapper {
	
	private static final long serialVersionUID = -2537714368753499750L;
	
	private String to;
	private String from;
	private String message;

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
