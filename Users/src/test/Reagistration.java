package test;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**This is my first test */

@ManagedBean(name="reg")
@RequestScoped
public class Reagistration {

	
	public String creat(){ 
		return "reg";
	}
}
