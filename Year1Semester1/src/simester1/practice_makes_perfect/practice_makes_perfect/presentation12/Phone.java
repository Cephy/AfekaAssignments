package simester1.practice_makes_perfect.practice_makes_perfect.presentation12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.*;

public class Phone {
	
	private final String path = "C:\\Users\\sefi2\\Desktop"; 
	private String lineNumber;
	private String ownerName;
	private int lastBill;
	
	public Phone (){
	}
	public Phone (String lineNumber, String ownerName, int lastBill){
		this.lineNumber = lineNumber;
		this.ownerName = ownerName;
		this.lastBill = lastBill;
	}
	
	public Phone (Scanner s)throws FileNotFoundException{
		lineNumber = s.next(); 
		ownerName = s.next();
		lastBill = s.nextInt();
	}
	
	public void save (String filename) throws FileNotFoundException{
		File phone = new File (filename);
		PrintWriter pw = new PrintWriter(phone);
		pw.print("<"+lineNumber+">");
		pw.print("<"+ownerName+">");
		pw.println("<"+lastBill+">");		
	}
	public void save (PrintWriter pw)throws FileNotFoundException{
		pw.print("<"+lineNumber+">");
		pw.print("<"+ownerName+">");
		pw.println("<"+lastBill+">");
	}
	public void loadFile (Scanner s)throws FileNotFoundException{
		lineNumber = s.next(); 
		ownerName = s.next();
		lastBill = s.nextInt();
	}
	public void print(){
		System.out.println("Line number:\n " + lineNumber);
		System.out.println("Owner Name:\n " + ownerName);
		System.out.println("Last Bill:\n " + lastBill);
	}
}
