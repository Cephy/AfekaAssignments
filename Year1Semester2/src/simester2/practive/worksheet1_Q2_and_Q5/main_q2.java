package simester2.practive.worksheet1_Q2_and_Q5;

import java.util.*;

public class main_q2 {
	
	public static void main (String[] args){
		Scanner s = new Scanner(System.in);
		int length, width, heigth;
		
		System.out.println("Please enter the length of the box: ");
		length = s.nextInt();
		System.out.println("Please enter the width of the box: ");
		width = s.nextInt();
		System.out.println("Please enter the heigth of the box: ");
		heigth = s.nextInt();
		
		Box box = new Box(width, length, heigth);
		
		System.out.println("Please enter the length of the second box: ");
		length = s.nextInt();
		System.out.println("Please enter the width of the second box: ");
		width = s.nextInt();
		System.out.println("Please enter the heigth of the second box: ");
		heigth = s.nextInt();
		
		Box box2 = new Box(width, length, heigth);
		
		System.out.println("The first box details: ");
		System.out.println(box);
		
		System.out.println("The first Box area: ");
		System.out.println(box.area());
		
		System.out.println("The second box details: ");
		System.out.println(box2);
		
		System.out.println("The second Box area: ");
		System.out.println(box2.area());
		
		System.out.println("The diffrence betwin the two boxs: ");
		System.out.println(diff(box,box2));
		
		
		s.close();
	}
	
	public static int diff (Rect rect1, Rect rect2){
		return rect1.area() - rect2.area();
	}
}
