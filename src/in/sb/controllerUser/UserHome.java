package in.sb.controllerUser;
import java.util.Scanner;

public class UserHome {
	static Scanner s = new Scanner(System.in);

	public static void home() {
		System.out.println("==============================");
		System.out.println("welcome back");
		System.out.println("==============================");
		// registration and login
		System.out.println("1 : Registration");
		System.out.println("2 : Login");
		check();
	}

	public static void check() {
		System.out.print("choose the option : ");
		int n = s.nextInt();
		switch (n) {
		case 1:
			userPage.userRegestation();
			break;
		case 2:
			userPage.userLogin();
			break;
		default:
			System.err.println("please choose the option which one we provide ");
			check();
		}
	}
}
