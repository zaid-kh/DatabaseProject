package application;

import java.util.Calendar;

public class Part {
	private int product_Id;
	private int p_Id;
	private Calendar p_Date;
	private String model;
	private String p_Name;
	private double price;

	public Part(int product_Id, int p_Id, Calendar p_Date, String model, String p_Name, double price) {
		this.product_Id = product_Id;
		this.p_Id = p_Id;
		this.p_Date = p_Date;
		this.model = model;
		this.p_Name = p_Name;
		this.price = price;
	}

	public int getProduct_Id() {
		return product_Id;
	}

	public void setProduct_Id(int product_Id) {
		this.product_Id = product_Id;
	}

	public int getP_Id() {
		return p_Id;
	}

	public void setP_Id(int p_Id) {
		this.p_Id = p_Id;
	}

	public Calendar getP_Date() {
		return p_Date;
	}

	public void setP_Date(Calendar p_Date) {
		this.p_Date = p_Date;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getP_Name() {
		return p_Name;
	}

	public void setP_Name(String p_Name) {
		this.p_Name = p_Name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
