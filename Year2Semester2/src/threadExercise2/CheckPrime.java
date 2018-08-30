package threadExercise2;

import java.util.concurrent.Callable;

public class CheckPrime implements Callable<TaskAnswer> {

	private int number;

	public CheckPrime(int number) {
		this.number = number;
	}

	@Override
	public TaskAnswer call() throws Exception {
		return new TaskAnswer(number, isPrime(number));
	}

	public void setNumber(int number) {
		this.number = number;
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
