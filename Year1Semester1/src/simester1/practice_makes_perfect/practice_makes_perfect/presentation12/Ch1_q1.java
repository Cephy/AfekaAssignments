package simester1.practice_makes_perfect.practice_makes_perfect.presentation12;

import java.io.FileNotFoundException;
import java.util.*;

public class Ch1_q1 {

	public static void main (String[] args) throws FileNotFoundException{
		Scanner s = new Scanner(System.in);
		
		System.out.println("number and file name");
		int number = s.nextInt();
		String fileName = s.next();
		
		Boom7 game = new Boom7(fileName, number);
		
	}
}
