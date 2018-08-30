package simester2.practive.worksheet1_Q3_and_Q4;

public class Circle extends Point{
	
	private int radius;
	
	public Circle (float x, float y, int radius){
		super (x,y);
		this.radius = radius;
	}
	
	public void setRadius (int radius){
		this.radius = radius;
	}
	
	public int getRadius (){
		return radius;
	}
	
	public String toString(){
		return "Radius: " + radius + " center location: " + super.toString();
	}
	
	public int area (){
		return (int)Math.PI*radius*radius;
	}
	
	
	
	
}
