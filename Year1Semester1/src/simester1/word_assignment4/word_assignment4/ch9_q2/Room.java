package simester1.word_assignment4.word_assignment4.ch9_q2;

import java.io.PrintWriter;
import java.util.*;

public class Room {
	
	private final int MAX_NUM_OF_BEDS = 4, MIN_NUM_OF_BEDS = 1; 
	private int numOfBeds;
	private Guest[] allGuests;
	private boolean isRoomFull=false;
	
	public Room (int numOfBeds){
		this.numOfBeds = numOfBeds;
		allGuests = new Guest[numOfBeds]; 
	}
	
	public void setGuests (Guest[] allGuests){
		numOfBeds = allGuests.length;
		this.allGuests = allGuests;
		isRoomFull = true;
	}	
	public Room (Scanner s){
		numOfBeds = s.nextInt();
		String checkIsRoomFull = s.next();
		if(checkIsRoomFull.equals("true")){
			isRoomFull=true;
		}
		if (isRoomFull){
			allGuests = new Guest[numOfBeds]; 
			for (int i=0 ; i<allGuests.length ; i++ ){
				allGuests[i] = new Guest(s);
			}
		}	
	}
	public void save(PrintWriter pw){
		pw.println(numOfBeds);
		pw.println(isRoomFull);
		System.out.println("done");
		for(int i=0 ; i<allGuests.length ; i++){
			if(isRoomFull){
			allGuests[i].save(pw);
			}
		}		
	}
	
	public boolean setNumOfBeds (int numOfBeds){
		if (numOfBeds>MAX_NUM_OF_BEDS || numOfBeds < MIN_NUM_OF_BEDS){
			return false;
		}
		else{
			this.numOfBeds = numOfBeds;
			return true;
		}
	}
	
	public int getNumOfBeds (){
		 return numOfBeds;
	}
	public String findGuest (int passportNumber){
		for (int i=0 ; i<allGuests.length; i++){
			if(passportNumber==allGuests[i].getPassportNumber()){
				return allGuests[i].getName();
			}
		}
		return null;
	}
	public boolean getIsRoomFull(){
		return isRoomFull;
	}
	public void Print (){
		if(isRoomFull){
			System.out.printf("There are %d guests in this room:\n", numOfBeds);
			for(int guest=0 ; guest<allGuests.length ; guest++){
				allGuests[guest].print();
			}
		}
		else{
			System.out.printf("The room is currently empty and there are %d beds in this room\n",numOfBeds);
		}
	}
}
