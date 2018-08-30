package simester1B.practice4.Q3;

import java.util.EventObject;

public class CounterEvent extends EventObject {
	
	
	private static final long serialVersionUID = 1L;
	private int counter;
	
	public CounterEvent (Object source, int counter){
		super(source);
		this.counter = counter;
	}
	
	public int getCounter(){
		return counter;
	}	
}
