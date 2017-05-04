package test;

import java.io.Serializable;
import java.sql.*;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;



@ManagedBean(name="customer")
@SessionScoped
public class UserBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4207335627398649648L;
	private UserModel user;
	
	public UserModel getCars(String name, String pass) throws ClassNotFoundException, SQLException {
		Connection connect = null;

		String url = "jdbc:mysql://localhost:3306/cardb";

		String username = "pankaj";
		String password = "pankaj123";
		Class.forName("com.mysql.jdbc.Driver");

		connect = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt = connect
				.prepareStatement("select NAME, NICK, AVATAR from users where NAME='"+name+"' and PASS='"+pass+"'");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {

			UserModel user = new UserModel();
			
			user.setName(rs.getString("NAME"));
			user.setNick(rs.getString("NICK"));
			user.setImg(rs.getBlob("AVATAR"));
		

			

		}
		
		return user;
	}
}
