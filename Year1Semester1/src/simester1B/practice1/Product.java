package simester1B.practice1;

public class Product implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private String productName;
	private float price;
	
	public Product (String productName, float price){
		this.price = price;
		this.productName = productName;
	}
	
	public String getProductName(){
		return productName;
	}
	
	public float getPrice(){
		return price;
	}
	
	public String toString(){
		return String.format("%-10S     :%-10.2f\n", productName,price);
	}
}
