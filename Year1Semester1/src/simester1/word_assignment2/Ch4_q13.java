package simester1.word_assignment2;

import java.util.*;

public class Ch4_q13 {

	public static void main(String[] args) {
		Scanner s = new Scanner (System.in);
		int num;
		
		System.out.println("please enter a number ");
		num = s.nextInt();
		
		for (int LineOuter = num ; LineOuter!=0 ; LineOuter-- ){
			for (int RowOuter = num ; RowOuter!=0 ; RowOuter--){
				for (int LineInner = num ; LineInner!=0 ; LineInner--){
					for (int RowInner = num ; RowInner!=0 ; RowInner-- ){
						System.out.print("*");
					}	
					System.out.print(" ");
				}
				System.out.println("");
			}
			System.out.println("");	
		}
	}

}
