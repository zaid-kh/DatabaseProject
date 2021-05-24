public class Purchase_order {

	private int order_No ;
	private  String address;
	private int quantity;
	private  String company_code; 
	private   String product;
	
	
	public Purchase_order(int order_No, String address, int quantity, String company_code, String product) {
		super();
		this.order_No = order_No;
		this.address = address;
		this.quantity = quantity;
		this.company_code = company_code;
		this.product = product;
	}


	public int getOrder_No() {
		return order_No;
	}


	public void setOrder_No(int order_No) {
		this.order_No = order_No;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getCompany_code() {
		return company_code;
	}


	public void setCompany_code(String company_code) {
		this.company_code = company_code;
	}


	public String getProduct() {
		return product;
	}


	public void setProduct(String product) {
		this.product = product;
	}
	
	
	
}
