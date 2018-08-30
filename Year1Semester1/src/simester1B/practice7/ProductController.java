package simester1B.practice7;

public class ProductController {
	
	private ProductView view = new ProductView();
	private DefaultProductModel model = new DefaultProductModel();
	
	public ProductController(){
		
	}
	
	public void addProduct(Product newProduct){
		model.addProduct(newProduct);
	}
	
	public void printProducts(){
		for(int productCounter = 0 ; productCounter < model.getSize() ; productCounter++){
			view.showProduct(model.getProductByIndex(productCounter));
		}
	}
	
	public void printMostExpensive(){
		 view.showMostExpensive(model.mostExpansive());
	}
	
}
