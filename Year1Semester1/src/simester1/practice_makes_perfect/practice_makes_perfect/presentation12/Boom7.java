package simester1.practice_makes_perfect.practice_makes_perfect.presentation12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Boom7 {
	
	private int number;
	private final String fileName;
	
	public Boom7 (String fileName, int number) throws FileNotFoundException{
		this.fileName = fileName;
		this.number = number;
		File boom7 = new File(fileName);
		PrintWriter pw = new PrintWriter (boom7);
		for (int i=0 ; i<=number ; i++){
			if((i%7==0)||(i%10==7)||(i%100==7)){
				pw.println(i);
			}
		}
		pw.close();
	}
	
}
