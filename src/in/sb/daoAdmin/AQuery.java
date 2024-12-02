package in.sb.daoAdmin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import in.sb.dao.Conn;
import in.sb.service.ServicesImpl;

public class AQuery {
	static Scanner s = new Scanner(System.in);
private static final String Preparedstatement = null;
Conn c = new Conn();

public void allWorker() {
	try {
		PreparedStatement ps = c.connection.prepareStatement("select w.w_id , w.name,w.email , w.pno , j.job from worker w , job j where w.job = j.job_id");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println("worker [id : " + rs.getInt(1) + " ,name : " + rs.getString(2) + ", email : "+ rs.getString(3) +", phone no : "+ rs.getLong(4) + ",job : " + rs.getString(5)+ "]");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public void allUser() {
	try {
		PreparedStatement ps = c.connection.prepareStatement("select id , name ,email , loc , pno from user");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println("worker [id : " + rs.getInt(1) + " , name : " + rs.getString(2) + ", email : "+ rs.getString(3) + ",address : "+ rs.getString(4) +",phoneNo : " + rs.getLong(5) + "]");
		} 
	} catch (Exception e) {
		e.printStackTrace();
	}
}
public void showServices() {
	try {
		PreparedStatement ps = c.connection.prepareStatement("select * from job");
		ResultSet rs = ps.executeQuery();
		System.out.println("jobs are : ");
		while(rs.next()) {
			System.out.println(rs.getInt(1) +" : "+ rs.getString(2) );
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}
public void addServices() {
	System.out.print("job : ");
	try {
		String jb = s.next();
		PreparedStatement ps = c.connection.prepareStatement("insert into job (job) values (?) ");
		ps.setString(1,jb);
		int count = ps.executeUpdate();
		if(count != 0) {
			System.out.println("success");
		}else {
			System.out.println("not");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public void showBlock() {
	try {
		PreparedStatement ps = c.connection.prepareStatement("select * from block");
		ResultSet rs = ps.executeQuery();
		System.out.println("block id are : ");
		System.out.println();
		while(rs.next()) {
			System.out.println(rs.getInt(1) +" : "+ rs.getString(2));
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}
public void addBlock() {
	System.out.print("email : ");
	try {
		String bid = s.next();
		PreparedStatement ps = c.connection.prepareStatement("insert into block (blockId) values (?) ");
		ps.setString(1,bid);
		int count = ps.executeUpdate();
		if(count != 0) {
			System.out.println("success");
		}else {
			System.out.println("not");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}
public void removeBlock() {
	System.out.print("email : ");
	try {
		String jb = s.next();
		PreparedStatement ps = c.connection.prepareStatement("delete from block where blockId = ?");
		ps.setString(1,jb);
		int count = ps.executeUpdate();
		if(count != 0) {
			System.out.println("deleted");
		}else {
			System.out.println("not");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
