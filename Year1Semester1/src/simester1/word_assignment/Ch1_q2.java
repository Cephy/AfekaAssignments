package simester1.word_assignment;

import java.util.*;

public class Ch1_q2 {
		
		
		public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
			final int BASIC_PRICE = 12;
			final int CHEAP_TOPPINGS = 2, EXPENSIVE_TOPPINGS = 3;
			int CheapToppingsNum;
			int ExpensiveToppingsNum;
			
			System.out.println("Hello sir, how many deluxe, delicious toppings whould you like in your tost? ");
			ExpensiveToppingsNum = s.nextInt();
			System.out.println("How many regular toppinng whould you like to have in your tost?");
			CheapToppingsNum = s.nextInt();
			System.out.println("The total price of your amazing Tost is: "
							  + (BASIC_PRICE+(CHEAP_TOPPINGS*CheapToppingsNum)+(EXPENSIVE_TOPPINGS*ExpensiveToppingsNum)) + "NIS\n" 
							  + BASIC_PRICE + "NIS for the tost and " 
							  + ((CHEAP_TOPPINGS*CheapToppingsNum)+(EXPENSIVE_TOPPINGS*ExpensiveToppingsNum)) + "NIS for the toppings.");
		  
			

		}

}
