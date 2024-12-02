package in.sb.service;

import in.sb.daoAdmin.AQuery;
import in.sb.daoUSer.userQuery;
import in.sb.daoWorker.workerQuery;

public class ServicesImpl implements Service {
	userQuery uq = new userQuery();
	AQuery aq = new AQuery();
	@Override
	public void allWorker() {
		aq.allWorker();
	}
	@Override
	public void allUser() {
		aq.allUser();
	}
	@Override
	public void showServices() {
		aq.showServices();
	}
	@Override
	public void addServices() {
		aq.addServices();
	}
	@Override
	public void showBlock() {
		aq.showBlock();
	}
	@Override
	public void addBlock() {
		aq.addBlock();
	}
	@Override
	public void removeBlock() {
		aq.removeBlock();
	}
	
//	==================== user ============
	
	@Override
	public void addUser() {
		uq.addUser();
	}
	@Override
	public void showDetails(String email) {
		uq.showDetails(email);
	}
	
//	==================== worker ============
	
	
	
}
