package simester1.word_assignment3_workspace1;

import java.util.Scanner;

public class Ch6_q7 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);		
		int digits1, digits2;
		
		System.out.println("please enter the number of digits in your number and then the number "
						  + "itself one digit at a time");
		digits1 = s.nextInt();
		int[] num1 = new int[digits1];
		for (int i=0 ; i<num1.length ; i++){
			num1[i] = s.nextInt();
		}
		System.out.println("please enter the second number of digits in your second number "
						  + "and then the number itself one digit at a time");
		digits2 = s.nextInt();
		int[] num2 = new int[digits2];
		for (int i=0 ; i<num2.length ; i++){
			num2[i] = s.nextInt();
		}
		
		int[] result = add(num1,num2);
		
		for (int i=0 ; i<result.length ; i++){
			System.out.print(result[i]);
		}
	}
	public static int[] add (int[] num1, int[] num2){ 
		int digitLocationResult=0;
		int[] result = new int [(num1.length+1)];
		
		for (int digitLocationNumber=num2.length-1 ; digitLocationNumber>=0 ; digitLocationNumber-- ){
				result[(result.length-1)-digitLocationResult] += (num1[digitLocationNumber]+num2[digitLocationNumber]);					
				if(result[(result.length-1)-digitLocationResult]>=10){
					result[(result.length-1)-(digitLocationResult+1)]++;
					result[(result.length-1)-digitLocationResult]-=10;
				}
				digitLocationResult++;
		}		
		return result;
	}

}
