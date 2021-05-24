package application;

import java.util.Calendar;

public class Car {
	private int Product_ID;
	private Calendar P_Date;
	private String Model;
	private String P_Name;
	private double Price;
	private String Vin;
	private String Color;
	private int Engine_Capacity;
	private String Transmission_Type;

	public Car(int product_ID, Calendar p_Date, String model, String p_Name, double price, String vin, String color,
			int engine_Capacity, String transmission_Type) {
		super();
		Product_ID = product_ID;
		P_Date = p_Date;
		Model = model;
		P_Name = p_Name;
		Price = price;
		Vin = vin;
		Color = color;
		Engine_Capacity = engine_Capacity;
		Transmission_Type = transmission_Type;
	}

	public int getProduct_ID() {
		return Product_ID;
	}

	public void setProduct_ID(int product_ID) {
		Product_ID = product_ID;
	}

	public Calendar getP_Date() {
		return P_Date;
	}

	public void setP_Date(Calendar p_Date) {
		P_Date = p_Date;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}

	public String getP_Name() {
		return P_Name;
	}

	public void setP_Name(String p_Name) {
		P_Name = p_Name;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public String getVin() {
		return Vin;
	}

	public void setVin(String vin) {
		Vin = vin;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	public int getEngine_Capacity() {
		return Engine_Capacity;
	}

	public void setEngine_Capacity(int engine_Capacity) {
		Engine_Capacity = engine_Capacity;
	}

	public String getTransmission_Type() {
		return Transmission_Type;
	}

	public void setTransmission_Type(String transmission_Type) {
		Transmission_Type = transmission_Type;
	}

}
