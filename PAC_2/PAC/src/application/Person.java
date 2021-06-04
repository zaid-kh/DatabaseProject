package application;

import java.util.*;

public class Person {
	private int customer_ID;
	private int id;
	private Date DOB;
	private String p_Name;

	public Person(int customer_ID, int id, Date dob, String p_Name) {
		this.customer_ID = customer_ID;
		this.id = id;
		this.DOB = dob;
		this.p_Name = p_Name;
	}


	public Person(int customer_ID, int id, String p_Name) {
		this.customer_ID = customer_ID;
		this.id = id;
		this.p_Name = p_Name;
	}
	public Person(int id, Date dob, String p_Name) {
		this.DOB = dob;
		this.id = id;
		this.p_Name = p_Name;
	}
	public int getCustomer_ID() {
		return customer_ID;
	}

	public void setCustomer_ID(int customer_ID) {
		this.customer_ID = customer_ID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;

	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		this.DOB = dOB;
	}

	public String getP_Name() {
		return p_Name;
	}

	public void setP_Name(String p_Name) {
		this.p_Name = p_Name;
	}

	@Override
	public String toString() {
		return "Person [customer_ID=" + customer_ID + ", id=" + id + ", DOB=" + DOB + ", p_Name=" + p_Name + "]";
	}
	
	

}