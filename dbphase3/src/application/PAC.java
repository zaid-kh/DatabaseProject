package application;

public class PAC {
	private String company_code;
	private String address;
	private String phone;
	private String service_Type;
	private int customer_ID;
	private int customsP_ID;
	private int product_ID;

	public PAC(
			String company_code, String address, String phone, String service_Type, int customer_ID, int customsP_ID,
			int product_ID) {
		this.company_code = company_code;
		this.address = address;
		this.phone = phone;
		this.service_Type = service_Type;
		this.customer_ID = customer_ID;
		this.customsP_ID = customsP_ID;
		this.product_ID = product_ID;
	}

	public String getCompany_code() {
		return company_code;
	}

	public void setCompany_code(String company_code) {
		this.company_code = company_code;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getService_Type() {
		return service_Type;
	}

	public void setService_Type(String service_Type) {
		this.service_Type = service_Type;
	}

	public int getCustomer_ID() {
		return customer_ID;
	}

	public void setCustomer_ID(int customer_ID) {
		this.customer_ID = customer_ID;
	}

	public int getCustomsP_ID() {
		return customsP_ID;
	}

	public void setCustomsP_ID(int customsP_ID) {
		this.customsP_ID = customsP_ID;
	}

	public int getProduct_ID() {
		return product_ID;
	}

	public void setProduct_ID(int product_ID) {
		this.product_ID = product_ID;
	}

}
