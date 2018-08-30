package simester1.word_assignment4_workspace;

import java.util.Scanner;

public class Ch8_q5 {

	public static void main (String[] args){
		Scanner s = new Scanner (System.in);
		int size;
		
		System.out.println("Please enter the size of your matrix");
		size=s.nextInt();
		
		System.out.println();
		int[][] numbers = new int[size][size];
		for (int column=0 ; column<numbers.length ; column++){
			System.out.printf("Please enter %d numbers for row number %d \n" ,size,column+1);
			for (int row=0 ; row<numbers.length ; row++){
				numbers[column][row] = s.nextInt();
			}
		}
		sortArraySnake(numbers);
		
		printArray2(numbers);
		s.close();
	}
	public static void sortArraySnake(int[][] numbers){
	boolean limitFlag = true, sortCheckFlag=true;
	
			for(int columnBar=numbers.length; columnBar>=0&&sortCheckFlag ; columnBar--){
				for(int rowBar=numbers.length; rowBar>=0&&sortCheckFlag ; rowBar--){
					limitFlag = true;
					sortCheckFlag = false;
					for (int column1=0 ; column1<numbers.length&&limitFlag ; column1++){
						for(int row1=0 ; row1<numbers.length&&limitFlag; row1++){
							if ((column1>=columnBar-1)&&(row1>=rowBar-1)){
								limitFlag=false;
								break;
							}
							if((numbers[column1][row1]>(numbers[(row1+1)==numbers.length?column1+1:column1][(row1+1)==numbers.length?0:row1+1]))&&(limitFlag)){
								swapSnakeArray(numbers, column1, row1);
								sortCheckFlag=true;
							}						
						}
					}
				}
			}
		}
	
	public static void swapSnakeArray (int[][] numbers, int column1, int row1){
		int temp = numbers[column1][row1];
		numbers[column1][row1] = numbers[(row1+1)==numbers.length?column1+1:column1][(row1+1)==numbers.length?0:row1+1];
		numbers[(row1+1)==numbers.length?column1+1:column1][(row1+1)==numbers.length?0:row1+1] = temp;
	}
	
	public static void printArray2 (int[][] numbers){
		for (int column=0 ; column<numbers.length ; column++){
			for (int row=0 ; row<numbers.length ; row++){
				System.out.printf("(%d)\t", numbers[column][row]);
			}
			System.out.println();
		}
	}
}