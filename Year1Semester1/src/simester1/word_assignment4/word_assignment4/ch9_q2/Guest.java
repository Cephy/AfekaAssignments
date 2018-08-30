package simester1.word_assignment4.word_assignment4.ch9_q2;

import java.io.PrintWriter;
import java.util.*;

public class Guest {
	
	private String name;
	private int passportNumber;
	
	public Guest (String name, int passportNumber){
		this.name = name;
		this.passportNumber = passportNumber;
	}
	public Guest (Scanner s){
		name = s.next();
		passportNumber = s.nextInt();
	}
	public void print(){
		System.out.printf("%s, passport number %d\n" ,name,passportNumber);
	}
	public void save (PrintWriter pw){
		pw.println(name);
		pw.println(passportNumber);
		System.out.println("done");
	}
	public void setName (String name){
		this.name = name;
	}
	
	public String getName (){
		return name;
	}
	
	public void setPassportNumber (int passportNumber){
		this.passportNumber = passportNumber;
	}
	public int getPassportNumber (){
		return passportNumber;
	}
}
