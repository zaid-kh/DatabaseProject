import java.util.*;

public class Product {
 
private int product_ID ;  
 private String	model ;
 private String	p_Name ;
 private  double price ;
 private Calendar p_Date  ;
 private int customsP_ID ;
 private int company_Code ;
 

public Product(int product_ID, String model, String p_Name, double price, Calendar p_Date, int customsP_ID,
		int company_Code) {
	this.product_ID = product_ID;
	this.model = model;
	this.p_Name = p_Name;
	this.price = price;
	this.p_Date = p_Date;
	this.customsP_ID = customsP_ID;
	this.company_Code = company_Code;
}


public int getProduct_ID() {
	return product_ID;
}


public void setProduct_ID(int product_ID) {
	this.product_ID = product_ID;
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


public Calendar getP_Date() {
	return p_Date;
}


public void setP_Date(Calendar p_Date) {
	this.p_Date = p_Date;
}


public int getCustomsP_ID() {
	return customsP_ID;
}


public void setCustomsP_ID(int customsP_ID) {
	this.customsP_ID = customsP_ID;
}


public int getCompany_Code() {
	return company_Code;
}


public void setCompany_Code(int company_Code) {
	this.company_Code = company_Code;
}

	

}
