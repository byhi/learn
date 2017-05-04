package test;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("login")
@SessionScoped
public class UserLogin {

	public void send(){
		System.out.println("Login");
	}
}
