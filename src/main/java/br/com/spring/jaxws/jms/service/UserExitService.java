package br.com.spring.jaxws.jms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spring.jaxws.jms.pojo.UserExit;

@Service
public class UserExitService {

	@Autowired
	private UserExitDAO userExitDAO;
	
	public void addUser(UserExit userExit) {
		userExitDAO.addUserExit(userExit);
	}
	
	public List<UserExit> getUserCollection() {
		return userExitDAO.getUserExitCollection();
	}
}
