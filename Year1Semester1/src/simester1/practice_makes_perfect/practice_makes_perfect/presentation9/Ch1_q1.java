package simester1.practice_makes_perfect.practice_makes_perfect.presentation9;

import java.util.*;

public class Ch1_q1 {

	public static void main (String[] args){
		Scanner s = new Scanner(System.in);
		Clock clock = new Clock();
		
		System.out.println("Please enter the number of seconds");
		clock.setSeconds(s.nextInt());
		System.out.println("Please enter the number of minutes");
		clock.setMinutes(s.nextInt());
		System.out.println("Please enter the number of houres");
		clock.setHoures(s.nextInt());
		
		clock.show();
		System.out.println("tick");
		clock.tick();
		clock.show();
		System.out.println("tick");
		clock.tick();
		clock.show();
		
		clock.resetClock();
		clock.show();
	}
}
