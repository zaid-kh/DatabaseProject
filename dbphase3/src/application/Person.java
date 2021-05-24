package application;

public class Person {
	private int customer_ID;
	private int id;
	private int age;
	private String p_Name;
	private String phone;
	private String address;

	public Person(int customer_ID, int id, int age, String p_Name, String phone, String address) {
		super();
		this.customer_ID = customer_ID;
		this.id = id;
		this.age = age;
		this.p_Name = p_Name;
		this.phone = phone;
		this.address = address;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getP_Name() {
		return p_Name;
	}

	public void setP_Name(String p_Name) {
		this.p_Name = p_Name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
