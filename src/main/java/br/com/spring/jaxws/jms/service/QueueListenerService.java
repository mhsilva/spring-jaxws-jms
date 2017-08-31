package br.com.spring.jaxws.jms.service;

import java.io.Serializable;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.SerializationUtils;

import br.com.spring.jaxws.jms.intrfc.service.InterfaceService;
import br.com.spring.jaxws.jms.pojo.QueueAbstractWrapper;
import br.com.spring.jaxws.jms.utils.MySpringApplicationContext;

@Service
public class QueueListenerService {

	public void handleMessage(String message) {

	}

	public void handleMessage(Map message) {

	}

	public <T> void handleMessage(byte[] message) {
		QueueAbstractWrapper wrapper = (QueueAbstractWrapper) SerializationUtils.deserialize(message) ;
		System.out.println(wrapper.getCommonAttribute());
		InterfaceService<QueueAbstractWrapper> interfaceService = MySpringApplicationContext.getBean(wrapper.getInterfaceType(), InterfaceService.class);
		interfaceService.processData(wrapper);
	}

	public void handleMessage(Serializable message) {

	}
}