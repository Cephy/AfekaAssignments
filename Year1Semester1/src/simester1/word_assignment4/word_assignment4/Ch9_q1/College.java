package simester1.word_assignment4.word_assignment4.Ch9_q1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class College {

	private int maxNumOfLecturers=2;
	private String name;
	private int numOfLecturer=0;
	private Lecturer[] lecturers;
	
	public College(){
		
	}
	
	public College (String name ,int maxNumOfLecturers){
		this.name = name;
		this.maxNumOfLecturers = maxNumOfLecturers;
		lecturers = new Lecturer[maxNumOfLecturers];
	}
	public College (String fileName)throws FileNotFoundException{
		File file = new File (fileName);
		Scanner s = new Scanner (file);
		name = s.nextLine();
		numOfLecturer = s.nextInt();
		maxNumOfLecturers = s.nextInt();
		lecturers = new Lecturer[maxNumOfLecturers];
		for (int i=0 ; i<numOfLecturer ; i++){
			lecturers[i] = new Lecturer(s);
		}
		s.close();
	}
	
	public void setMaxNumOfLecturers (int maxNumOfLecturers){
		this.maxNumOfLecturers = maxNumOfLecturers;
	}
	public int getMaxNumOfLecturers (){
		return maxNumOfLecturers;
	}
	public void setName (String name){
		this.name = name;
	}	
	public String getName (){
		return name;
	}
	public int getNumOfLecturer(){
		return numOfLecturer;
	}
	public Lecturer[] getLecturer(){
		return lecturers;
	}
	public void addLecturerer (String name,int numOfPenFalls,String favoriteIceCream){
			lecturers[numOfLecturer] = new Lecturer(name,numOfPenFalls,favoriteIceCream);
			numOfLecturer++;
	}	
	public boolean checkIfAddLecturerer(){
		if(numOfLecturer>=maxNumOfLecturers){
			return false;
		}
		else{
			return true;
		}
	}
	
	public void printLecturer(){
		System.out.printf("There are %d lecturers at %s\n\n", numOfLecturer, name);
		for(int i=0 ; i<numOfLecturer ; i++){
			System.out.printf("%s drops his pen %d times in avarage every lesson, his favorite ice cream is %s and his id number is %d\n",lecturers[i].getName(), lecturers[i].getNumOfPenFalls(),lecturers[i].getFavoritIceCream(),lecturers[i].getId());
		}
	}
	public void sortLecturerArray(){
		for (int limit = lecturers.length ; limit>lecturers.length ; limit--){
			for(int location=0 ; location<limit ; location++ ){
				if(lecturers[location].getNumOfPenFalls()>lecturers[location+1].getNumOfPenFalls()){
				swap(lecturers, location);	
				}
			}
		}
	}
	private void swap (Lecturer[] lecturers, int location){
		int temp = lecturers[location].getNumOfPenFalls();
		lecturers[location].setNumOfPenFalls(lecturers[location+1].getNumOfPenFalls());
		lecturers[location+1].setNumOfPenFalls(temp);		
	}
	public void save (File file)throws FileNotFoundException{
		PrintWriter pw = new PrintWriter(file);
		pw.println(name);
		pw.println(numOfLecturer);
		pw.println(maxNumOfLecturers);
		for (int i=0 ; i<numOfLecturer ; i++){
			lecturers[i].save(pw);	
		}		
		pw.close();
	}
}
