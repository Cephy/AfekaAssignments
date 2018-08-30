package homeWork.Practice7.Q2;

public class Product {
	
	private String name;
	private float price;
	
	
	public Product(String name, float price){
		this.name = name;
		this.price = price;
	}
	
	/*~~~~ Set functions ~~~~*/
	public void setName(String name){
		this.name = name;
	}
	
	public void setPrice (float price){
		this.price = price;
	}
	
	/*~~~~ Get functions ~~~~*/
	
	public float getPrice(){
		return price;
	}
	
	public String getname(){
		return name;
	}
	
	/*~~~~ Other functions ~~~~*/
	
	public String toString(){
		return String.format("Prodcut name: %s\nProduct Price: %f", name,price);
	}
}
