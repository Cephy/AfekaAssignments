package simester2.practive.worksheet1_Q1;

import java.util.*;

public class main_q1 {

	public static void main (String[] args){
		Scanner s = new Scanner(System.in);
		String name;
		int id, grade;
		
		System.out.println("Please enter the name of the student ");
		name = s.next();
		System.out.println("Please enter the I.D of the student ");
		id = s.nextInt();
		System.out.println("Please enter the grade of the student ");
		grade = s.nextInt();
		
		Student stu = new Student (name, id, grade); 
		
		System.out.println(stu.toString());
		
		s.close();
	}
}
