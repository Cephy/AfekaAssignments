package simester1.practice_makes_perfect.practice_makes_perfect.presentation9;

public class Person {
	
	private String name;
	private int hight;
	private int weight;
	
	public void setName (String name){
		this.name = name;
	}
	public String getName (){
		return name;
	}
	public void setHight(int hight){
		this.hight = hight;
	}
	public int getHight(){
		return hight;
	}
	public void setWeight(int weight){
		this.weight = weight;
	}
	public int getWeight(){
		return weight;
	}
	public void showPerson(){
		System.out.printf("%s is %d cm and weigh %d kg\n" ,name,hight,weight );
	}
}
