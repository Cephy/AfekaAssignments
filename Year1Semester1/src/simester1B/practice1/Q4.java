package simester1B.practice1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class Q4 {
	
	public static final int MAX_VALUE = 10000;
	public static void main (String[] args) throws FileNotFoundException, IOException{
		Scanner userScanner = new Scanner (System.in);		
		FileOutputStream fileOut = new FileOutputStream("Q4.dat");
		FileInputStream fileIn = new FileInputStream ("Q4.dat");
		DataOutputStream out = new DataOutputStream (fileOut);
		DataInputStream in = new DataInputStream (fileIn);
		Boolean menu = true; 
		Float price;
		String productName, userAnswer;
		
		do{
			System.out.println("Please enter a product name: ");
			productName = userScanner.next();
			System.out.println("Please enter the product price: ");
			price = userScanner.nextFloat();
			Save(productName,price,out); 
			System.out.println("Would you like to enter more products?");
			if(userScanner.next().equals("n")){
				menu = false;
			}				
		}while(menu);
		Load(in);
		userScanner.close();
	}
	
	public static void Save (String productName, Float price, DataOutputStream out){
		try{
			out.writeUTF(productName);
			out.writeFloat(price);
			System.out.println("Product saved");
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
	}
	
	public static void Load (DataInputStream in)throws IOException{
		String productName=null;
		Float price = null;
		try{
			while(true){							
				productName = in.readUTF();				
				price = in.readFloat();
				if(MAX_VALUE<price){
					price = (float)(price*0.9);
				}	
				System.out.printf("The name of the product is: %s \n"
						+ "The Price of the product is: %10.2f\n" ,productName, price);
			}
		}
		catch(EOFException ex){
			//ex.printStackTrace();
			System.out.println("End of file");
		}
	}
	
}
