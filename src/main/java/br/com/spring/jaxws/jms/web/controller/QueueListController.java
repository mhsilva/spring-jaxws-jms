package br.com.spring.jaxws.jms.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.spring.jaxws.jms.pojo.MessageRequest;
import br.com.spring.jaxws.jms.pojo.User;
import br.com.spring.jaxws.jms.pojo.UserExit;
import br.com.spring.jaxws.jms.service.MessageService;
import br.com.spring.jaxws.jms.service.UserExitService;
import br.com.spring.jaxws.jms.service.UserService;

@Controller
public class QueueListController {

	@Autowired
	private MessageService messageService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserExitService userExitService;
	
	@RequestMapping(value = "/messageList")
	public @ResponseBody List<MessageRequest> messageListMapping() {
		return messageService.getMessageRequestCollection();
	}
	
	@RequestMapping(value = "/userList")
	public @ResponseBody List<User> userListMapping() {
		return userService.getUserCollection();
	}
	
	@RequestMapping(value = "/exitSave", method = RequestMethod.POST)
	public String userExitSave(UserExit userExit) {
		userExitService.addUser(userExit);
		return "index.html";
	}
}
