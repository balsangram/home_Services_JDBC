package in.sb.daoWorker;

import java.sql.PreparedStatement;
import java.util.Scanner;

import in.sb.dao.Conn;

public class workerQuery {
    Conn c = new Conn();
    Scanner s = new Scanner(System.in);
    String name, email, job, password, dob, loc, gender;
    Long phoneNo;
    
    public void addWorker() {
        System.out.print("Enter your name: ");
        name = s.next();
        System.out.print("Enter your email: ");
        email = s.next();
        System.out.print("Enter your date of birth (yyyy-mm-dd): ");
        dob = s.next();
        System.out.print("Enter your location: ");
        loc = s.next();
        System.out.print("Enter your phone number: ");
        phoneNo = s.nextLong();
        System.out.print("Enter your password: ");
        password = s.next();
        System.out.print("Enter your job: ");
        job = s.next();
        System.out.print("Enter your gender: ");
        gender = s.next();
        
        try {
            PreparedStatement ps = c.connection.prepareStatement("INSERT INTO worker (name, email, dob, loc, pno, password, job, gender) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, dob);
            ps.setString(4, loc);
            ps.setLong(5, phoneNo);
            ps.setString(6, password);
            ps.setString(7, job);
            ps.setString(8, gender);
            
            int count = ps.executeUpdate();
            if (count != 0) {
                System.out.println("success");
            } else {
                System.out.println("not");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
