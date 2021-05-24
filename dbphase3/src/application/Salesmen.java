package application;

public class Salesmen {

	 private int Job_ID; // Snum
	 private String sname;
	 private int S_ID; //age
	 private String Address; //major
	 private int Phone; //level

	 
	 public Salesmen (int Job_ID, String sname, int S_ID, String Address, int Phone) {
		 this.Job_ID = Job_ID;
		 this.sname = sname;
		 this.S_ID = S_ID;
		 this.Address = Address;
		 this.Phone = Phone;

	 }
	
	public String getSname() {
		return sname;
	}
	
	public int getS_ID() {
		return S_ID;
	}
	
	
	public int getJob_ID() {
		return Job_ID;
	}
	
	public String getAddress() {
		return Address;
	}
	
	public int getPhone() {
		return Phone;
	}
	
	public void setJob_ID(int Job_ID) {
		this.Job_ID = Job_ID;
	}
	
	public void setSname(String sname) {
		this.sname = sname;
	}
	public void setS_ID(int S_ID) {
		this.S_ID = S_ID;
	}
	public void setAddress(String Address) {
		this.Address = Address;
	}
	public void setPhone(int Phone) {
		this.Phone = Phone;
	}
}