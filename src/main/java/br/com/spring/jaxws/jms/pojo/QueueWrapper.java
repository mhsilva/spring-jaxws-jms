package br.com.spring.jaxws.jms.pojo;

public class QueueWrapper {

	private String interfaceType;

	private InterfaceLayout interfaceLayout;

	public QueueWrapper() {

	}

	public QueueWrapper(String interfaceType, InterfaceLayout interfaceLayout) {
		this.interfaceType = interfaceType;
		this.interfaceLayout = interfaceLayout;
	}

	public String getInterfaceType() {
		return interfaceType;
	}

	public void setInterfaceType(String interfaceType) {
		this.interfaceType = interfaceType;
	}

	public InterfaceLayout getInterfaceLayout() {
		return interfaceLayout;
	}

	public void setInterfaceLayout(InterfaceLayout interfaceLayout) {
		this.interfaceLayout = interfaceLayout;
	}
}
