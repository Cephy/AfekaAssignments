package simester2.practive.worksheet1_Q1;

public class Student extends Person{
	
	private int grade;
	
	public Student (String name, int id, int grade){
		super(id,name);
		this.grade = grade;
	}
	
	public void setGrade (int grade){
		this.grade = grade;
	}
	
	public int getGrade (){
		return grade;
	}
	
	public String toString(){
		return super.toString() + " " + "grade: " + grade; 
	}
}
