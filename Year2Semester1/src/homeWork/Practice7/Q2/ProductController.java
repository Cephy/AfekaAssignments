package homeWork.Practice7.Q2;

public class ProductController {
	
	
	private DefaultProductModel model = new DefaultProductModel();
	
	public ProductController(){
		
	}
	
	public void addProduct(Product newProduct){
		model.addProduct(newProduct);
	}
	
}
