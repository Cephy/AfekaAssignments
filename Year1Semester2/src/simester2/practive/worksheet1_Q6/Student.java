package simester2.practive.worksheet1_Q6;

public class Student {
	
	private int grade;
	private String name;
	
	public Student (int grade, String name){
		this.grade = grade;
		this.name = name;
	}
	
	public String getName (){
		return name;
	}
	
	public void setName (String name){
		this.name = name;
	}
	
	public int getGrade (){
		return grade;
	}
	
	public void setGrade (int grade){
		this.grade = grade;
	}
	
	@Override
	public String toString (){
		return name + ": " + grade;
	}
}
