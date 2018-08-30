package simester1.word_assignment2;

import java.util.*;

public class Ch4_q5 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num, temp, FinalNumber=0, power=1, digit1, digit2;
	
		System.out.println("please entere a number you wish to transport");
		temp = num = s.nextInt();
		
		while (temp!=0){
			digit1 = temp%10;
			temp/=10;
			digit2 = temp%10;
			temp/=10;
			if (!(temp==0 && digit2==0)){
				FinalNumber += digit2*power;
				power *= 10;
				FinalNumber += digit1*power;
				power *=10;
			}
			else 
				FinalNumber += digit1*power;
		}		
	System.out.println("your old number was "+num+" your number is "+FinalNumber);
	}

}
