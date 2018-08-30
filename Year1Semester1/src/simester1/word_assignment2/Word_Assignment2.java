package simester1.word_assignment2;

import java.util.*;

public class Word_Assignment2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int question;
		boolean ifcontinue=true;

		do {
			System.out.println("please enter the number of the question you wish to see, "
							   + "or press 0 to exit the programme: ");
			question = s.nextInt();
			
			switch (question){
			case 5:{
				System.out.println("----question 5----\n");
				int num, temp, FinalNumber=0, power=1, digit1, digit2;
				
				System.out.println("please enter a number you wish to transport");
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
				System.out.println("\n---end of programme --- \n");
				break;
			}
			case 8:{
				System.out.println("----question 8----\n");
				final int DIGIT_BAR = 9;
				int num1, num2, digit=0, DigitQuantity=0, NewNumber=0, power=1, DigitCounter=0;
				
				
				System.out.println("Please enter 2 numbers with the same number of digits: ");
				num1 = s.nextInt();
				num2 = s.nextInt();
				
				System.out.println("your new number is: ");
				for (int i=num1 ; i!=0 ; i/=10, num2/=10){
					DigitQuantity=i%10;
					digit=num2%10;
					for (int j=0 ; j<DigitQuantity ; j++){
						NewNumber+=digit*power;
						power*=10;
						DigitCounter++;
						if (DigitCounter==DIGIT_BAR){
							break;
						}
					}
					if (DigitCounter==DIGIT_BAR){
						break;
					}
				}
				System.out.println(NewNumber);			
				System.out.println("\n---end of programme --- \n");
				break;
			}
			case 9:{
				System.out.println("----question 9----\n");
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
				System.out.println("\n---end of programme --- \n");
				break;
			}
			case 11:{
				System.out.println("----question 11----\n");
				int temp, counter=0;
				
				System.out.println("Please enter a number to creat a triangle");
				temp = s.nextInt();
				 
				for (int row=temp; row!=0 ;row--){
					for (int spaces=counter ; spaces!=0 ;spaces-- )
						System.out.print(" ");
					for (int lines=row ; lines!=0 ; lines--){
						System.out.print("* ");
					}
				System.out.println();
				counter++;
				}
				System.out.println("\n---end of programme --- \n");
				break;
			}
			case 12:{
				System.out.println("----question 12----\n");
				int num, counter=0;
				
				System.out.println("Please enter a number to creat a Hourglass ");
				num = s.nextInt();
				 
				for (int row=num; row!=0 ;row--){
					for (int spaces=counter ; spaces!=0 ;spaces-- )
						System.out.print(" ");
					for (int lines=row ; lines!=0 ; lines--){
						System.out.print("* ");
					}
				System.out.println();
				counter++;
				}
				for (int row=0 ; row!=num ; row++){
					for (int spaces=1 ; spaces<counter ;spaces++ )
						System.out.print(" ");
					for (int lines=0 ; lines<=row ; lines++){
						System.out.print("* ");
					}
				System.out.println();
				counter--;
				}
				System.out.println("\n---end of programme --- \n");
				break;
			}
			case 13:{
				System.out.println("----question 13----\n");
				int num;
				
				System.out.println("please enter a number to determine the size of the rug ");
				num = s.nextInt();
				
				for (int LineOuter = num ; LineOuter!=0 ; LineOuter-- ){
					for (int RowOuter = num ; RowOuter!=0 ; RowOuter--){
						for (int LineInner = num ; LineInner!=0 ; LineInner--){
							for (int RowInner = num ; RowInner!=0 ; RowInner-- ){
								System.out.print("*");
							}	
							System.out.print(" ");
						}
						System.out.println("");
					}
					System.out.println("");	
				}
				System.out.println("\n---end of programme --- \n");
				break;
			}
			case 14:{
				System.out.println("----question 14----\n");
				final int TriangleQuantity=3;
				int num;
			
				System.out.println("please enter an odd number ");
				num = s.nextInt();
				
				for (int triangle=TriangleQuantity ; triangle!=0 ; triangle--){
					for (int Line=0 ; Line<=num ; Line++){
						for (int spaces=num-Line ; spaces!=0 ; spaces--){
							System.out.print(" ");
						}
						for (int row=Line ; row!=0 ; row--){
							System.out.print("* ");
						}
						if (num!=Line){
							System.out.println("");
						}
					}
				}
				System.out.println("");
				for (int line=num ; line!=0 ; line--){
					for (int spaces=num-1 ; spaces!=0 ; spaces--){
						System.out.print(" ");
					}
				System.out.println("*");
				}
				System.out.println("\n---end of programme --- \n");
				break;
			}
			case 15:{
				System.out.println("----question 15----\n");
				final int INITIAL_VALUE=10, SQUENCE_BREAK_POINT = 3;
				int temp=0, digit=0,sum=0, counter, SequenceBreakCounter=0, NumberCounter=0;
				
				temp=counter=INITIAL_VALUE; 
				do{
					temp=counter;
					while (temp>9){
						sum=0;
						while (temp!=0){
							digit = temp%10; 
							sum += digit*digit;
							temp/=10;
						}
						temp = sum;
					}
					if (temp==1){
						NumberCounter++;
						SequenceBreakCounter++;
						System.out.printf("%d) %d is happy a number ;-)\n",NumberCounter ,counter);
					}
					else{
						SequenceBreakCounter=0;
					}
					counter++;
					} while(SequenceBreakCounter!=SQUENCE_BREAK_POINT);
				System.out.println(counter +" "+ (counter-1) +" "+ (counter-2));
				System.out.println("\n---end of programme --- \n");
				break;
			}
			case 0:
				System.out.println("byebye");
				ifcontinue=false;
				break;
			default:{
				System.out.println("We are sorry, we do not have that question in our data base.");
				break;
			}
			}
			
			
		}while (ifcontinue!=false);
	}
}
