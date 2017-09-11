package br.com.spring.jaxws.jms.pojo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlTransient;

public abstract class QueueAbstractWrapper implements Serializable {

	private static final long serialVersionUID = -4836579528850568931L;

	private String commonAttribute;

	@XmlTransient
	private String interfaceType;

	public String getCommonAttribute() {
		return commonAttribute;
	}

	public void setCommonAttribute(String commonAttribute) {
		this.commonAttribute = commonAttribute;
	}

	public String getInterfaceType() {
		return interfaceType;
	}

	public void setInterfaceType(String interfaceType) {
		this.interfaceType = interfaceType;
	}

}
