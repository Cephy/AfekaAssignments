package simester1.word_assignment2;

import java.util.*;

public class Ch4_q14 {

	public static void main(String[] args) {
		Scanner s = new Scanner (System.in);
		final int TriangleQuantity=3;
		int num;
	
		System.out.println("please enter an odd number ");
		num = s.nextInt();
		
		for (int triangle=TriangleQuantity ; triangle!=0 ; triangle--){
			for (int Line=0 ; Line<=num ; Line++){
				for (int spaces=num-Line ; spaces!=0 ; spaces--){
					System.out.print(" ");
				}
				for (int row=Line ; row!=0 ; row--){
					System.out.print("* ");
				}
				if (num!=Line){
					System.out.println("");
				}
			}
		}
		System.out.println("");
		for (int line=num ; line!=0 ; line--){
			for (int spaces=num-1 ; spaces!=0 ; spaces--){
				System.out.print(" ");
			}
		System.out.println("*");
		}
	}		

}
