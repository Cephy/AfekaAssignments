package simester1.practice_makes_perfect.practice_makes_perfect.Tests.Tests.Moed_A_2016;

public class Child {
	private String name;
	private int age;
	
	public Child (String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public String toString() {
		return name + " " + age;
	}
	
	public boolean isEqual (Child child){
		if (child.name.equals(name)){
			return true;
		}
		return false;
	}
}