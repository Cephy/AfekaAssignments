package simester1.word_assignment4.word_assignment4.Ch9_q1;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Program {

	public static void main (String[] args)throws IOException{
		Scanner s = new Scanner (System.in);
		int menu=0;
		final String FILE_NAME = "Collage.txt"; 
		final int optionPrintcollege=3,optionAddLecturer=1, optionExit=9, optionSort=2, optionSaveData=4;
		Boolean ifContinue = true;
		String collegeName;
		int maxNumOfLecturers;
		
		College college = new College();
		
		System.out.print("Would you like to load date from a saved file?");
		char load = s.next().charAt(0);
		if(load=='y'){
			college = new College(FILE_NAME);
		}
			
		else {
			System.out.println("What is the name of the college?");
			collegeName = s.next();
			System.out.printf("What is the maximum number of lecturers in %s \n", collegeName);
			maxNumOfLecturers = s.nextInt();
			
			college = new College (collegeName, maxNumOfLecturers);
		}
		
		do{
			System.out.println("\n----main menu----\n");
			System.out.println("Please choose one of the following options:");
			System.out.printf("Enter %d to add a Lecturer\n", optionAddLecturer);
			System.out.printf("Enter %d to sort all the lectuerers by the number times they droped their pen \n",optionSort);
			System.out.printf("Enter %d to print out college details\n",optionPrintcollege);
			System.out.printf("Enter %d to save the system's data\n", optionSaveData);
			System.out.printf("Enter %d to exit", optionExit);
			menu = s.nextInt();
			
			switch (menu){
				case optionAddLecturer:{
					if(college.checkIfAddLecturerer()==false){
						System.out.printf("There is no more room for another lecturer in %s college\n", college.getName());
						break;
					}
					else{
					String name, favoriteIceCream;
					int numOfPenFalls;
					System.out.println("\n----Add new Lecturer----");
					System.out.println("What is the name of the new lecturer?");
					name = s.next();
					System.out.println("What is his or her's favorite type of ice cream?");
					favoriteIceCream = s.next();
					System.out.println("What is the average amount he or she drops their pen in a lesson?");
					numOfPenFalls = s.nextInt();
					college.addLecturerer(name, numOfPenFalls, favoriteIceCream);
					break;
					}
				}
				case optionPrintcollege:{
					System.out.println("\n----Printing Lecturers----\n");
					college.printLecturer();
				}
				case optionSort:{
					college.sortLecturerArray();
					System.out.println("\nLectures have been sorted\n");
					break;
				}
				case optionSaveData:{
					File file = new File(FILE_NAME);
					college.save(file);
					break;
				}
				case optionExit:{
					System.out.println("Good bye");
					ifContinue = false;
					break;
				}
			}
		}while(ifContinue);
		s.close();
	}
}
