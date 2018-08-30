package simester2.practive.worksheet1_Q6;

import java.util.*;

public class Main_Q6 {

	public static void main (String[] args){
		
		Scanner s = new Scanner (System.in);
			
		ArrayList<Object> arrayList = new ArrayList<Object>();
		
		Square squ1 = new Square (10);
		Square squ2 = new Square (5);
		
		Student stu1 = new Student (95, "dor");
		Student stu2 = new Student (85, "sefi");
		
		arrayList.add(squ1);
		arrayList.add(squ2);
		arrayList.add(stu1);
		arrayList.add(stu2);
		
		for (int i=0 ; i<arrayList.size() ; i++){
			System.out.println(arrayList.get(i));
		}
						
		s.close();
	}	
	
}
