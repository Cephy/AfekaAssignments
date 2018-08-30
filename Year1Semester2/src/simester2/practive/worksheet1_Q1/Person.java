package simester2.practive.worksheet1_Q1;

public class Person {
	
	private int id;
	private String name;
	
	public Person (int id, String name){
		this.id = id;
		this.name = name;
	}
	
	public String toString (){
		return "id: " + id + " name: " + name;
	}
	
	public void setName (String name){
		this.name = name;
	}
	
	public String getName (){
		return name;
	}
	
	public void setId (int id){
		this.id = id;
	}
	
	public int getId (){
		return id;
	}
}
