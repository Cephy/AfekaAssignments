package simester2.practive.worksheet1_Q3_and_Q4;

import java.util.*;

public class Main_q4 {

	public static void main (String[] args){
		
		Scanner s = new Scanner(System.in);
		
		int radius;
		String colorTmp;
		float xTmp,yTmp;
		
		System.out.println("Please enter the location of the point: ");
		xTmp = s.nextFloat();
		yTmp = s.nextFloat();
		System.out.println("Please enter the color of the point: ");
		colorTmp = s.next();
		
		ColorPoint cp1 = new ColorPoint(xTmp,yTmp,colorTmp);
		
		System.out.println("Please enter the location of the 2ed point: ");
		xTmp = s.nextFloat();
		yTmp = s.nextFloat();
		System.out.println("Please enter the color of the point 2ed point: ");
		colorTmp = s.next();
		
		ColorPoint cp2 = new ColorPoint(xTmp,yTmp,colorTmp);
				
		System.out.println("Please enter the circle's center point: ");
		xTmp = s.nextFloat();
		yTmp = s.nextFloat();
		System.out.println ("Please enter the raduis of the circle: ");
		radius = s.nextInt();
		
		Circle circle = new Circle(xTmp,yTmp,radius);
		
		if (cp1.equals(cp2)){
			System.out.println("the points are equal");
		}
		else System.out.println("the points are not equal");
		
		if (circle.equals(cp2)){
			System.out.println("the points are equal");
		}
		else System.out.println("the points are not equal");
		
		s.close();
		 
	}
}
