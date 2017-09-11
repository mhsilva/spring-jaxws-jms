package br.com.spring.jaxws.jms.pojo;

import java.math.BigDecimal;

public class UserInterfacePojoRequest extends QueueAbstractWrapper {
	private static final long serialVersionUID = 3552646455441800691L;
	private String username;
	private String name;
	private BigDecimal age;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getAge() {
		return age;
	}

	public void setAge(BigDecimal age) {
		this.age = age;
	}
}
