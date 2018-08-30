package threadExercise1;

public class CheckPrime implements Runnable{
	
	private int number;
	private boolean isPrime;
	
	public CheckPrime(int number){
		this.number = number;
	}

	@Override
	public void run() {
		if(checkIfPrime(number)){
			isPrime = true;
		}
	}
	
	public boolean getIsPrime(){
		return isPrime;
	}
	
	private static boolean checkIfPrime(int number){
		// check if n is a multiple of 2
		 if (number%2==0) return false;
		// if not, then just check the odds
		 for(int i=3 ; i*i <= number ; i+=2){
		 if(number%i==0)
		 return false;
		 }
		 return true;	
	}
}
