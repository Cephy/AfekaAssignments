package simester1.word_assignment;

import java.util.*;

public class Ch3_q3 {

	public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
		
		final int FRIENDS_PRICE = 500, FAMILLY_PRICE = 1000, BASE = 250, TIME_FACTOR = 3, 
				  PRICE_TIME_FACTOR = 50, DISTANCE_FACTOR = 1, PRICE_DISTANCE_FACTOR = 50;
		char friends, familly = 0;
		int AcquaintancesTime, sum;
		double distance;
				
		System.out.println("please answer the following questions with a yes or no in order to determine how much you should pay for the weeding\n\n"
				           +"are you familly related to the couple? ");
		familly = s.next().charAt(0);
		if (familly == 'y') sum = FAMILLY_PRICE;	
		
		else {
			System.out.println("would you consider yourself close with the lucky couple? ");
			friends = s.next().charAt(0);
			
			if (friends == 'y')  sum = FRIENDS_PRICE; 
			
			else sum = BASE;
			
			
			if (familly == 'n' || friends == 'y') {
				
				System.out.println("for how many years have you known the lucky couple?");
				AcquaintancesTime = s.nextInt();
				if (AcquaintancesTime > TIME_FACTOR) {sum += PRICE_TIME_FACTOR;			
				}
				
				System.out.println("how many hours will it take you to drive to the wedding? ");
				distance = s.nextDouble();
				if (distance > DISTANCE_FACTOR) sum -= PRICE_DISTANCE_FACTOR;
			}
		}
		System.out.println("we recomande you to pay: " + sum + " nis");
	}

}
