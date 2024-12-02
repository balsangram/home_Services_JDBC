package in.sb.controllerUser;

import java.util.Scanner;

import in.sb.daoUSer.userQuery;

public class userServices {
	Scanner s = new Scanner(System.in);
	userQuery uq = new userQuery();
public static void services(String email) {
	
	
	System.out.println("services we are provide ");
	System.out.println();
	System.out.println("1 : all services");
	System.out.println("2 : booking");
	System.out.println("3 : go back ");
	new userServices().sCheck(email);
	
	
}
 void sCheck(String email) {
	 System.out.print("choice : ");
	int n = s.nextInt();
	switch(n) {
	case 1: 
		uq.servic();
		sCheck(email);
		break;
case 2: 
//	uq.servic();
	uq.booking(email);
	sCheck(email);
	break;
case 3: 
//	sCheck();
	userPage.option(email);
	break;
default: 
	System.out.println("please enter right no ");
	sCheck(email);
	break;
}
}
}
