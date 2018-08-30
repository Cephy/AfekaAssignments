package simester1.word_assignment4_workspace;

import java.util.*;

public class Ch7_q5 {

	public static void main (String[] args){
		Scanner s = new Scanner(System.in);
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
		s.close();
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
