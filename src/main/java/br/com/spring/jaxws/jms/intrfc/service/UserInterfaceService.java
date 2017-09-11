package br.com.spring.jaxws.jms.intrfc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spring.jaxws.jms.pojo.User;
import br.com.spring.jaxws.jms.pojo.UserInterfacePojoRequest;
import br.com.spring.jaxws.jms.service.UserService;

@Service("userInterface")
public class UserInterfaceService implements InterfaceService<UserInterfacePojoRequest> {

	@Autowired
	private UserService userService;
	
	public void processData(UserInterfacePojoRequest message) {
		User user = new User();
		user.setAge(message.getAge());
		user.setName(message.getName());
		user.setUsername(message.getUsername());
		userService.addUser(user);
	}
}
