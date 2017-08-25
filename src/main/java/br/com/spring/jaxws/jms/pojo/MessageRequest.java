package br.com.spring.jaxws.jms.pojo;

public class MessageRequest implements InterfaceLayout {
	private String to;
	private String from;
	private String message;
	private String commonAttribute;

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

	public String getCommonAttribute() {
		return commonAttribute;
	}

	public void setCommonAttribute(String commonAttribute) {
		this.commonAttribute = commonAttribute;
	}
}
