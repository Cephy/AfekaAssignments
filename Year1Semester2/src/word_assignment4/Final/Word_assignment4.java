package word_assignment4.Final;

import java.util.*;

public class Word_assignment4 {

	public static void main (String[] args){
		Scanner s = new Scanner(System.in); 
		boolean ifContinue = true;
		int question;
		
		do{
			System.out.println("\n~~~~~~~~Chapter Selection~~~~~~~~\n");
			System.out.println("Please  choose one of the following questions:");
			System.out.println("Chapter 8 question 1: sort matrix from Smallest to Biggest - Press 1 ");
			System.out.println("Chapter 8 question 2: sort matrix diagonal - Press 2");
			System.out.println("Chapter 8 question 3: sort string of letters - Press 3");
			System.out.println("Chapter 8 question 4: find number in a matrix - Press 4");
			System.out.println("Chapter 8 question 5: Sort matrix - Press 5");
			System.out.println("Chapter 7 question 5: determin is a number is a Kaprekar number - Press 6");
			System.out.println("Press 0 to exit");
			question = s.nextInt();

			switch(question){
				case 1:{
					int size;
					
					System.out.println("Please enter the number of digits your number will contain");
					size = s.nextInt();
					
					int[] numbers = new int[size];
					System.out.printf("Please enter a %d digits array of numbers\n" ,size);
					for (int i=0 ; i<numbers.length ; i++){
						numbers[i] = s.nextInt();
					}	
					
					numbers = sort (numbers);
					
					for (int c: numbers){
						System.out.print(c);
					}
					break;
				}
				case 2:{
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
					break;
				}
				case 3:{
					System.out.println("Please enter a random number of letters (they could be capital or regular)");
					String letters = s.next();
					
					char[] lettersArray = letters.toCharArray();
					lettersArray = checkOrder(lettersArray);
					
					for(char c: lettersArray){
				           System.out.print(c);
				       }
					break;
				}
				case 4:{
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
					break;
				}
				case 5:{
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
					break;
				}
				case 6:{
					final int MAX_NUMBER = 10000;
					int num; 
					long time1, time2, time3;
					int[] parts = new int[2];
					
					time1 = System.currentTimeMillis();
					for(int i=9 ; i<MAX_NUMBER ; i++){
						if(isKaprekarXXX(i, parts)){
							System.out.printf("*** %d (&d^2 = %d) %d -- %d\n" ,i,i,(i*i), parts[1], parts[0]);
						}
					}
					time2 = System.currentTimeMillis();
					for(int i=9 ; i<MAX_NUMBER ; i++){
						if(isKaprekarString(i, parts)){
							System.out.printf("*** %d (&d^2 = %d) %d -- %d\n",i,i,(i*i), parts[1], parts[0]);
						}
					}
					time3 = System.currentTimeMillis();
					System.out.println("Using int took:" + (time2-time1) + "milisec");
					System.out.println("Using String took: " + (time3-time2) + "milisec");
					break;
				}
				case 0:{
					System.out.println("Good bye");
					ifContinue = false;
					break;
				}
				default:{
					System.out.println("We are sorry, we do not have that question in our data base.");
				}
			}
			
			
		}while(ifContinue);
		
		s.close();
	}
	//   						~~~~~~~~~~~~~~~~~~Functions~~~~~~~~~~~~~~~~~~
	public static int[] sort (int[] numbers){
		for (int i=numbers.length-1 ; i>0 ; i--){
			for (int j=0 ; j<i ; j++){
				if (numbers[j]<numbers[i]){
					swapNumbers(numbers, j);
				}
			}
		}
		return numbers;
	}
	public static void swapNumbers(int[] numbers, int location){
		int temp = numbers[location];
		numbers[location] = numbers[(location+1)];
		numbers[(location+1)]= temp;
	}
	public static void swapDiag (int[][] array, int location){
		int temp = array[location][location];
		array[location][location]=array[(location+1)][(location+1)];
		array[(location+1)][(location+1)] = temp;
	}
	public static char[] checkOrder (char[] lettersArray){
		final int asciiCapital = 65, asciiSmall = 97;
		for (int i = lettersArray.length-1 ; i>0 ; i-- ){
			for(int j=0 ; j<i ; j++){
				if(((lettersArray[j])-(lettersArray[j]<asciiSmall?asciiCapital:asciiSmall))>
				  ((lettersArray[j+1])-(lettersArray[j+1]<asciiSmall?asciiCapital:asciiSmall))){					
					swapChar(lettersArray, j);
				}
			}	
		}
		return lettersArray;
	}
	public static void swapChar (char[] lettersArray, int location){
		char temp = lettersArray[location];
		lettersArray[location] = lettersArray[(location+1)];
		lettersArray[(location+1)] = temp;
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
	public static boolean isKaprekarXXX (int num, int[] parts){
		int counter=0, sipha=0, risha, numSquare;
		numSquare = num*num;
		for (int i=numSquare ; i!=0 ; i/=10){
			counter++;
		}
		counter/=2;
		for(int i=0, power=1 ; i<counter ; i++, numSquare/=10, power*=10){
			sipha+=(numSquare%10)*power;
		}
		risha=numSquare;
		if((risha+sipha)==num){
			parts[0] = risha; 
			parts[1] = sipha;
			return true;
		}
		else{
			return false;
		}
	}
	public static boolean isKaprekarString (int num, int[] parts){
		int counter;
		String numSquare, risha, sipha;
		numSquare = Integer.toString(num*num);
		counter = (numSquare.length()/2);
		risha = numSquare.substring(0, counter);
		sipha = numSquare.substring(counter, numSquare.length());
		if(num==(Integer.valueOf(risha)+Integer.valueOf(sipha))){
			parts[0] = Integer.valueOf(risha);
			parts[1] = Integer.valueOf(sipha);
			return true;
		}
		else{
			return false;
			
		}
	}
}
