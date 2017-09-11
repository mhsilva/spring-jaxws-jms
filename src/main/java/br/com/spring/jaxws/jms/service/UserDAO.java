package br.com.spring.jaxws.jms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.spring.jaxws.jms.pojo.User;

@Repository
public class UserDAO {
	private List<User> userCollection;

	public List<User> getUserCollection() {
		return userCollection;
	}

	public void setUserCollection(List<User> userCollection) {
		this.userCollection = userCollection;
	}
	
	public void addUser(User user) {
		if (this.userCollection == null)
			this.userCollection = new ArrayList<User>();
		userCollection.add(user);
	}
}
