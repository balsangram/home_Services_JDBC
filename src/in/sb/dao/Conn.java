package in.sb.dao;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
	public Connection connection = null ; 
	public Conn() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/homeservice","root","root");
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
}
