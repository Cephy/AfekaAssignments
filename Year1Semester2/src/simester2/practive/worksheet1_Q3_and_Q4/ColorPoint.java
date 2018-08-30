package simester2.practive.worksheet1_Q3_and_Q4;

public class ColorPoint extends Point{
	
	private String pointColor;
	
	public ColorPoint (float x, float y, String pointColor){
		super(x,y);
		this.pointColor = pointColor;
	}
	
	public String getPointColor (){
		return pointColor;
	}
	
	public void setPointColor (String pointColor){
		this.pointColor = pointColor;
	}
	
	@Override
	public String toString (){
		return super.toString() + "Point color: " + pointColor;
	}
	@Override
	public boolean equals (Object obj){
		if(this.getClass().equals(obj.getClass())){
			ColorPoint cp = (ColorPoint)obj;
			return this.pointColor.equals(cp.getPointColor()) && super.equals(cp);
		}
		return false;
	}
}

