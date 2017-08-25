package br.com.spring.jaxws.jms.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.spring.jaxws.jms.pojo.MessageRequest;
import br.com.spring.jaxws.jms.service.MessageService;

@Controller
public class QueueListController {

	@Autowired
	private MessageService messageService;
	
	@RequestMapping(value = "/queueList")
	public @ResponseBody List<MessageRequest> queueListMapping() {
		return messageService.getMessageRequestCollection();
	}
}
