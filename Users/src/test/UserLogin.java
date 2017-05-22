package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;

@ManagedBean(name="login")
@SessionScoped
public class UserLogin {
	public String msge = "Something..."; 
	public String send(String name ,String pas){
		Connection connect = null;
		String answer = "fail";
		String url = "jdbc:mysql://localhost/jsf_db";
		ResultSet rs = null;
		String username = "root";
		String password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = connect
					.prepareStatement("select NAME, NICK from users where NAME='"+name+"' and PASS='"+pas+"'");
			rs = pstmt.executeQuery();
			
			pstmt.close();
			connect.close();
			answer = "welcome";
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			 msge = "Sorry, connection fail..."; 
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			 msge = "Sorry,  You didn't find ..."; 
			e.printStackTrace();
		}
			
			return answer;		
		
	}
}
