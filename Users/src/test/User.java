package test;

import java.io.Serializable;
import javax.enterprise.context.*;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

@ManagedBean(name = "user")
@RequestScoped
public class User implements Serializable{

	private String name;
	private String pass;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	/*public String welcome() {
		return "/Welcome";
	}*/
	
	
}
