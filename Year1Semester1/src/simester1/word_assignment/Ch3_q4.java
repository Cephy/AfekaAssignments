package simester1.word_assignment;

import java.util.*;

public class Ch3_q4 {

	public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
		
		final int AGE_FACTOR = 18, ADULTE_BOOKS = 5, TEENAGER_BOOKS = 3, DAYS_FACTOR = 30;
		int age, NumBooks, NumDays;
		
		System.out.println("how old are you? ");
		age = s.nextInt();
		System.out.println("how many books you have at home? ");
		NumBooks = s.nextInt();
		if ((age >= AGE_FACTOR && NumBooks >= ADULTE_BOOKS)||(age < AGE_FACTOR && NumBooks >= TEENAGER_BOOKS))
			System.out.println("sorry, you must returen a book in order to take another one ");
		else
			System.out.println("how many days ago did you borrow your last book? ");
			NumDays = s.nextInt();
			if (NumDays > DAYS_FACTOR){
				System.out.println("sorry, you have a book for more then 30 days, you "
							   + "must returen a book in order to take an another one");
		}	else
				System.out.println("you may borrow a book from the library ");
	}

}
