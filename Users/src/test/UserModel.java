package test;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.imageio.ImageIO;
/**i do something*/
@ManagedBean(name="usermodel")
@RequestScoped
public class UserModel {
private String name;
private String nick;
private String passw;
private BufferedImage  img;



public String getPassw() {
	return passw;
}
public void setPassw(String passw) {
	this.passw = passw;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getNick() {
	return nick;
}
public void setNick(String nick) {
	this.nick = nick;
}
public Image getImg() {
	return img;
}
public void setImg(BufferedImage img) {
	this.img = img;
}
public void setImg(Blob img) {
	
	
    BufferedImage bufferedImage;
	try {
		byte[] blobAsBytes = img.getBytes(1,(int) img.length());
		bufferedImage = ImageIO.read(new ByteArrayInputStream(blobAsBytes));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		bufferedImage = null;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		bufferedImage = null;
	}

	this.img = bufferedImage;
}

public String add() {
	System.out.println("Connect to db .... ");
	try
    {
      // create a mysql database connection
      String myDriver = "org.gjt.mm.mysql.Driver";
      String myUrl = "jdbc:mysql://localhost/jsf_db";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "");

      

      // the mysql insert statement
      String query = " insert into users (NAME, NICK, PASS)"
        + " values (?, ?, ?)";

      // create the mysql insert preparedstatement
      PreparedStatement preparedStmt = conn.prepareStatement(query);
      preparedStmt.setString (1, this.name);
      preparedStmt.setString (2, this.nick);
      preparedStmt.setString (3, this.passw);
      //preparedStmt.setBlob(4, converttoBlob(this.img));


      // execute the preparedstatement
      preparedStmt.execute();
      
      preparedStmt.close();
      conn.close();
    System.out.println("------------------------------------");
  	System.out.println(toString());
  	System.out.println("COMPLET");
  	System.out.println("------------------------------------");
    }
    catch (Exception e)
    {
    	System.out.println("------------------------------------");
    	System.out.println("ERROR \r\n");    	
	    System.err.println("Got an exception!");     
	    System.err.println(e.getMessage());
	    System.out.println("------------------------------------");     
    }
	
	System.out.println("Connect finished ");
	return "success";
}

private InputStream converttoBlob(BufferedImage bufferedImage)
	{
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	try {
		ImageIO.write(bufferedImage, "jpg", baos);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	InputStream is = new ByteArrayInputStream(baos.toByteArray());
	return is;
  }
@Override
public String toString() {
	return "UserModel : \r\n \r\n  name=" + name + " \r\n nick=" + nick + " \r\n passw=" + passw + " \r\n";
}

}
