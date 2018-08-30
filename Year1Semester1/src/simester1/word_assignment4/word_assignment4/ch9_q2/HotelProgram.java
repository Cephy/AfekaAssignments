package simester1.word_assignment4.word_assignment4.ch9_q2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class HotelProgram {

	public static void main (String[] args)throws FileNotFoundException{
		Scanner s = new Scanner(System.in);
		boolean ifContinue = true;
		String hotelName;
		int numOfRooms, numOfFloors, menu=0;
		final int ADD_NEW_GUESTS=1, LOCATE_GUEST=2, LEAST_GUEST=3, PRINT_HOTEL=4, SAVE=8,EXIT=9;
		final String FILE_NAME = "Hotel.txt";
		
		Hotel hotel = new Hotel();
		
		System.out.println("Would you like to load your hotel from a saved file?");
		char answer = s.next().charAt(0);
		if(answer=='y'||answer=='Y'){
			hotel = new Hotel(FILE_NAME);
		}
		else{
			System.out.println("What is the name of your hotel");
			hotelName = s.next();
			System.out.println("How many floors does your hotel have?");
			numOfFloors = s.nextInt();
			System.out.println("How many rooms each floor your hotel have?");
			numOfRooms = s.nextInt();
			
			hotel = new Hotel(hotelName, numOfRooms, numOfFloors);
		}
		
		do{
			System.out.println("Please choose one of the following options:");
			System.out.printf("To add new guests to the hotle please press %d\n", ADD_NEW_GUESTS);
			System.out.printf("To locate a guest in the hotel press %d\n", LOCATE_GUEST);
			System.out.printf("To check which floor has the least guests press %d\n", LEAST_GUEST);
			System.out.printf("To print the hotel's details press %d\n", PRINT_HOTEL);
			System.out.printf("To save your hotel onto a file press %d\n", SAVE);
			System.out.printf("To exit the program please press %d\n", EXIT);
			menu = s.nextInt();
			
			switch(menu){
				case ADD_NEW_GUESTS:{
					int size;
					
					System.out.println("for how many guests you need to find a room? ");
					size = s.nextInt();
					
					Guest[] guests = new Guest[size];
					
					for (int i=0 ; i<size ; i++){
						String name;
						int passportNumber;
						System.out.println("Please enter the client's name");
						name = s.next();
						System.out.println("Please enter the cilent's passport number");
						passportNumber = s.nextInt();
						
						guests[i] = new Guest(name, passportNumber);
						}
					int roomLocation = hotel.sendGuestsToRoom(guests);
					System.out.printf("Please direct the guests to room number %d\n" ,roomLocation);
					break;
				}
				case LOCATE_GUEST:{
					System.out.println("Please enter the guest passport number:");
					int passportNumber = s.nextInt();
					if(-1==hotel.findGuest(passportNumber)){
						System.out.println("We are sorry the is no guest with that passport number");
					}
					else{
						System.out.printf("the guest is in room number %d" ,hotel.findGuest(passportNumber));
					}
					break;
				}
				case LEAST_GUEST:{
					System.out.printf("floor number %d has the most available rooms \n\n",hotel.mostEmptyFloor());
					break;
				}
				case SAVE:{
					File file = new File (FILE_NAME);
					hotel.save(file);					
					break;
				}
				case PRINT_HOTEL:{
					hotel.print();
					break;
				}
				case EXIT:{
					System.out.println("Good-bye");
					ifContinue = false;
					break;
				}
				default:{
					System.out.println("We are sorry, the letter you have entered has no function please read closely the menu and try again.");
					break;
				}
			}
		}while(ifContinue);
	s.close();	
	}
}
