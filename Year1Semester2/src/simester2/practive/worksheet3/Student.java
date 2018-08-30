package simester2.practive.worksheet3;

public class Student {
	
	private int grade;
	private String name;
	private final int MIN_GRADE = 0;
	private final int MAX_GRADE = 100;
	
	public Student (String name, int grade)throws IllegalArgumentException{
		if(grade>MAX_GRADE || grade<MIN_GRADE){
			throw new IllegalArgumentException();
		}
		this.grade = grade;
		this.name = name;
	}
	
	public  void setGrade (int grade){
		if(grade>MAX_GRADE || grade<MIN_GRADE){
			throw new IllegalArgumentException();
		}
		this.grade = grade;
	}
	
	public int getGrade (){
		return grade;
	}
	
	public void setName (String name){
		this.name = name;
	}
	
	public String getString (){
		return name;
	}
	
	@Override
	public String toString (){
		return name + ": " + grade ;
	}

}
