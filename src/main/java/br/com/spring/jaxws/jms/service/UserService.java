package br.com.spring.jaxws.jms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spring.jaxws.jms.pojo.User;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;
	
	public void addUser(User user) {
		userDAO.addUser(user);
	}
	
	public List<User> getUserCollection() {
		return userDAO.getUserCollection();
	}
}
