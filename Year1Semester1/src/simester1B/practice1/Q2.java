package simester1B.practice1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Q2 {
	
	public static void main (String[] args) throws IOException{
		int[] a = new int[]{10,20,30,40,50,60};
		FileOutputStream fileOut = new FileOutputStream ("1.dat");
		FileInputStream fileIn = new FileInputStream ("1.dat");
		DataOutputStream out = new DataOutputStream (fileOut);
		DataInputStream in = new DataInputStream (fileIn);
		
		Save(a, out);
		Load (in);

		fileOut.close();
		fileIn.close();
		
	}
	
	public static void Save(int[] array, DataOutputStream out) throws IOException{
		for(int counter=0 ; counter<array.length ; counter++){
			out.writeInt(array[counter]);
		}
	}
	
	public static void Load(DataInputStream in) throws IOException{
		try{
			while(true){
				System.out.println(in.readInt());
			}
		}
		catch(EOFException ex){
			System.out.println("The End");
		}
	}
	
	
}
