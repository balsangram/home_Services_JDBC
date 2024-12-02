package in.sb.controllerUser;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import in.sb.dao.Conn;
import in.sb.service.ServicesImpl;

public class userPage {
	static Scanner s = new Scanner(System.in);
	static Conn c = new Conn();
	static ServicesImpl si = new ServicesImpl();
		public static void userRegestation() {
			System.out.println("Regestation");
				try {
					si.addUser();
				} catch (Exception e) {
					e.printStackTrace();
				}
				userLogin();
		}
		
//		==============
		public static void userLogin() {
			System.out.print("Email : ");
			String email = s.next();
			System.out.print("Password : ");
			String password = s.next();
			try {
				PreparedStatement ps = c.connection.prepareStatement("select * from user where email = ? and password = ?");
				ps.setString(1, email);
				ps.setString(2, password);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					option(email);
				} 
				else {
					System.err.println("reEnter value");
					userLogin();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public static void option(String email) {
			System.out.println("1 : profile");
			System.out.println("2 : service");
			System.out.println("3 : exit");
			check(email);
		}

		public static void check(String email) {
			System.out.print("choose one option : ");
				int n = s.nextInt();
				switch (n) {
				case 1:
					System.out.println();
					System.out.println("profile");
					si.showDetails(email);
					break;
				case 2:
					System.out.println();
					System.out.println("service");
					userServices.services(email);
//					option(email);
					break;
				case 3 : 
					System.exit(0);
				default:
					System.err.println("please choose the given option");
					check(email);
					break;
				}
		}
		}

