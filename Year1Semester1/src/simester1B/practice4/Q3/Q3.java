package simester1B.practice4.Q3;

public class Q3 {
	
	public static void main(String[] args){
		Button but1 = new Button();
		
		
		but1.addCounterListner(new counterListner() {
			
			@Override
			public void counterUsed(CounterEvent ce) {
				System.out.println(ce.getCounter());
				
			}
		});
		
		but1.push();
		but1.push();
		but1.push();
	}
	
	
	
	
}
