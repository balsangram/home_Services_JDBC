package in.sb.daoUSer;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import in.sb.dao.Conn;

public class userQuery {
	FeatureProfile f;
    Conn c = new Conn();
    Scanner s = new Scanner(System.in);
    String name, email, job, address, password;
    String dob;
    Long phoneNo;

    public void addUser() {
        System.out.print("Enter your name: ");
        name = s.next();
        System.out.print("Enter your email: ");
        email = s.next();
        System.out.print("Enter your date of birth (yyyy-MM-dd): ");
        dob = s.next();
        System.out.print("Enter your phone number: ");
        phoneNo = s.nextLong();
        System.out.print("Enter your address: ");
        address = s.next();
        System.out.print("Enter your password: ");
        password = s.next();

        try {
            // Convert dob string to java.sql.Date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedDate = dateFormat.parse(dob);
            Date sqlDate = new Date(parsedDate.getTime());

            PreparedStatement ps = c.connection.prepareStatement(
                "INSERT INTO user (name, email, dob, pNo, loc, password) VALUES (?, ?, ?, ?, ?, ?)"
            );
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setDate(3, sqlDate);
            ps.setLong(4, phoneNo);
            ps.setString(5, address);
            ps.setString(6, password);

            int count = ps.executeUpdate();

            if (count != 0) {
                System.out.println("Success");
            } else {
                System.out.println("Not executed");
            }
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showDetails(String email){
    	f = new FeatureProfile();
    	System.out.println();
    	try {
        	PreparedStatement ps = c.connection.prepareStatement("select name , email , floor(datediff(curdate() , dob ) / 365 ) as age ,loc, pno from user where email =? ");
        	ps.setString(1,email);
        	ResultSet rs = ps.executeQuery();
        	if(rs.next()) {
        		System.out.println("Name : "+ rs.getString(1) +"\nemail : "+ rs.getString(2) +"\nage : "+ rs.getString(3) +"\nLocation : " + rs.getString(4)+ "\npno : " + rs.getString(5));
        		System.out.println();
        		f.gohere(email);
        	}
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void history(String email) {
    	f = new FeatureProfile();
    	try {
    		PreparedStatement ps = c.connection.prepareStatement("select service from booked where email = ?");
    		ps.setString(1, email);
    		ResultSet rs = ps.executeQuery();
    		while(rs.next()) {
    			System.out.println("services : "+ rs.getString(1));
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	f.gohere(email);
    }
    
    public void updateUserDetails(String email){
    	f = new FeatureProfile();
    	try {
    		PreparedStatement ps = c.connection.prepareStatement("select * from user where email = ?");
    		ps.setString(1, email);
    		
    		ResultSet rs = ps.executeQuery();
    		rs.next();
    		
    		String name = rs.getString(2);
    		String Loc = rs.getString(5);
    		String phon = rs.getString(6);
    		String pass = rs.getString(7);
    		
    		System.out.print("Enter Your Password   : ");
    		String npas = s.next();
    		
    		if(npas.equals(pass)) {
    			System.out.println("Your Old Name   : "+name+" :: Enter New Name  : ");
    			String nname = s.next();
    			System.out.println("Your Old Loc   : "+Loc+" :: Enter New Loc  : ");
    			String nloc = s.next();
    			System.out.println("Your Old Phone   : "+phon+" :: Enter New Phone  : ");
    			String npho = s.next();
    			System.out.println("Your Old Pass   : "+pass+" :: Enter New Pass  : ");
    			String npwd = s.next();
    			
    			PreparedStatement ps1 = c.connection.prepareStatement("update user set name=?,loc=?,pno=?,password=? where email=?");
    			ps1.setString(1, nname);
    			ps1.setString(2, nloc);
    			ps1.setString(3, npho);
    			ps1.setString(4, npwd);
    			ps1.setString(5, email);
    			
    			int count = ps1.executeUpdate();
    			if(count>0) {
    				System.out.println("Updation Successfully");
    				f.gohere(email);
    			}else {
    				System.out.println("HELANI");
    			}	
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    	} 	
    }
    public void servic() {
    	int count = 1;
    	try {
        	PreparedStatement ps = c.connection.prepareStatement("select job from job");
        	ResultSet rs = ps.executeQuery();
        	System.out.println();
        	while(rs.next()) {
        		System.out.println(count +" : " + rs.getString(1));
        		count ++ ;
        	}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
    public void deleteId(String email) {
    	try {
    		PreparedStatement ps = c.connection.prepareStatement("DELETE FROM user WHERE email = ? ");
        	ps.setString(1, email);
        	System.out.println();
        	int count = ps.executeUpdate();
        	if(count != 0) {
        		System.out.println("Deleted successfully");
        	}else {
        		System.out.println("not");
        	}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    public void booking(String email) {
    	System.out.print("service : ");
    	String service = s.next();
    	try {
    		PreparedStatement ps = c.connection.prepareStatement("insert into booked (email , service) values (?,?) ");
        	ps.setString(1, email);
        	ps.setString(2, service);
        	System.out.println();
        	int count = ps.executeUpdate();
        	if(count != 0) {
        		System.out.println("add Successafullt");
        	}else {
        		System.out.println("not");
        	}
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    
}
