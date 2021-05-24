package application;

public class Financial_Stuff {
	private int receipt_No;
	private boolean bank_Statement;
	private boolean income_Proof;
	private int r_ID;
	private int customer_ID;
	private String company_code;
	private int product_ID;

	public Financial_Stuff(int receipt_No, boolean bank_Statement, boolean income_Proof, int r_ID, int customer_ID,
			String company_code, int product_ID) {
		super();
		this.receipt_No = receipt_No;
		this.bank_Statement = bank_Statement;
		this.income_Proof = income_Proof;
		this.r_ID = r_ID;
		this.customer_ID = customer_ID;
		this.company_code = company_code;
		this.product_ID = product_ID;
	}

	public int getReceipt_No() {
		return receipt_No;
	}

	public void setReceipt_No(int receipt_No) {
		this.receipt_No = receipt_No;
	}

	public boolean isBank_Statement() {
		return bank_Statement;
	}

	public void setBank_Statement(boolean bank_Statement) {
		this.bank_Statement = bank_Statement;
	}

	public boolean isIncome_Proof() {
		return income_Proof;
	}

	public void setIncome_Proof(boolean income_Proof) {
		this.income_Proof = income_Proof;
	}

	public int getR_ID() {
		return r_ID;
	}

	public void setR_ID(int r_ID) {
		this.r_ID = r_ID;
	}

	public int getCustomer_ID() {
		return customer_ID;
	}

	public void setCustomer_ID(int customer_ID) {
		this.customer_ID = customer_ID;
	}

	public String getCompany_code() {
		return company_code;
	}

	public void setCompany_code(String company_code) {
		this.company_code = company_code;
	}

	public int getProduct_ID() {
		return product_ID;
	}

	public void setProduct_ID(int product_ID) {
		this.product_ID = product_ID;
	}

}
