package simester1.word_assignment2;

import java.util.*;

public class Ch4_q9 {

	public static void main(String[] args) {
		Scanner s = new Scanner (System.in);
		int num=0, NewNumber=0, PartitionSize, PartitionPower=1, InnerPartition=0;
		
		System.out.println("please enter a number and a digit ");
		num = s.nextInt();
		PartitionSize = s.nextInt();
 		while (num!=0){
 			InnerPartition=0;
 			for (int i=PartitionSize ; i!=0 ; i--, num/=10 ){ 				//Partition inner loop
				if (num!=0){
					InnerPartition*=10;
				}
				InnerPartition+=num%10;
	 		}
 			InnerPartition*=PartitionPower;
 			for (int p=PartitionSize ; p!=0 ; p--){ 						//Partition power 
	 			PartitionPower *=10;
 			}
			NewNumber+=InnerPartition;	
		}
 		System.out.printf("your new number is %d" ,NewNumber);
	}
}
