package br.com.spring.jaxws.jms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.spring.jaxws.jms.pojo.UserExit;

@Repository
public class UserExitDAO {

	private List<UserExit> userExitCollection;

	public List<UserExit> getUserExitCollection() {
		return userExitCollection;
	}

	public void setUserExitCollection(List<UserExit> userExitCollection) {
		this.userExitCollection = userExitCollection;
	}

	public void addUserExit(UserExit userExit) {
		if (this.userExitCollection == null)
			this.userExitCollection = new ArrayList<UserExit>();
		userExitCollection.add(userExit);
	}

}
