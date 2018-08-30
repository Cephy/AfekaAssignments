package simester1.practice_makes_perfect.practice_makes_perfect.Tests.Tests.Moed_A_2016;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Worker {
	private String name;		
	private int salary;
	private Child[] allChildren;
	private int numOfChildren=0;
	
	public Worker (String name, int salary)throws FileNotFoundException{
		this.name = name;
		this.salary = salary;
		
		File f = new File (name+".txt");
		if(f.exists()){
			Scanner s = new Scanner(f);
			int numOfChildrenTemp = s.nextInt();
			allChildren = new Child[numOfChildrenTemp]; 
			while(s.hasNext()){
				for (int i=0 ; i<numOfChildrenTemp ; i++){
					String childName = s.next();
					int age = s.nextInt();
					Child childTemp = new Child(childName, age);
					if(!isChildExistsAlready(childTemp)){
						allChildren[numOfChildren++] = childTemp;
					}
				}
			}
			s.close();
		}		
	}
	
	public String toString() { 
		String strChildren = "";
		for (int i = 0; i < numOfChildren; i++)
			strChildren += "( " + allChildren[i].toString() + " " + " )";
		return name + " " + salary + " " + strChildren;
	}
	
	public boolean isChildExistsAlready (Child child){
		for(int i=0 ; i<allChildren.length ; i++){
			if(child.isEqual(allChildren[i])){
				return true; 
			}
		}
		return false;
	}
}
