package threadExercise2;

import java.util.concurrent.Callable;

public class CheckPrimeList implements Callable<TaskAnswer>{

	private int lowerBar;
	private int higherBar;

	public CheckPrimeList(int lowerBar, int higherBar) {
		this.lowerBar = lowerBar;
		this.higherBar = higherBar;
	}
	
	@Override
	public TaskAnswer call() throws Exception {
		for( ; lowerBar <= higherBar ; lowerBar++) {
			if(isPrime(lowerBar)) {
				return new TaskAnswer(lowerBar, true);
			}
		}
		return new TaskAnswer(lowerBar, false);
	}
	
	public boolean isPrime(int n) {
		// check if n is a multiple of 2
		if (n % 2 == 0)
			return false;
		// if not, then just check the odds
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
	
}
