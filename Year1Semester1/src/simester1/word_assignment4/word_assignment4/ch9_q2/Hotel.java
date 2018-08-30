package simester1.word_assignment4.word_assignment4.ch9_q2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Hotel {
	
	private static int MIN_BEDS=1, MAX_BED=4;
	private String name;
	private int numOfUsedRooms=0;
	private Room[][] allRooms;
	private int numOfRooms, numOfFloors;
	
	public Hotel (){
		
	}	
	public Hotel (String name, int numOfRooms, int numOfFloors){
		this.numOfRooms = numOfRooms;
		this.numOfFloors = numOfFloors;
		allRooms = new Room[numOfFloors][numOfRooms];
		for(int floor=0 ; floor<numOfFloors ; floor++){
			for(int room=0 ; room<numOfRooms ; room++){
				allRooms[floor][room] = new Room((int)((Math.random()*MAX_BED)+MIN_BEDS));
			}
		}
	}
	public Hotel (String fileName)throws FileNotFoundException{
		File file = new File(fileName);
		Scanner s = new Scanner(file);
		name = s.nextLine();
		numOfUsedRooms = s.nextInt();
		numOfFloors = s.nextInt();
		numOfRooms = s.nextInt();
		allRooms = new Room[numOfFloors][numOfRooms];
		for(int floor=0 ; floor<numOfFloors ; floor++){
			for(int room=0 ; room<numOfRooms ; room++){
				allRooms[floor][room] = new Room(s);
			}
		}
		s.close();
	}
	public void save (File file)throws FileNotFoundException{
		PrintWriter pw = new PrintWriter(file);
		pw.println(name);
		pw.println(numOfUsedRooms);
		pw.println(numOfFloors);
		pw.println(numOfRooms);
		for(int floor=0 ; floor<numOfFloors ; floor++){
			for(int room=0 ; room<numOfRooms ; room++){
				allRooms[floor][room].save(pw);
			}
		}
		pw.close();
		
	}
	
	public int sendGuestsToRoom (Guest[] guests){
		for(int floor=0 ; floor<numOfFloors ; floor++){
			for(int room=0 ; room<numOfRooms ; room++){
				if (guests.length<=allRooms[floor][room].getNumOfBeds()){
					allRooms[floor][room].setGuests(guests);
					numOfUsedRooms++;
					return (((floor+1)*100)+(room+1));					
				}				
			}
		}
		return -1;
	}
	public int findGuest (int passportNumber){
		String guestName;
		for(int floor=0 ; floor<numOfFloors ; floor++){
			for(int room=0 ; room<numOfRooms ; room++){
				guestName = allRooms[floor][room].findGuest(passportNumber);
				if(guestName!=null){
					return (((floor+1)*100)+(room+1));
				}
			}
		}
		return -1;
	}
	public int mostEmptyFloor (){
		int floorSum=numOfRooms, answer=-1, temp=0;
		for(int floor=0 ; floor<numOfFloors ; floor++){
			temp=0;
			for (int room=0 ; room<numOfRooms ; room++){
				if(allRooms[floor][room].getIsRoomFull()){
					temp++;
				}
				
			}
			if (floorSum>temp){
				floorSum=temp;
				answer=floor+1;
			}
		}
		return answer;
	}
	public void print (){
		System.out.printf("Info for hotel %s:\n" ,name);
		System.out.printf("There are %d rooms booked at the moment in the hotel\n", numOfUsedRooms);
		for(int floor=0 ; floor<numOfFloors ; floor++){
			System.out.printf("\n~~~~~~~~Floor Number %d~~~~~~~~\n\n", floor+1);
			for (int room=0 ; room<numOfRooms ; room++){
				System.out.printf("-------Room Number %d-------\n", room+1);
				allRooms[floor][room].Print();
			}
		}
		
	}
}
