package homeWork.Practice7.Q2;

public class ProductView {

	 public void showProduct(Product product){
		 System.out.println(product);
	 }
	 
	 public void showMostExpensive(Product product){
		 System.out.println("This is the most expensive product in our data base");
		 System.out.println(product);
	 }
	 
	 public void printSum(float sum){
		 System.out.printf("Your total price is %f\n" ,sum);
	 }
	
}
