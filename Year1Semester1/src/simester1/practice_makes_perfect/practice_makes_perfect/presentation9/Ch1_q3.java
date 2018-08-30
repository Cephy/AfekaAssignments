package simester1.practice_makes_perfect.practice_makes_perfect.presentation9;

import java.util.*;

public class Ch1_q3 {

	public static void main (String[] agrs){
		Scanner s = new Scanner(System.in);
		int arraySize;
		
		System.out.println("How many persons would you like to enter?");
		arraySize = s.nextInt();
		
		Person[] personsArray = new Person[arraySize];
		
		for (int i=0 ; i<personsArray.length ; i++){
			if (i>0){
				System.out.println("----Next person----\n");
			}
			personsArray[i] = new Person();
			System.out.println("Please enter the name of the person");
			personsArray[i].setName(s.next());
			System.out.printf("Please enter the weight of %s\n" ,personsArray[i].getName());
			personsArray[i].setWeight(s.nextInt());
			System.out.printf("Please enter the hight if %s\n" ,personsArray[i].getName());
			personsArray[i].setHight(s.nextInt());
		}
		
		Group group = new Group();
		group.setPersonsArray(personsArray);
		
		System.out.println("The persons you enterd from fat to thin");
		group.sortHighToLow();
		group.print();;
		System.out.println("The persons you enterd from thin to fat");
		group.sortLowtoHigh();
		group.print();
	}
}
