package in.sb.controllerWorker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.sb.dao.Conn;
import in.sb.daoWorker.workerQuery;
import java.util.Scanner;
public class WorkerPage {
	static workerQuery wq = new workerQuery();
	static Conn c = new Conn();
	static Scanner s = new Scanner(System.in);

public static void WorkerRegistraton() {
	wq.addWorker();
	workerLogin();
}
public static void workerLogin() {
	System.out.print("Email : ");
	String email = s.next();
	System.out.print("Password : ");
	String password = s.next();
	try {
		PreparedStatement ps = c.connection.prepareStatement("select name from worker where email = ? and password = ?");
		ps.setString(1, email);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			services(rs.getString(1));
		} 
		else {
			System.err.println("reEnter value");
			workerLogin();
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}

	public static void services(String name) {
		System.out.println("hello " + name);
	}
}

