package simester1B.practice4.Q3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

public class Button implements Serializable {
	
	private static final long serialVersionUID = 1L;
	int counter;
	ArrayList<counterListner> counterListnersArray = new ArrayList<>();
	
	public Button(){
		
	}
	
	public void push(){
		counter++;
		activeEvent(new CounterEvent(this, counter));
	}
	
	public synchronized void addCounterListner(counterListner ac) {
		counterListnersArray.add(ac);
	}
	
	public synchronized void removeCounterListner(counterListner ac) {
		counterListnersArray.remove(ac);
	}
	
	public synchronized void activeEvent (CounterEvent ac){
		for(counterListner actionArray : counterListnersArray){
			actionArray.counterUsed(ac);
		}
	}
}
