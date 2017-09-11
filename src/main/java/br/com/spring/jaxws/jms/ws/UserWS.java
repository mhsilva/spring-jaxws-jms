package br.com.spring.jaxws.jms.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.com.spring.jaxws.jms.pojo.UserInterfacePojoRequest;

@WebService(serviceName = "UserWS")
public class UserWS extends AbstractWebService {

	private String functionalityName = "userInterface";

	@WebMethod
	public String createUser(UserInterfacePojoRequest req) {
		this.enqueue(req); 
		return "User placed on queue";
	}

	@Override
	String getFunctionalityName() {
		return this.functionalityName;
	}
}
