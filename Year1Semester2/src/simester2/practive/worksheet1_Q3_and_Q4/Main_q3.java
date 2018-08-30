package simester2.practive.worksheet1_Q3_and_Q4;

import java.util.*;

public class Main_q3 {

	public static void main (String[] args){
		Scanner s = new Scanner (System.in);
		
		int radius;
		float x,y;
		
		System.out.println("Please enter the circle's center point: ");
		x = s.nextFloat();
		y = s.nextFloat();
		System.out.println ("Please enter the raduis of the circle: ");
		radius = s.nextInt();
		
		Circle circle = new Circle(x,y,radius);
		
		System.out.println(circle);
		System.out.println("The area of the circle is: " + circle.area());
		
		System.out.println("Please enter the circle's new center point: ");
		circle.setX(s.nextFloat());
		circle.setY(s.nextFloat());
		System.out.println ("Please enter the new circle's raduis: ");
		circle.setRadius(s.nextInt());
		
		System.out.println(circle);
		System.out.println("The new area of the new circle is: " + circle.area());
		
		s.close();
	}
}
