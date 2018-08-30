package simester1.word_assignment3_workspace1;

import java.util.*;

public class Ch5_q12 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		final int upperBar=10, lowerBar=1;
		int rows, columns, maxValue=0;
		int[][] numbers = new int[10][10];
		
		System.out.println("Please enter the number of rows you would like your table to have "
				  + "\nthe number sould be from 1 to 10 ");
		do{																				//number of rows
		rows = s.nextInt();
		if((rows>upperBar)||(rows<lowerBar)){
			System.out.println("You have entered a wrong number. Please enter a number from 1 to 10:");
		}
		}while((rows>upperBar)||(rows<lowerBar));
		System.out.println("Please enter the number of columns you would like your table to have "
				  + "\nthe number sould be from 1 to 10 ");
		do{ 																			//number of columns
		columns = s.nextInt();
		if((columns>upperBar)||(columns<lowerBar)){
			System.out.println("You have entered a wrong number. Please enter a number from 1 to 10:");
		}
		}while((columns>upperBar)||(columns<lowerBar));
		
		System.out.printf("Please enter %d numbers \n",columns*rows);					//enter numbers to the array
		for(int rowsCells=0 ;rowsCells<rows ;rowsCells++){
			for (int columnsCells=0 ; columnsCells<columns ; columnsCells++){
				numbers[rowsCells][columnsCells] = s.nextInt();
				if (numbers[rowsCells][columnsCells]>maxValue){
					maxValue=numbers[rowsCells][columnsCells];
				}
			}
		}
		for(int rowsCells=0 ;rowsCells<rows ;rowsCells++){
			for (int columnsCells=0 ; columnsCells<columns ; columnsCells++){
				System.out.print(numbers[rowsCells][columnsCells]+"\t");
			}
		System.out.println();
		}
		System.out.printf("The highest number in the table is %d \n", maxValue);
	}
}