package simester1.word_assignment3_final;

import java.util.*;

public class Word_assignment3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String ch5 = "Chapter 5 - Array and Matrices",
			   ch6 = "chapter 6 - Functions",
			   ch5Q6 = "Chapter 5 Question 6 - Change small letters to Capital letters ",
			   ch5Q7 = "Chapter 5 Question 7 - Finding mate numbers ",
			   ch5Q9 = "Chapter 5 Question 9 - Mirror array ",
			   ch5Q12 = "Chapter 5 Question 12 - Print array and check for max value",
			   ch5Q13 = "Chapter 5 Question 13 - Show 4 numbers in  columns using asterisks",
			   ch5Q14 = "Chapter 5 Question 14 - Snake array",
			   ch5Q19 = "Chapter 5 Question 19 - Long Multiplication function",
			   ch6Q1 = "Chapter 6 Question 1 - Add 1 to each digit function",
			   ch6Q3 = "Chapter 6 Question 3 - Count number of times sum of digits is 10",
			   ch6Q7 = "Chapter 6 Question 7 - Addition function",
			   exitQuestion = "Press 0 to go back to chapter selection";
		int chapter, question;
		boolean ifContinueQuestion=true,ifContinueMainMenu=true;
		
		do{
			ifContinueQuestion=true;
			System.out.printf("\n\n----------------Chapter selection----------------\n\n");
			System.out.printf("Please enter the number of the chapter you wish to see or press 0 to exit programme: \n%s\n%s\n",ch5,ch6);
			chapter = s.nextInt();
			
			if ((chapter!=5)&&(chapter!=6)&&(chapter!=0)){
				System.out.println("In this Project there are only questions from chapter "
						+ "5 and 6 please choose from one of them");
			}
			while((chapter==5)&&(ifContinueQuestion==true)){
				System.out.printf("\n\n----------------Question selection chapter 5----------------\n\n");
				System.out.printf("Please enter the number of the question you wish to see:\n\n"
								 + "%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n\n" ,ch5Q6,ch5Q7,ch5Q9,ch5Q12,ch5Q13,ch5Q14,ch5Q19,exitQuestion);
				question = s.nextInt();
				
				switch (question){				
				
					case 6:{
						System.out.println("--------------Question 6--------------");
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
						break;
					}
					case 7:{
						System.out.println("--------------Question 7--------------");
						int[][] mateNumbers = new int[10][2];
						int numCounter=219, secondMateNum=0, firstMateNumFlag=0, nextNumFlag=0; 
						
						for(int i=0 ; i<mateNumbers.length ; i++){
							boolean mateNumbersFlag = true;
							while(mateNumbersFlag==true){	
								numCounter++;
								if (numCounter==nextNumFlag){
									continue;
								}
								secondMateNum=0;
								for (int j=numCounter-1 ; j!=0 ; j--){
									if(numCounter%j==0){
										secondMateNum+=j;
									}	
								}	
								firstMateNumFlag=0;
								for (int j=secondMateNum-1 ;j!=0 ; j--){
									if(secondMateNum%j==0){
										firstMateNumFlag+=j;
									}
								}
								if((firstMateNumFlag==numCounter)&&(numCounter!=secondMateNum)){
									mateNumbers[i][0]=numCounter;
									nextNumFlag=mateNumbers[i][1]=secondMateNum;
									System.out.printf("%d) %d and %d are mates \n",i+1,mateNumbers[i][0],mateNumbers[i][1]);
									mateNumbersFlag=false;
								}
							}		
						}
						break;
					}
					case 9:{
						System.out.println("--------------Question 9--------------");
						int[] numbers = new int[6];
						boolean mirrorFlag = true;

						System.out.printf("please enter %d numbers \n",numbers.length);
						for (int i=0 ; i<numbers.length ; i++){
							numbers[i] = s.nextInt();
						}
						for (int i=0, j=numbers.length-1 ; i<j ; i++, j--){
							int swapedNumber=0; 
							for (int swap=numbers[i] ; swap!=0 ; swap/=10){
								swapedNumber*=10;
								swapedNumber+=swap%10;
							}
							if (swapedNumber!=numbers[j]){
								mirrorFlag = false;
								System.out.println("The array you have entered is not miror \n");
								break;
							}
						}		 
						if(mirrorFlag==true){
							System.out.println("The array you have entered is a miror \n");
						}
						break;
					}
					case 12:{
						System.out.println("--------------Question 12--------------");
						final int upperBar=10, lowerBar=1;
						int rows, columns, maxValue=0;
						int[][] numbers = new int[10][10];
						
						System.out.println("Please enter the number of rows you would like your table to have "
								  + "\nthe number sould be from 1 to 10 ");
						do{																				//number of rows
						rows = s.nextInt();
							if((rows>upperBar)||(rows<lowerBar)){
								System.out.println("You have entered a wrong number. Please enter a number from 1 to 10:");
							}
						}while((rows>upperBar)||(rows<lowerBar));
						
						System.out.println("Please enter the number of columns you would like your table to have "
								  + "\nthe number sould be from 1 to 10 ");
						do{ 																			//number of columns
						columns = s.nextInt();
							if((columns>upperBar)||(columns<lowerBar)){
								System.out.println("You have entered a wrong number. Please enter a number from 1 to 10:");
							}
						}while((columns>upperBar)||(columns<lowerBar));
						
						System.out.printf("Please enter %d numbers \n",columns*rows);					//enter numbers to the array
						for(int rowsCells=0 ;rowsCells<rows ;rowsCells++){
							for (int columnsCells=0 ; columnsCells<columns ; columnsCells++){
								numbers[rowsCells][columnsCells] = s.nextInt();
								if (numbers[rowsCells][columnsCells]>maxValue){
									maxValue=numbers[rowsCells][columnsCells];
								}
							}
						}
						for(int rowsCells=0 ;rowsCells<rows ;rowsCells++){
							for (int columnsCells=0 ; columnsCells<columns ; columnsCells++){
								System.out.print(numbers[rowsCells][columnsCells]+"\t");
							}
							System.out.println();
						}
						System.out.printf("The highest number in the table is %d \n", maxValue);
						break;
					}
					case 13:{
						System.out.println("--------------Question 13--------------");
						int[] numbers = new int [4];
						int maxValue=0;
						
						System.out.printf("please enter %d numbers \n",numbers.length);
						for(int i=0 ; i<numbers.length ; i++){
							numbers[i]=s.nextInt();
							if (numbers[i]>maxValue){
								maxValue=numbers[i];
							}
						}
						for(int rows=maxValue ; rows!=0 ; rows--){
							
							for(int columns=0 ; columns<numbers.length ; columns++){
								if (rows<=numbers[columns]){
									System.out.print("* ");
								}
								else{
									System.out.print("  ");
								}
							}
							System.out.println();
						}
						System.out.println("-------");
						for (int n: numbers){
							System.out.print(n + " ");
						}
						break;
					}
					case 14:{
						System.out.println("--------------Question 14--------------");
						int size = (int)((Math.random()*4)+5), counter=0;
						int[][] numbers = new int[size][size];  
						
						for (int rows=numbers[0].length-1 ; rows>=0 ; rows--){
							int operatorSign,columnsFlag, columns;
							
							if (rows%2==1){
								columns=0;
								operatorSign=1;
								columnsFlag=numbers.length;
							}
							else{
								columns=numbers.length-1;
								operatorSign=-1;
								columnsFlag=-1;
							}
							for( ; columns!=columnsFlag ; columns+=operatorSign){
								counter++;
								numbers[columns][rows] = counter;  
							}
						}
						for (int rows=0 ; rows<numbers.length ; rows++){
							for (int columns=0 ; columns<numbers[0].length ; columns++){
								System.out.print(numbers[rows][columns]+"\t");	
							}
						System.out.println();
						}
						break;
					}
					case 19:{
						System.out.println("--------------Question 19--------------");
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
						
						int[] result = multiplyNumbers(num1,num2);
						
						for (int i=0 ; i<result.length ; i++){
							System.out.print(result[i]);
						}
						break;
						
					}
					case 0:{
						System.out.println("You will now be redirected to the main menu\n");
						ifContinueQuestion = false;
						break;
					}
					default:{
						System.out.println("We are sorry, we do not have that question in our data base.");
						break;
					}
				}
			};
			while((chapter==6)&&(ifContinueQuestion==true)){
				System.out.printf("\n\n----------------Question selection chapter 6----------------\n\n");
				System.out.printf("Please enter the number of the question you wish to see:\n\n"
								 + "%s\n%s\n%s\n%s\n\n" ,ch6Q1,ch6Q3,ch6Q7,exitQuestion);
				question = s.nextInt();
				switch (question){				
				
				case 1:{
					System.out.println("--------------Question 1--------------");
					int number, newNumber;
					
					System.out.println("Please enter a number you wish to transform ");
					number = s.nextInt();

					newNumber = digitPlus1(number);
					
					System.out.printf("your new number is: %d", newNumber);
					break;
				}
				case 3:{
					System.out.println("--------------Question 3--------------");
					int arrayLength, sumOf10;
					
					System.out.println("please enter the number of cells you wish your array will have");
					arrayLength = s.nextInt();
					
					int[] numbers = new int[arrayLength];
					System.out.println("Please enter numbers according to the number of cells you have chosen");
					for(int i=0 ; i<numbers.length ; i++){
						numbers[i] = s.nextInt();
					}
					sumOf10 = ifSum10(numbers);
					System.out.printf("the amount of times the sum of the digits of your numbers  was 10 is %d", sumOf10);
					break;
				}
				case 7:{
					System.out.println("--------------Question 7--------------");
					int digits1, digits2;
					
					System.out.println("please enter the number of digits in your number and then the number "
									  + "itself one digit at a time");
					digits1 = s.nextInt();
					int[] num1 = new int[digits1];
					for (int i=num1.length-1 ; i>=0 ; i--){
						num1[i] = s.nextInt();
					}
					System.out.println("please enter the second number of digits in your second number "
									  + "and then the number itself one digit at a time");
					digits2 = s.nextInt();
					int[] num2 = new int[digits2];
					for (int i=num2.length-1 ; i>=0 ; i--){
						num2[i] = s.nextInt();
					}
					
					int[] result = add(num1,num2);
					
					for (int i=0 ; i<result.length ; i++){
						System.out.print(result[i]);
					}
					break;
				}
				case 0:{
					System.out.println("You will now be redirected to the main menu\n");
					ifContinueQuestion = false;
					break;
				}
				default:{
					System.out.println("We are sorry, we do not have that question in our data base.");
					break;
				}
				}
			}
			
		}while(chapter!=0);
		System.out.println("Bye bye");
	}
	public static int[] multiplyNumbers (int[] num1, int[] num2){ 
		int digitStartLocation=0, digitLocation=0;
		int[] result = new int [(num1.length*num2.length)];
		
		for (int lowerNum=num2.length-1 ; lowerNum>=0 ; lowerNum-- ){
			digitLocation=0;
			for (int upperNum=num1.length-1 ; upperNum>=0 ; upperNum--){
				result[(result.length-1)-(digitStartLocation+digitLocation)] += (num1[upperNum]*num2[lowerNum])%10;
				result[(result.length-1)-(digitStartLocation+digitLocation+1)] += (num1[upperNum]*num2[lowerNum])/10;					
				if(result[(result.length-1)-(digitStartLocation+digitLocation)]>=10){
					result[(result.length-1)-(digitStartLocation+digitLocation+1)]++;
					result[(result.length-1)-(digitStartLocation+digitLocation)]%=10;
				}
				digitLocation++;
			}
			digitStartLocation++;
		}
		
		return result;
	}
	public static int ifSum10(int numbers[]){
		int counter=0;
		
		for(int i=0 ; i<numbers.length ; i++ ){
			if(sumOfDigits(numbers[i])==10){
				counter++;
			}
		}
		return counter;
	}
	public static int sumOfDigits(int number){
		int sumOfDigits=0;
		
		while(number!=0){
			sumOfDigits+=number%10;
			number/=10;
		}
		return sumOfDigits;
	}	
	public static int[] add (int[] num1, int[] num2){ 
		int digitLocationResult=0;
		int[] result = new int [(num1.length>=num2.length?num1.length:num2.length)];
		
		for (int digitLocationNumber=0 ; digitLocationNumber<(num1.length>=num2.length?num1.length:num2.length) ; digitLocationNumber++ ){
				result[(result.length-1)-digitLocationResult] += ((digitLocationNumber>=num1.length?0:num1[digitLocationNumber])+(digitLocationNumber>=num2.length?0:num2[digitLocationNumber]));					
				if(result[(result.length-1)-digitLocationResult]>=10){
					result[(result.length-1)-(digitLocationResult+1)]++;
					result[(result.length-1)-digitLocationResult]-=10;
				}
				digitLocationResult++;
		}		
		return result;
	}
	public static int digitPlus1(int number){
		int power=1;
		
		for (int i=number ; i!=0 ; i/=10 ){
			number+=(1*power);
			power*=10;
		}
		return number;			
	}
}