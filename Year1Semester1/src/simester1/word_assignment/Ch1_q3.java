package simester1.word_assignment;

import java.util.*; 

public class Ch1_q3 {
			
		public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
			
			final int PRICE_PER_KM = 5, FLOOR_WEIGHT_FACTOR = 1;
			final double TIP = 0.1;
			double distance,weight,price;
			int floor;
			
			System.out.println("Hello sir, please insert the distance in kilometers to your house from the store:\n");
			distance = s.nextDouble();
			System.out.println("Kind sir, would you please state the total weight in kilgrames of your furniture.\n");
			weight = s.nextDouble();
			System.out.println("If you jump from your appartment's window, how many floors will you fall?\n ");
			floor = s.nextInt();
			System.out.println("Please state in NIS how expensive is your new shinny new furniture? \n");
			price = s.nextDouble();
			System.out.println("the total price for the delivery is:\n"+((PRICE_PER_KM*distance)
								+(FLOOR_WEIGHT_FACTOR*weight*floor)+(TIP*price)+price));
		}

}
