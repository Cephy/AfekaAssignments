package simester1.word_assignment4_workspace;

import java.util.*;

public class ch8_q4 {
	
	public static void main (String[] args){
		Scanner s = new Scanner (System.in);
		int size;
		
		System.out.println("Please enter the size of your matrix");
		size = s.nextInt();
		
		int[][] numbers = new int[size][size];
		for (int column=0 ; column<numbers.length ; column++){
			System.out.printf("Please enter %d numbers for row number %d \n" ,size,column+1);
			for (int row=0 ; row<numbers.length ; row++){
				numbers[column][row] = s.nextInt();
			}
		}
		
		sortArray(numbers);
				
		printArray(numbers);

		int value;
		StringBuffer locationResult;
		System.out.println("Please enter the number you wish to find");
		value = s.nextInt();
		locationResult = search(numbers, value);
		if (locationResult == null){
			System.out.println("Your number does not exist in the matrix");
		}
		else{
			System.out.printf("Your number is at %s " , locationResult);
		}
		System.out.println("");
	}
	public static void sortArray (int[][] numbers){
		for (int row=0 ; row<numbers.length ; row++){
			for (int j=numbers.length-1 ; j>0 ; j--){
				for (int column=0 ; column<j ; column++){
					if(numbers[column][row]>numbers[column+1][row]){
						swapNumbers2 (numbers, column,row);
					}
				}
			}
		}	
	}
	public static void swapNumbers2 (int[][] numbers, int columnLocation, int rowLocation){
	int temp = numbers[columnLocation][rowLocation];
	numbers[columnLocation][rowLocation] = numbers[columnLocation+1][rowLocation];
	numbers[columnLocation+1][rowLocation] = temp; 
	}
	
	public static StringBuffer search (int[][] numbers, int value){
		StringBuffer locationResult = new StringBuffer ("Row  Column  ");

		for (int row=0 ; row<numbers.length ; row++){
			int column=0, low=0, high=numbers.length-1;
			while(low<=high){
				column=((low+high)/2);
				if(numbers[column][row]==value){
					locationResult.insert(4, column+1);
					locationResult.insert(13, row+1);
					return locationResult;
				}
				if (value<numbers[column][row]){
					high = column-1;
				}
				else{
					low = column+1;
					}
			}
		}
		return locationResult=null;
	}	
	public static void printArray (int[][] numbers){
		for (int column=0 ; column<numbers.length ; column++){
			for (int row=0 ; row<numbers.length ; row++){
				System.out.printf("(%d)\t", numbers[column][row]);
			}
			System.out.println();
		}
	}
}