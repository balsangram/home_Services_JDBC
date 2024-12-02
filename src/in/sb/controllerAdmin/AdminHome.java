package in.sb.controllerAdmin;
import java.util.Scanner;
public class AdminHome {
	static Scanner s = new Scanner(System.in);
public static void adHome() {
	System.out.println("==============================");
	System.out.println("welcome home Admin");
	System.out.println("==============================");
	System.out.println();
	passwordCheacker();
}

public static void passwordCheacker() {
	
	System.out.print( "password : ");
	String password = s.next();
	if(password.equals("123")) {
		System.out.println();
		adminPage.Page();
	} else {
		System.err.println("password is incorrect ");
		System.out.println();
		passwordCheacker();
	}
}
}
