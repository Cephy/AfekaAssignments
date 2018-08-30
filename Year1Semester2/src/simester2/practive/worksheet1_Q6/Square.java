package simester2.practive.worksheet1_Q6;

public class Square {

	private int length;
	
	public Square (int length){
		this.length = length;
	}
	
	public void setLength (int length){
		this.length = length;
	}
	
	public int getLength (){
		return length;
	}
	
	@Override
	public String toString (){
		return length +"X"+ length;
	}
}
