package threadExercise2;


import java.util.concurrent.ExecutionException;

public class Assn2 {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		//TODO add a data structure of future and number
		
		int lowerBar = 5;
		int higherBar = 194;
		int numberOfThreads = 5;		
		
		DynamicThreadPrime dTP = new DynamicThreadPrime(lowerBar, higherBar, numberOfThreads);
		System.out.println(dTP.runDrynamicly());
	}
}
