package simester1.practice_makes_perfect.practice_makes_perfect.presentation9;

import java.util.*;

public class Ch1_q2 {

	public static void main (String[] args){
		Scanner s = new Scanner(System.in);
		Car car = new Car();
		
		System.out.println("Please enter the car number");
		car.setCarNumber(s.nextInt());
		
		car.printCarData();
		
		int carAcceleration;
		System.out.println("how much would to accelerate the car?");
		carAcceleration = s.nextInt();
		for (int i=0 ; i<=carAcceleration ; i++){
			car.accelerateCar();
		}
		car.printCarData();
		
		for (int i=0 ; i<=2 ; i++){
			car.deccelerateCar();
		}
		car.printCarData();
		
		car.stopCar();
		car.printCarData();
	}
}
