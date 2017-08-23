package br.com.spring.jaxws.jms.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.spring.jaxws.jms.pojo.MessageResponse;

@Controller
public class QueueListController {

	@RequestMapping(value = "/queueList")
	public @ResponseBody MessageResponse queueListMapping() {
		return new MessageResponse("Ok Angular");
	}
}
