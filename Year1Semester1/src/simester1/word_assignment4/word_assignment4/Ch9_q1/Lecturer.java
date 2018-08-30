package simester1.word_assignment4.word_assignment4.Ch9_q1;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Lecturer {

	private String name;
	private int numOfPenFalls;
	private String favoriteIceCream;
	private int id;
	public static int idCounter=1000;
	
	public Lecturer (Scanner s)throws FileNotFoundException{
		name = s.next();
		numOfPenFalls = s.nextInt();
		favoriteIceCream = s.next();
		id = s.nextInt();
		idCounter++;
	}
	public Lecturer (String name, int numOfPenFalls, String favoriteIceCream){
		this.name = name;
		this.numOfPenFalls = numOfPenFalls;
		this.favoriteIceCream = favoriteIceCream;
		id = ++idCounter;
	}

	public void setName (String name){
		this.name = name;
	}
	
	public String getName (){
		return name;
	}
	
	public void setNumOfPenFalls (int NumOfPenFalls){
		this.numOfPenFalls=NumOfPenFalls;
	}
	
	public int getNumOfPenFalls (){
		return numOfPenFalls;
	}	
	
	public void setFavoriteIceCream(String favoriteIceCream){
		this.favoriteIceCream = favoriteIceCream;
	}
	
	public String getFavoritIceCream (){
		return favoriteIceCream;
	}
	
	public int getId (){
		return id;
	}
	public void save (PrintWriter pw)throws FileNotFoundException{
		pw.println(name);
		pw.println(numOfPenFalls);
		pw.println(favoriteIceCream);
		pw.println(id);
	}
	public String toString (){			
		return "name:" + name + "number of pen falls:" + numOfPenFalls + "favorite Ice Cream" + favoriteIceCream + "ID:" + id;
	}

}
