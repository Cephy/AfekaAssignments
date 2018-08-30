package simester1B.practice1;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Q6 {
	public static Scanner scan = new Scanner(System.in);
	
	public static void main (String[] args) throws IOException, EOFException{
		int productAmount;
		Product[] productArray;	
		
		System.out.println("How many product whould you like to enter?");
		productAmount = scan.nextInt();
		productArray = new Product [productAmount];
		productArray = creatArray(productArray, productAmount);
		saveRandom(productArray);
		System.out.println("saved");
		print();
		readRandom();
		print();
		System.out.println("Read");
		
		
	}
	 
	public static void saveRandom(Product[] productArray) throws IOException{
		RandomAccessFile randFile = new RandomAccessFile("Q5.dat", "rw");
		for(Product temp : productArray){
			randFile.writeUTF(temp.getProductName());
			randFile.writeFloat(temp.getPrice());
		}
		randFile.close();
	}
	
	public static void readRandom() throws IOException{
		RandomAccessFile randFile = new RandomAccessFile("Q5.dat", "rw");
		final float PRICE_TAG = 3000;
		randFile.seek(0);
		int floatLength = Float.SIZE/8;
		try
		{	
			do{
				String name = randFile.readUTF();
				float price = randFile.readFloat();				
				if(price>PRICE_TAG){
					long currentPosition = randFile.getFilePointer();
					randFile.seek(currentPosition - floatLength); 
					randFile.writeFloat((float)(price*0.9));
				}	
			}while(true);
		}
		catch(EOFException ex){
			System.out.println("check over");
		}
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
	
	public static void print() throws IOException{
		RandomAccessFile randFile = new RandomAccessFile("Q5.dat", "rw");	
		try
		{	
			do{
				String name = randFile.readUTF();
				float price = randFile.readFloat();
				System.out.printf("name: %-10s \nPrice: %-10.2f\n",name,price);
		 	
			}while(true);
		}
		catch(EOFException ex){
			System.out.println("check over");
		}
	}
}
