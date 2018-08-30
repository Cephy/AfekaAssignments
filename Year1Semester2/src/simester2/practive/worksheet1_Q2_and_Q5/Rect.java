package simester2.practive.worksheet1_Q2_and_Q5;

public class Rect {
	
	private int width;
	private int length;
	
	/*public Rect (int width, int length){
		this.width = width;
		this.length = height;
	}*/
	
	public void setWidth (int width){
		this.width = width;
	}
	
	public int getWidth (){
		return width;
	}
	
	public void setLength (int length){
		this.length = length;
	}
	
	/*public int getLength (){
		return length;
	}*/
	
	public String toString (){
		return "width: " + width + "Length: " + length;
	}
	
	public int area (){
		return width*length;
	}
	
}
