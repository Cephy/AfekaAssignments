package simester1.practice_makes_perfect.practice_makes_perfect.presentation9;

public class Car {

	private int carSpeed;
	private int carNumber;
	
	public void setCarNumber (int carNumber){
		this.carNumber = carNumber;
	}
	public int getCarNumber (){
		return carNumber;
	}
	
	public void accelerateCar (){
		carSpeed++;
	}
	public void deccelerateCar (){
		carSpeed--;
	}
	public void stopCar(){
		carSpeed = 0;
	}
	public void printCarData(){
		System.out.printf("Car number %d is going at %d km per hour\n", carNumber, carSpeed);
	}
	
}
