package simester2.practive.worksheet1_Q3_and_Q4;

public class Point {
	
	private float x; 
	private float y;
	
	public Point (float x, float y){
		this.y = y;
		this.x = x;
	}
	
	public void setX (float x){
		this.x=x;
	}
	
	public float getX (){
		return x;
	}
	
	public void setY (float y){
		this.y=y;
	}
	
	public float getY (){
		return y;
	}
	
	public String toString (){
		return "(" + y + "," + x + ")";
	}
	
	public boolean equals (Object obj){
		if (this.getClass().equals(obj.getClass())){
			Point p1 = (Point) obj;
			return p1.getX() == this.x && p1.getY() == this.y;
		}
		return false; 
	}
}
