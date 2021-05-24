
public class Sale_order {
	
	private int order_ID;
	private int customer_ID ;
	private int int_ID ;
	private int p_No ;
	private  String c_name;
	private double down_payment;
	private	int quantity;
	private int r_ID ;
	private int id;
	
	
	public Sale_order(int order_ID, int customer_ID, int int_ID, int p_No, String c_name, double down_payment,
			int quantity, int r_ID, int id) {
		super();
		this.order_ID = order_ID;
		this.customer_ID = customer_ID;
		this.int_ID = int_ID;
		this.p_No = p_No;
		this.c_name = c_name;
		this.down_payment = down_payment;
		this.quantity = quantity;
		this.r_ID = r_ID;
		this.id = id;
	}


	public int getOrder_ID() {
		return order_ID;
	}


	public void setOrder_ID(int order_ID) {
		this.order_ID = order_ID;
	}


	public int getCustomer_ID() {
		return customer_ID;
	}


	public void setCustomer_ID(int customer_ID) {
		this.customer_ID = customer_ID;
	}


	public int getInt_ID() {
		return int_ID;
	}


	public void setInt_ID(int int_ID) {
		this.int_ID = int_ID;
	}


	public int getP_No() {
		return p_No;
	}


	public void setP_No(int p_No) {
		this.p_No = p_No;
	}


	public String getC_name() {
		return c_name;
	}


	public void setC_name(String c_name) {
		this.c_name = c_name;
	}


	public double getDown_payment() {
		return down_payment;
	}


	public void setDown_payment(double down_payment) {
		this.down_payment = down_payment;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getR_ID() {
		return r_ID;
	}


	public void setR_ID(int r_ID) {
		this.r_ID = r_ID;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
}
