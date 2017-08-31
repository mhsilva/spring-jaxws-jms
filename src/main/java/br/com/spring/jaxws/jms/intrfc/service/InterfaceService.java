package br.com.spring.jaxws.jms.intrfc.service;

import br.com.spring.jaxws.jms.pojo.QueueAbstractWrapper;

public interface InterfaceService<T extends QueueAbstractWrapper> {

	void processData(T message);
}
