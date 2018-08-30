package simester1.practice_makes_perfect.practice_makes_perfect.presentation10;

import java.util.*;

public class BusPrograme {
	
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int menu=0;
		boolean ifContinue = true;
		
		System.out.println("what is the name of your bus company?");
		BusCompany buscompany = new BusCompany(s.next());
		
		
		
		do{
			System.out.println("choose");
			System.out.println("1 - add bus");
			System.out.println("2 - print buses");
			System.out.println("8 - return to menu");
			System.out.println("9 - exit");
			menu = s.nextInt();
			
			switch(menu){
				case 1:{
					System.out.println("how many seats on the new bus");
					int numOfSeats = s.nextInt();
					if(buscompany.addBus(numOfSeats));{
						System.out.println("to add another bus press 1 to exit press 9");
						menu = s.nextInt();
						break;
					}
				}
				case 2:{
					buscompany.printBusCompany();
					break;
				}
				case 8:{
					break;
				}
				case 9:{
					System.out.println("Good bye");
					ifContinue = false;
					break;
				}
				default:{
					System.out.println("sry not a valid answer");
					break;
				}
			}
		}while(ifContinue);
	}
}
