package simester1B.practice7;

import java.util.ArrayList;

public class DefaultProductModel {
	
	private ArrayList<Product> productArray= new ArrayList<>();
	
	
	public DefaultProductModel(){
		
	}
	
	public void addProduct(Product newProduct){
		productArray.add(newProduct);
	}
	
	public Product getProductByIndex(int index){
		return productArray.get(index);
	}
	
	public int getSize(){
		return productArray.size();
	}
	
	public Product mostExpansive(){
		
		Product maxProduct = new Product("temp",0);
		
		for (Product productArray : productArray){
			if(productArray.getPrice() >= maxProduct.getPrice()){
				maxProduct = productArray;
			}
		}
		
		return maxProduct;
	}
	
}
