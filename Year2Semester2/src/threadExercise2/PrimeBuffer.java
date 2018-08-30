package threadExercise2;

public class PrimeBuffer {
	
	private int numberCounter;
	private int taskCounter;
	private int numberBuffer[];
	
	public PrimeBuffer(int bufferSize, int lowerBar) {
		numberCounter = lowerBar;
		taskCounter = 0;
		numberBuffer = new int[bufferSize];
		for (int counter=0 ; counter < bufferSize ; counter++) {
			numberBuffer[counter] = numberCounter;
			numberCounter++;
		}
	}
	
	public synchronized int getTask() {
		int tmpNumber;
		
		tmpNumber = numberBuffer[taskCounter];
		numberBuffer[taskCounter] = numberCounter;
		numberCounter++;
		taskCounter = (taskCounter + 1) % numberBuffer.length;
		
		return tmpNumber;
	}
	
	public synchronized int getNumberCounter(){
		return numberCounter;
	}
}
