package in.sb.controllerAdmin;

import java.util.Scanner;
import in.sb.service.ServicesImpl;

public class adminPage {
	static Scanner s = new Scanner(System.in);
	public static void Page() {
		System.out.println("1 : Show all workers");
		System.out.println("2 : Show all user");
		System.out.println("3 : Show Services");
		System.out.println("4 : add Services");
		System.out.println("5 : show block worker");
		System.out.println("6 : add block worker");
		System.out.println("7 : remove worker");
		System.out.println("8 : exit");
		System.out.println("==============================");
		check();
	}
	public static void check() {
		ServicesImpl si = new ServicesImpl();
		System.out.print("choose the option  :");
		int n = s.nextInt();
		switch(n) {
		case 1 : 
			System.out.println("==============================");
			si.allWorker();
			System.out.println("==============================");
			adminPage.Page();
			break;
		case 2 : 
			System.out.println("==============================");
			si.allUser();
			System.out.println("==============================");
			adminPage.Page();
			break;
		case 3 :
			System.out.println("==============================");
			si.showServices();
			System.out.println("==============================");
			adminPage.Page();
			break;
		case 4 :
			System.out.println("==============================");
			si.addServices();
			System.out.println("==============================");
			adminPage.Page();
			break;
		case 5 :
			System.out.println("==============================");
			si.showBlock();
			System.out.println("==============================");
			adminPage.Page();
			break;
		case 6 :
			System.out.println("==============================");
			si.addBlock();
			System.out.println("==============================");
			adminPage.Page();
			break;
		case 7 :
			System.out.println("==============================");
			si.removeBlock();
			System.out.println("==============================");
			adminPage.Page();
			break;
		case 8 :
			System.exit(0);
		default :
			System.err.println("please choose the right option ");
			check();
			break;
		}
	}
}
