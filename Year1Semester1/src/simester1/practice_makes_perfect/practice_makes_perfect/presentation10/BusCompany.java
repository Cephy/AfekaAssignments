package simester1.practice_makes_perfect.practice_makes_perfect.presentation10;

public class BusCompany {

	private String name;
	private static final int MAX_NUM_OF_BUS = 100;
	private Bus[] allBuses = new Bus[MAX_NUM_OF_BUS];
	private int numOfBuses=0;
		
		public BusCompany (String name){
			this.name = name;
		}
		public void setName (String name){			
			this.name = name;
		}
		public String getName () {
			return name;
		}
		public boolean addBus (int numOfSeats){
			if(numOfBuses<MAX_NUM_OF_BUS){
				allBuses[numOfBuses] = new Bus (numOfSeats);
				numOfBuses++;
				return true;	 
			}
			else{
				return false;
			}
		}
		public void printBusCompany (){
			System.out.printf("there are %d buses\n", numOfBuses);
			for(int i=0 ; i<numOfBuses ; i++){
				System.out.printf("bus number %d have %d seats\n" ,i,allBuses[i].getNumOfSeats());
			}
		}
}
