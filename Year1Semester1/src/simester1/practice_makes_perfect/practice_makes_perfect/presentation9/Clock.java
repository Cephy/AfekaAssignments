package simester1.practice_makes_perfect.practice_makes_perfect.presentation9;

import java.util.*;

public class Clock {

	private int houres, minutes, seconds; 
	
	public void setHoures (int houres){
		this.houres = houres;
		if (houres<0 || houres>24){
			houres=0;
			System.out.println("the value u entered is not valid the houres is set to 0");
		}
	}
	public int getHoures (){
		return houres;
	}
	public void setMinutes (int minutes){
		this.minutes = minutes;
		if (minutes<0 || minutes>60){
			minutes=0;
			System.out.println("the value u entered is not valid the minutes is set to 0");
		}
	}
	public int getMinutes (){
		return minutes;
	}
	public void setSeconds (int seconds){
		this.seconds = seconds;
		if (seconds<0 || seconds>60){
			seconds=0;
			System.out.println("the value u entered is not valid the seconds is set to 0");
		}
	}
	public int getSeconds (){
		return seconds;
	}
	public void tick(){
		seconds++;
		minutes+=seconds/60;
		houres+=minutes/60;
		seconds%=60;
		minutes%=60;
		houres%=24;
	}	
	public void show (){

		if (houres<10){
			System.out.print("0");
		}
		System.out.print(houres + ":");
		if (minutes<10){
			System.out.print("0");
		}
		System.out.print(minutes + ":");
		if (seconds<10){
			System.out.print("0");
		}
		System.out.print(seconds);
		System.out.println();
	}
	public void resetClock (){
		seconds=0;
		minutes=0;
		houres=0;
		System.out.println("The Clock has been reseted");
	}
}

	

