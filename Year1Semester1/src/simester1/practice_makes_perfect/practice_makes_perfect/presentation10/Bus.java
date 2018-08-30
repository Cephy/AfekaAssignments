package simester1.practice_makes_perfect.practice_makes_perfect.presentation10;

public class Bus {

	private static int idCounter=0;
	private int id;
	private int numOfSeats;
	
	public Bus (int numOfSeats){	
		this.numOfSeats = numOfSeats;
		idCounter++;
		id = idCounter;
	}	
	public void setNumOfSeats (int numOfSeats){
		this.numOfSeats = numOfSeats;
	}
	public int getNumOfSeats(){
		return numOfSeats;
	}
	
}
