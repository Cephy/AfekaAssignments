package simester1.practice_makes_perfect.practice_makes_perfect.presentation13;

import java.util.*;

public class Presentation13Main {
	
	public static void main (String[] args){
		Scanner s = new Scanner(System.in);
		boolean ifCotinue = true;
		int answer;
		
		do{
			System.out.println("1 - Sum of digits");
			System.out.println("2 - Is number sorted");
			System.out.println("3 - Repetition of a number in a number's array");
			System.out.println("4 - are all the letters equal?");
			answer = s.nextInt();
			
			switch(answer){	
				case 1:{
					int sum, num;
					System.out.println("enter a number");
					num = s.nextInt();
					sum = SumOfDigits(num);
					System.out.println("the fucking sum is " + sum);
					break;
				}
				case 2:{
					int num;
					System.out.println("enter a number");
					num = s.nextInt();
					if(isNumberSorted(num)){
						System.out.println("cool it is sorted");
						break;
					}
					System.out.println("shit it is not sorted");
					break;
				}
				case 3:{
					int location, number, sumOfRepitition;
					
					System.out.println("Please enter the size of your array of numbers");
					location = s.nextInt();
					int[] numberArray = new int[location];
					
					System.out.println("Please enter the numbers in your array");
					for(int i=0 ; i<numberArray.length ; i++){
						numberArray[i] = s.nextInt();
					}
					
					System.out.println("Plese enter the number you wish to find");
					number = s.nextInt();
					sumOfRepitition = numOfTimesInArray(numberArray, location, number);
					System.out.printf("Your number appears %d times in the array\n", sumOfRepitition);
					break;
				}
				case 4:{
					String word;
					System.out.println("Please enter a string of letters");
					word = s.next();
					if(areAllLettersEqual(word)){
						System.out.println("cool, all of the letters are the same");
					}
					else{
						System.out.println("sorry bro letters are different");
					}
					break;
				}
			}

		}while(ifCotinue);
		s.close();
	}
	public static int SumOfDigits (int num){
		int temp = num%10;
		num = num/10;
		if(num==0){
			return temp;
		}
		return temp+SumOfDigits(num);
	}
	public static Boolean isNumberSorted (int num){
		int temp1 = num%10;
		num = num/10;
		int temp2 = num%10;
		if(num==0){
			if (temp1>temp2){
				return true;
			}
			return false;			
		}
		if(isNumberSorted(num)&&(temp1>temp2)){
			return true;
		}
		return false;
	}
	public static int numOfTimesInArray (int[] numberArray,int location,int number){
		if((location-1)==0){
			if(numberArray[location]==number){
				return 1;
			}
			else return 0;
		}
		if(numberArray[location-1]==number){
			return (1+numOfTimesInArray(numberArray, (location-1), number));
		}
		else{
			return numOfTimesInArray(numberArray, (location-1), number);
		}
	}
	
	public static boolean areAllLettersEqual (String word){
		final int ASCII_LOW = 97, ASCII_CAPITAL = 65;
		int tempInt1, tempInt2;
		if(word.length()==1){
			return true;
		}
		String temp1 = word.substring(0 ,1);
		String temp2 = word.substring(1 ,2);
		
		if(areAllLettersEqual(word.substring(1 ,word.length()))&&temp1.equals(temp2)){
			return true;
		}
		return false;
	}		
}
