package threadExercise2;

public class TaskAnswer {
	
	private int primeNumber;
	private boolean check;
	
	TaskAnswer(int primeNumber, boolean check){
		this.primeNumber = primeNumber;
		this.check = check;
	}
	
	public int getPrimeNumber() {
		return primeNumber;
	}
	
	public boolean getCheck() {
		return check;
	}
	
}
