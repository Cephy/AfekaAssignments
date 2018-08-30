package simester1.word_assignment;

import java.util.*;

public class Ch3_q5 {

	public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
		
		final int FINAL_GRADE_BAR = 102, SAT_TOT_BAR = 700, SAT_MATH_BAR = 145, SAT_ENGLISH_BAR = 120, 		//SAT = psihometri
				  AVERAGE_BAR = 600;
		final double AVERAGE_FACTOR = 1.2, SAT_FACTOR = 0.8;
		int exam, SatTot, math, english; 
	
		System.out.println("what is your final exams average? ");
		exam = s.nextInt();
		System.out.println("what is your S.A.T's score? ");
		SatTot = s.nextInt();
		System.out.println("what is your S.A.T's mathe grade score? ");
		math = s.nextInt();
		System.out.println("what is your S.A.T's english grade score? ");
		english = s.nextInt();
		
		if (exam > FINAL_GRADE_BAR || (SatTot > SAT_TOT_BAR 
			&& math > SAT_MATH_BAR && english > SAT_ENGLISH_BAR) || 
			(SatTot*SAT_FACTOR + exam/AVERAGE_FACTOR) > AVERAGE_BAR)
			System.out.println("congratulations you got into our amazing university ");
		else
			System.out.println("sorry, you didn't got into our amazing university.\n try again next year ");
	}
	

}
