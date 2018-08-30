package simester1.word_assignment5;

import java.util.*;

public class WordAssignment5 {
	
	public static void main (String[] args){
		Scanner s = new Scanner(System.in);
		final int EXIT = 0;
		boolean ifContinue=true;
		int menu=0;
	
		do{
			System.out.println("\n~~~~~~~~~~~~~~~~~Main Menu~~~~~~~~~~~~~~~~~\n");
			System.out.println("Please choose from one of the following questions:");
			System.out.println("** 8  - Is the number a \"Changing Number\" (all neighbor digits pair/odd)");
			System.out.println("** 9  - Does a number has \"Changing Digits\" (one neighbor digits pair/odd)");
			System.out.println("** 10 - A modulo function ");
			System.out.println("** 11 - Reverse a string of letters");
			System.out.println("** 13 - Turn a number to base 2");
			System.out.println("** 16 - Turn a number from base 16 to base 10");
			System.out.println("** 18 - Number of times a character appers in an array of strings ");
			System.out.println("** 20 - A wierd series of numbers ");
			System.out.println("** 22 - The amazing ruler ");
			menu = s.nextInt();
			
			switch(menu){
				case 8:{
					int number;
					System.out.println("Please enter a number");
					number = s.nextInt();
					if(changingDigits(number)){
						System.out.println("The number is a \"Changing Digits\" number");
					}
					else{
						System.out.println("Sorry, the number is not a \" Changing Digits\" number");
					}
				}
				case 9:{
					int number;
					System.out.println("Please enter a number");
					number = s.nextInt();
					if(isPairDigitschangingDigits(number)){
						System.out.println("The number is a \"Changing Digits\" number");
					}
					else{
						System.out.println("Sorry, the number is not a \" Changing Digits\" number");
					}
					break;
				}
				case 10:{
					int numerator,denominator;
					
					System.out.println("Please enter a numerator: ");
					numerator = s.nextInt();
					System.out.println("Please enter a denominator: ");
					denominator = s.nextInt();
					
					System.out.println("The quotient is: ");
					System.out.println(modulo(numerator, denominator));
					break;
				}
				case 11:{
					System.out.println("Please enter a string of letters:");
					StringBuilder str = new StringBuilder(s.next());
					System.out.println("your new String is :\n" + switchLetters(str, 0, str.length()));
					break;
					
				}
				case 13:{
					int number;
					System.out.println("Please enter a base 10 number:");
					number = s.nextInt();
					System.out.println("The number you entered after transformation to base 2: \n" + turnToBase2(number));
				}
				case 16:{
					String str;
					System.out.println("Please enter a base 16 number:");
					str = s.next();
					System.out.println("The number you entered after transformation to base 10: \n" + turnToBase10From16(str));
					break;
				}
				case 18:{
					int size;
					char cha;
					System.out.println("What is the size of the array of string you wish to creat? ");
					size = s.nextInt();
					String[] str = new String[size];
					
					System.out.println("Please enter the array of strings");
					for (int i=0 ; i<str.length ; i++){
						str[i] = s.next();
					}
					System.out.println("Please enter the character you would like to count in the arry of strings: ");	
					cha = s.next().charAt(0);
					System.out.println("your character appears " + sumOfCharInStringArray(str, str.length, cha) + " times");
					break;
				}
				case 20:{
					int number;
					System.out.println("Please enter the number in the Series you would like to get his value:");
					number = s.nextInt();
					System.out.println("The value of the number you entered is: " + numberSeries(number));
					break;
				}
				case 22:{
					int number;
					System.out.println("please enter a number");
					number = s.nextInt();
					ruler(number);
					break;
				}
				case EXIT:{
					System.out.println("Good-bye");
					ifContinue = false;
					break;
				}
				default:{
					System.out.println("We are sorry, we don't have that question, please try again.");
					break;
				}
			}
		}while(ifContinue);
		s.close();
	}
	public static boolean changingDigits (int number){
		int temp1,temp2;
		temp1 = number%10;
		number = number/10;
		temp2 = number%10;
		
		if(number/10==0){
			if(temp1%2!=temp2%2){
				return true;
			}
			return false;
		}
		if (changingDigits(number)&&(temp1%2!=temp2%2)){
			return true;
		}
		return false;
	}
	public static boolean isPairDigitschangingDigits (int number){
		int temp1,temp2;
		temp1 = number%10;
		number = number/10;
		temp2 = number%10;
		
		if(number/10==0){
			if(temp1%2!=temp2%2){
				return true;
			}
			return false;
		}
		if (changingDigits(number)||(temp1%2!=temp2%2)){
			return true;
		}
		return false;
	}
	public static int modulo (int numerator,int denominator){
		if(numerator<denominator){
			return numerator;
		}
		numerator = numerator-denominator;
		return modulo(numerator, denominator);
	}
	public static StringBuilder switchLetters (StringBuilder str, int indexBegin, int indexEnd){
		if(indexBegin>=indexEnd){
			return str;
		}
		char charBegin = str.charAt(indexBegin);
		char charEnd = str.charAt(indexEnd-1);		
		str.setCharAt(indexBegin, charEnd);
		str.setCharAt(indexEnd-1, charBegin);		
		return switchLetters(str, indexBegin+1, indexEnd-1);
	}
	public static int turnToBase2 (int number){
		final int BASE_2 = 2;
		if(number==0){
			return 0;
		}
		int temp = number%BASE_2;
		number = number/BASE_2;
		
		return temp+10*turnToBase2(number);
	}
	public static int turnToBase10From16 (String str){
		final int ASCII_NUMBERS = 48, ASCII_SMALL=97, ASCII_CAPITAL = 65, BASE_16 = 16;
		int temp = str.charAt(0);
		int answer=0;
		System.out.println(str);
		if(temp<ASCII_CAPITAL){
			answer = (temp-ASCII_NUMBERS)*(int)Math.pow(BASE_16, str.length()-1);
		}
		if(temp<ASCII_SMALL&&ASCII_CAPITAL<=temp){
			answer = (temp-ASCII_CAPITAL+10)*(int)Math.pow(BASE_16, str.length()-1);
		}
		if(temp>=ASCII_SMALL){
			answer = (temp-ASCII_SMALL+10)* (int)Math.pow(BASE_16, str.length()-1);
		}
		if(str.length()-1==0){
			return answer;	
		}
		return answer+turnToBase10From16(str.substring(1, str.length()));
	}
	public static int sumOfCharInStringArray (String[] str, int strLength,char cha){
		if(strLength-1==0){
			return numOfCharInString(str[strLength-1], cha);
		}
		return numOfCharInString(str[strLength-1], cha) + sumOfCharInStringArray(str, strLength-1, cha);
		
	}	
	public static int numOfCharInString (String str, char cha){
		char temp = str.charAt(0);
		if(str.length()-1==0){
			if (cha == temp){
				return 1;
			}
			return 0;	
		}
		if(cha == temp){
			return 1+numOfCharInString(str.substring(1, str.length()), cha);			
		}
		else{
			return 0+numOfCharInString(str.substring(1, str.length()), cha);
		}
		
	}
	public static int numberSeries (int number){
		final int NUM_1 = 1, NUM_2 = 2, NUM_3 = 3;
		switch(number){
			case 1:{
				return NUM_1;
			}
			case 2:{
				return NUM_2;
			}
			case 3:{
				return NUM_3;
			}
			case 4:{
				return (NUM_1+NUM_2 + NUM_3);
			}
			case 5:{
				return (numberSeries(number-1)-NUM_2); 
			}
			default :{
				break;
			}
		}		
		if(number%2==0){
			return (numberSeries(number-1)+numberSeries(number-2)+numberSeries(number-3));  
		}
		return numberSeries(number-1) - numberSeries(number-3);
	}
	public static void ruler (int number){
		if(number==1){
			drawLine(number);
			return;
		}		
		ruler(number-1);
		drawLine(number);
		ruler(number-1);		
	}
	public static void drawLine (int number){
		if(number==0){
			System.out.println("");
			return;
		}
		 drawLine(number-1);
		 System.out.print("-");
	}
}
