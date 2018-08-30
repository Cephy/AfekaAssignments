package simester1B.practice1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;


public class Q1 {

	public static void main (String[] args) throws FileNotFoundException{
		File file = new File("1");
		PrintWriter pw = new PrintWriter(file);
		Scanner s = new Scanner(file);
		int[] a = new int[]{10,20,30,40,50,60};
		
		Save(a,pw);
		
		Load(a,s);
				
	}
	
	public static void Save(int[] array, PrintWriter pw){
		
		for(int counter=0 ; counter<array.length ; counter++){
			pw.print(array[counter] + " ");
		}
		
		pw.close();
	}
	
	public static void Load (int[] array, Scanner s){
		
		while(s.hasNext()){
			System.out.println(s.next());
		}
				
		s.close();
	}
}
