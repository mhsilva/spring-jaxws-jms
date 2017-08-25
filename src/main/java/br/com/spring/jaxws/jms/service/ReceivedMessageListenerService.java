package br.com.spring.jaxws.jms.service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Service;

import br.com.spring.jaxws.jms.intrfc.service.InterfaceService;
import br.com.spring.jaxws.jms.pojo.QueueWrapper;
import br.com.spring.jaxws.jms.utils.MySpringApplicationContext;

@Service
public class ReceivedMessageListenerService implements MessageListener {

	@Autowired
	private MessageConverter messageConverter;
	
	public void onMessage(Message message) {
		try {
			QueueWrapper queueWrapper = (QueueWrapper) messageConverter.fromMessage(message);
			InterfaceService interfaceService = MySpringApplicationContext.getBean(queueWrapper.getInterfaceType(), InterfaceService.class);
			interfaceService.processInterface(queueWrapper.getInterfaceLayout());
		} catch (MessageConversionException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}