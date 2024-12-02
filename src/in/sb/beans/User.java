package in.sb.beans;

public class User {
	private String name ;
	private String email;
	private long phoneNo;
	private String address;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		name = this.name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		email = this.email;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String Address) {
		address = this.address;
	}
}
