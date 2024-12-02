package in.sb.daoUSer;

import java.util.Scanner;

import in.sb.controllerUser.userPage;

public class FeatureProfile {
	Scanner s = new Scanner(System.in);
	userQuery u = new userQuery();
	
	public void gohere(String email){
		System.out.println("1. View Services \t 2. Update Profile \t 3.delete id \t 4. go back");
//		System.out.println();
		System.out.print("Choose   : ");
		int choice = s.nextInt();
		
		switch(choice) {
		case 1:
			u.history(email);
			break;
		case 2:
			u.updateUserDetails(email);
			break;
		case 3 :
			u.deleteId(email);
			break;
		case 4:
			userPage.option(email);
break;
		default:
break;
		}
	}
}
