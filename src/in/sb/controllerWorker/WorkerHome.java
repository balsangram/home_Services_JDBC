package in.sb.controllerWorker;

import java.util.Scanner;

import in.sb.service.ServicesImpl;

public class WorkerHome {
public void WorkerPage() {
	System.out.println("==============================");
	System.out.println("welcome back =");
	System.out.println("==============================");
	//registration and login 
	System.out.println("1 : Registration");
	System.out.println("2 : Login");
	
	WorkerPage wp = new WorkerPage();
	Scanner s = new Scanner(System.in);
	System.out.print("choose the option : ");
	int n = s.nextInt();
	switch(n) {
	case 1:
		wp.WorkerRegistraton();
		break;
	case 2 : 
		wp.workerLogin();
		break;
	default :
		System.err.println("please choose the option which one we provide ");
		WorkerPage();
	}
}
}
