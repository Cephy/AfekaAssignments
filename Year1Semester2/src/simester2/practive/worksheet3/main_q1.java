package simester2.practive.worksheet3;

import java.util.*;

public class main_q1 {
	
	public static void main (String[] args){
		Scanner s = new Scanner(System.in);
		
		int grade=0;
		String name=null;
		boolean flag = false;
		Student stu = null;
		
		do{		
			try{
				System.out.println("Please enter the student's name: ");
				name = s.next();
				System.out.println("Please enter the grade of the student: ");
				grade = s.nextInt();
				flag = false;
				stu = new Student(name, grade);
			}		
			catch(InputMismatchException InputMismatchException){
				System.out.println("You have entered the wrong char please renter the grade and the name of the student\n");
				s.next();
				flag = true;
			}
			catch(IllegalArgumentException IllegalArgumentException) {
				System.out.println("Please enter a grade from 0-100: \n");
				flag = true;
			}
		}while (flag);		
		System.out.println(stu);
		s.close();
	}
	
}
