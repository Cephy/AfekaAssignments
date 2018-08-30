package simester1B.practice1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.*;

public class Q5 {
	public static Scanner scan = new Scanner(System.in);
	
	public static void main (String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
		
		int productAmount;
		Product[] productArray, testArray = null;
	
		
		System.out.println("How many product whould you like to enter?");
		productAmount = scan.nextInt();
		productArray = new Product [productAmount];
		
		productArray = creatArray(productArray, productAmount);
		save(productArray);
		System.out.println("Save");
		printArray(productArray);
		System.out.println("Load");
		/*testArray = read(testArray);
		printArray(testArray);*/
		readQ6();
		System.out.println("END");
		
		
	}
	
	public static Product[] creatArray (Product[] productArray, int productAmount){
		for (int counter=0 ; counter < productAmount ; counter++){
			String productName= null;
			float price = 0;
			
			System.out.printf("Please enter product's number %d name\n", counter+1);
			productName = scan.next();
			System.out.printf("Please enter product's number %d price\n", counter+1);
			price = scan.nextFloat();
			productArray[counter] = new Product(productName, price);			
		}
		return productArray;
	}
	
	public static void save(Product[] productArray) throws FileNotFoundException, IOException{
		FileOutputStream fileOut = new FileOutputStream ("Q5.dat");	
		DataOutputStream out = new DataOutputStream (fileOut);
		ObjectOutputStream objOut = new ObjectOutputStream (out); 
		for(Product temp : productArray){
			objOut.writeObject(temp);
		}
		objOut.close();
	}
	
	public static Product[] read(Product[] testArray) throws FileNotFoundException, IOException, ClassNotFoundException{
		FileInputStream fileIn = new FileInputStream ("Q5.dat");
		DataInputStream in = new DataInputStream (fileIn);
		ObjectInputStream objIn = new ObjectInputStream(in);
		
		testArray = (Product[]) objIn.readObject();
		objIn.close();
		return testArray;
	}
	
	public static void readQ6 () throws FileNotFoundException, IOException, ClassNotFoundException{
		FileInputStream fileIn = new FileInputStream ("Q5.dat");
		DataInputStream in = new DataInputStream (fileIn);
		ObjectInputStream objIn = new ObjectInputStream(in);
		final double PRICE_CHECK = 3000;
		
		try{
			do{
				Product temp = (Product) objIn.readObject();
				if(temp.getPrice()>PRICE_CHECK){
					System.out.printf("%-10s :%-10.2f\n", temp.getProductName(),temp.getPrice());
				}
			}while(true);
		}
		catch(EOFException ex){
			System.out.println("end of file");
		}
		
		objIn.close();
		
	}
	
	public static void printArray(Product[] arr){
		for(Product p : arr){
			System.out.println(p);
		}
	}
	
}
