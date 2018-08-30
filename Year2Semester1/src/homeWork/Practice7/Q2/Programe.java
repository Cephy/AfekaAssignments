package homeWork.Practice7.Q2;

public class Programe {
	
	public static void main (String[] args){
		
		ProductController pC = new ProductController();
		Product temp1 = new Product("Cheese", 10);
		Product temp2 = new Product("cola", 5);
		Product temp3 = new Product("water", 3);
		
		pC.addProduct(temp1);
		pC.addProduct(temp2);
		pC.addProduct(temp3);
	
	}
}
