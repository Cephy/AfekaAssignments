package simester1.practice_makes_perfect.practice_makes_perfect.Tests.Tests.Moed_A_2016;

import java.io.FileNotFoundException;

public class Main {

	public static void main (String[] args) throws FileNotFoundException{
		
		// ----------------------- question 1 -----------------------
		Child c = new Child("Moshiko", 10);
		System.out.println(c);		// Moshiko 10

		// ----------------------- question 2 -----------------------
		
		boolean res = c.isEqual(new Child("Moshiko", 11));
		System.out.println(res);		// true

		// ----------------------- question 3 -----------------------
		
		//boolean res2 = w.isChildExistsAlready(c);
		//System.out.println(res2);

		// ----------------------- question 4 -----------------------
		
		Worker[] a = {new Worker("Lolo", 110), new Worker("Bamba", 20), new Worker("David", 118)};
		print(a);

	}
	
	public static void print(Worker[] a) {
		for(int i = 0; i < a.length; i++)
				System.out.println(a[i].toString());
		}

}
