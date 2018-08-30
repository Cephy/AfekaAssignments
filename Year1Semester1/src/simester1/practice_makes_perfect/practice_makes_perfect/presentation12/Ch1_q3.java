package simester1.practice_makes_perfect.practice_makes_perfect.presentation12;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Ch1_q3 {

	public static void main (String[] args)throws IOException{
		Scanner s = new Scanner (System.in);
		int size;
		
		System.out.println("How meny phone numbers would you like to enter");
		size = s.nextInt();
		
		Phone[] phone = new Phone[size];
		
		for (int i=0 ; i<phone.length ; i++){
			String ownerName, lineNumber;
			int lastBill;
			System.out.printf("Please enter person number %d details:\n", i+1);
			System.out.println("Name");
			ownerName = s.next();
			System.out.println("Phone number");
			lineNumber = s.next();
			System.out.println("last bill");
			lastBill = s.nextInt();
			phone[i] = new Phone(lineNumber, ownerName, lastBill);
		}
		
		File file = new File ("C:\\Users\\sefi2\\Desktop\\Phone.txt");
		PrintWriter pw = new PrintWriter(file);
		for (int i=0 ; i<phone.length ; i++){
			phone[i].save(pw);
		}
		pw.close();
		System.out.println("\n---read from file---\n");
		
		Phone[] phoneLoad = new Phone[size];
		
		Scanner sFile = new Scanner(file);
		
		for (int i=0 ; i<phone.length ; i++){
			phoneLoad[i] = new Phone();
			phoneLoad[i].loadFile(sFile);
		}
		sFile.close();
		
		for(int i=0 ; i<phoneLoad.length ; i++){
			phoneLoad[i].print();			
		}

	}
	
}
