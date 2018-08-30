package simester1.word_assignment3_workspace1;

import java.util.*;

public class Ch5_q6 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		char[] characters = new char[10];
		final int askiiLowerConstant = 97, askiiHigherConstant=122, askiiLettersGap = 32, numOfCapitalLetters=2;
		
		System.out.printf("Please enter %d Letters while %d are capital \n", characters.length,numOfCapitalLetters);
		for (int i=0 ; i<characters.length ; i++){
			characters[i] = s.next().charAt(0);
		}
		System.out.print("Your letters are: \n");
		for (int i=0 ; i<characters.length ; i++){
			if((askiiLowerConstant<=characters[i]) && (askiiHigherConstant>=characters[i])){
				characters[i]-=askiiLettersGap;
			}
			System.out.print(characters[i]+" ");	
		}

	}

}
