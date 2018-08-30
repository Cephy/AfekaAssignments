package simester1.practice_makes_perfect.practice_makes_perfect.presentation3;

import java.util.*;

public class Ch1_q1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int num;
		
		System.out.println("Please entre a number ");
		num = s.nextInt();
		
		for (int i=1, j=1; i<=num ; i++, j++)
			System.out.println(j+"^2"+" "+(i*i));
		}

	}
