package homeWork.Practice7.Q2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
 
public class DefaultProductModel {
	
	private ArrayList<ActionListener> listnersArray= new ArrayList<ActionListener>();
	private ProductView view = new ProductView();
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
	
	public float sumOfProducts(){
		float sum = 0;
		for (Product product : productArray){
			sum = sum + product.getPrice();
		}
		return sum;
	}
	
	public synchronized void actionPreformed(ActionEvent ac){
		for(ActionListener listner : listnersArray){
			listner.actionPerformed(ac);
		}
	}
}
