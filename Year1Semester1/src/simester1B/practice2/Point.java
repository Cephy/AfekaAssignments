package simester1B.practice2;

public class Point <E extends Number>{
	private E x;
	private E y;
	
	public Point (E x, E y){
		this.x = x;
		this.y = y;
	}
	
	public E getX(){
		return x;
	}
	
	public void setX (E x){
		this.x = x;
	}
	
	public E getY(){
		return y;
	}
	
	public void setY (E y){
		this.y = y;
	}
	
	public String toString (){
		return "(" + x + "," + y + ")";
	}
	
}
