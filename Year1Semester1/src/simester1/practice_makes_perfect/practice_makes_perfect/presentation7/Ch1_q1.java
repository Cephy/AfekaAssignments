package simester1.practice_makes_perfect.practice_makes_perfect.presentation7;

import java.util.*;

public class Ch1_q1 {

	public static void main (String[] args){
		Scanner s = new Scanner(System.in);
		
		int size;
		System.out.println("what size do you want your array to be?");
		size = s.nextInt();
		
		int[][] numbers = new int [size][size];
		
		for (int column=0 ; column<numbers.length ; column++){
			System.out.printf("Please enter %d numbers for row number %d" ,numbers.length,(column+1));
			for (int row=0 ; row<numbers.length ;row++ ){
				numbers[column][row] = s.nextInt();
			}
		}
		
		for ( int j=numbers.length-1 ; j>0 ; j--){
			for ( int i=0 ; i<j ; i++){
				if (numbers[i][i]>numbers[(i+1)][(i+1)]){
					swapDiag (numbers, i);
				}
			}
		}
		
		for (int column=0 ; column<numbers.length ; column++ ){
			for (int row=0 ; row<numbers.length ; row++ ){
				System.out.print("("+ numbers[column][row]+")");
			}
		System.out.println();	
		}
	}

	public static void swapDiag (int[][] array, int location){
		int temp = array[location][location];
		array[location][location]=array[(location+1)][(location+1)];
		array[(location+1)][(location+1)] = temp;
	}
}

