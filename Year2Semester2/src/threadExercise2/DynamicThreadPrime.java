package threadExercise2;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DynamicThreadPrime {
	
	private boolean primeFound;
	private boolean workDone;
	private int primeNumber = -1;
	private int higherBar;
	private int numberOfThreads;
	private ExecutorService threadPool;
	private PrimeBuffer numberBuffer;
	private ArrayList<Future<TaskAnswer>> futures; 
	
	public DynamicThreadPrime(int lowerBar, int higherBar, int numberOfThreads) {
		threadPool = Executors.newFixedThreadPool(numberOfThreads);
		numberBuffer = new PrimeBuffer(numberOfThreads, lowerBar);
		futures = new ArrayList<Future<TaskAnswer>>();
		primeFound = false;
		workDone = false;
		this.higherBar = higherBar;
		this.numberOfThreads = numberOfThreads;
	}
	
	public int runDrynamicly() throws InterruptedException, ExecutionException{
		for (int threadCounter=0 ; threadCounter < numberOfThreads ; threadCounter++) {
			futures.add(threadPool.submit(new CheckPrime(numberBuffer.getTask())));
		}
		
		while(!primeFound && !workDone) {
			for (int taskCounter = 0 ; taskCounter < futures.size() ; taskCounter++) {
				if(futures.get(taskCounter).isDone()){
					if(futures.get(taskCounter).get().getCheck()) {
						primeFound= true;
						primeNumber = futures.get(taskCounter).get().getPrimeNumber();
						threadPool.shutdownNow();
						break;
					}
					else {
						if(futures.get(taskCounter).get().getPrimeNumber() > higherBar) {
							workDone = true;
							primeNumber = -1;
							break;
						}
					}
					futures.set(taskCounter, threadPool.submit(new CheckPrime(numberBuffer.getTask())));
				}
			}
		}
		
		return primeNumber;
	}
}
