package threadExercise1;

public class PrimeBuffer {
	
	private boolean isPrimeFound;
	private int numberCounter;
	private int tasks;
	private int tasksBuffer[];
	
	public PrimeBuffer(int bufferSize){
		isPrimeFound = false;
		numberCounter = 0;
		tasks = 0;
		tasksBuffer = new int[bufferSize];
	}
	
	public synchronized int removetPrim(){
		int primeNumber;
		while(!isPrimeFound){
			try{
				wait();
			}
			catch(InterruptedException e){
				
			}
		}
		primeNumber = tasksBuffer[tasks];
		tasksBuffer[tasks] = numberCounter;
		numberCounter++;
		tasks = (tasks + 1) % tasksBuffer.length;
	
		return primeNumber;
	}
	
	
}
