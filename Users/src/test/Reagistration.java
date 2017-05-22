package test;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;



@ManagedBean(name="reg")
@RequestScoped
public class Reagistration {

	
	public String creat(){ 
		return "reg";
	}
}
