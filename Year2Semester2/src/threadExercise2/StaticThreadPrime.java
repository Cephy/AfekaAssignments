package threadExercise2;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class StaticThreadPrime {
	
	private boolean primeFound;
	private boolean workDone;
	private int lowerBar;
	private int higherBar;
	private int numberOfThreads;
	private ExecutorService threadPool;
	private ArrayList<Future<TaskAnswer>> futures; 
	
	public StaticThreadPrime(int lowerBar, int higherBar, int numberOfThreads){
		threadPool = Executors.newFixedThreadPool(numberOfThreads);
		futures = new ArrayList<Future<TaskAnswer>>();
		this.higherBar = higherBar;
		this.lowerBar = lowerBar;
		this.numberOfThreads = numberOfThreads;
	}
	
	public int run() throws InterruptedException, ExecutionException{
		int primeNumber = -1;
		
		for(int devider = lowerBar ; devider < higherBar ; devider += numberOfThreads){
			futures.add(threadPool.submit(new CheckPrimeList(devider, devider+numberOfThreads)));
		}
		
		while(!primeFound && !workDone) {
			for (int taskCounter = 0 ; taskCounter < futures.size() ; taskCounter++) {
				if(futures.get(taskCounter).isDone()){
					if(futures.get(taskCounter).get().getCheck()) {
						primeFound = true;
						primeNumber = futures.get(taskCounter).get().getPrimeNumber();
						threadPool.shutdownNow();
						break;
					}
					futures.remove(future);
				}
			}
			if (futures.isEmpty()){
				workDone = true;
				primeNumber = -1;
			}
		}
		
		return primeNumber;
		
	}
	
	
}
