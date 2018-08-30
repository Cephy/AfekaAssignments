package simester1.practice_makes_perfect.practice_makes_perfect.presentation7;

import java.util.*;

public class Ch1_q2 {

	public static void main (String[] args){
		Scanner s = new Scanner(System.in); 		
		System.out.println("Please enter a random number of letters (they could be capital or regular)");
		String letters = s.next();
		
		char[] lettersArray = letters.toCharArray();
		lettersArray = checkOrder(lettersArray);
		
		for(char c: lettersArray){
	           System.out.print(c);
	       }		
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
}


	 