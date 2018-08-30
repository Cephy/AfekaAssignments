package simester1B.practice1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Q3 {
	
	public static void main (String[] args) throws FileNotFoundException{
		
		FileOutputStream fileOut = new FileOutputStream("test1.dat");
		FileInputStream fileIn = new FileInputStream ("test1.dat");
		BufferedOutputStream out = new BufferedOutputStream (fileOut);
		BufferedInputStream  in = new BufferedInputStream  (fileIn);
		
		int[] array = new int[50000];		
		for(int i=0 ; i<array.length ; i++){
			array[i] = i%100;
		} 
		
		long timer = System.currentTimeMillis();
		try{
			Save(array, out);
			Load(in);	
		}
		catch (IOException ex){
			ex.printStackTrace();
		}
		
		
		timer = timer-System.currentTimeMillis();
		System.out.printf("It took %d MiliSeconds " ,timer);
		
	}
	
	public static void Save (int [] array, BufferedOutputStream out) throws IOException{
		for (int counter=0 ; counter<array.length ; counter++){
			out.write(array[counter]);
		}
	}
	
	public static void Load (BufferedInputStream in) throws IOException{
		try{
			while(in.available()>0){
				System.out.println(in.read());
			}
		}
		catch(EOFException ex){
			System.out.println("End of file");
		}
	}	

}
