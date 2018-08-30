package simester1.word_assignment;

import java.util.*;

public class Ch3_q7 {

	public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	
		final int LOW_HOME_WORK_BAR = 4, MID_HOME_WORK_BAR = 6, HIGH_HOME_WORK_BAR = 7, //Exam and number of assignments bars
				  TOTAL_FAIL=0, FINAL_EXAM_BAR = 54, HOME_WORK_LOW_AVERAGE_BAR = 80;
		final double FINAL_EXAM_LOW_FACTOR = 0.2, HOME_WORK_MID_FACTOR1 = 0.25,  		//Shield Factors
					 HOME_WORK_MID_FACTOR2 = 0.2, HOME_WORK_HIGH_FACTOR = 0.3;
		int HomeWorkAverageGrade, HomeWorkAmount, FinalExam;
		
		
		System.out.println("Please enter the number of assignments you have turned in ");
		HomeWorkAmount = s.nextInt();
		if (LOW_HOME_WORK_BAR>=HomeWorkAmount)										//auto fail for not enough assignments
			System.out.println("We are sorry, your final grade is " + TOTAL_FAIL);		
		else {
			System.out.println("Please enter your HomeWork average grades");
			HomeWorkAverageGrade = s.nextInt();
			System.out.println("Please enter your final exam grade");
			FinalExam = s.nextInt();
			
				
			if (HomeWorkAmount<=MID_HOME_WORK_BAR && LOW_HOME_WORK_BAR<HomeWorkAmount	//5-6 assignments 
				&& FinalExam<FINAL_EXAM_BAR)
				System.out.println("Your final grade is " + (int)(FinalExam*(1-FINAL_EXAM_LOW_FACTOR) 
								  + HomeWorkAverageGrade*FINAL_EXAM_LOW_FACTOR));
			else System.out.println("Your final grade is " + FinalExam);
			if (HIGH_HOME_WORK_BAR<=HomeWorkAmount && FinalExam<=FINAL_EXAM_BAR		//7-8 assignments, above 80 H.W average 
				&& HOME_WORK_LOW_AVERAGE_BAR<=HomeWorkAverageGrade) {
				if ((FinalExam*(1-HOME_WORK_MID_FACTOR1) + HomeWorkAverageGrade*HOME_WORK_MID_FACTOR1)>FinalExam) 
				System.out.println("Your final grade is " + (int)(FinalExam*(1-HOME_WORK_MID_FACTOR1) 
								  + HomeWorkAverageGrade*HOME_WORK_MID_FACTOR1));
				else System.out.println("Your final grade is " + FinalExam);		
			}
			if (HIGH_HOME_WORK_BAR<=HomeWorkAmount && FinalExam<=FINAL_EXAM_BAR		//7-8 assignments, under 80 H.W average 
					&& HOME_WORK_LOW_AVERAGE_BAR>HomeWorkAverageGrade) {
				if ((FinalExam*(1-HOME_WORK_MID_FACTOR2) + HomeWorkAverageGrade*HOME_WORK_MID_FACTOR2)>FinalExam) 
					System.out.println("Your final grade is " + (int)(FinalExam*(1-HOME_WORK_MID_FACTOR2) 
									  + HomeWorkAverageGrade*HOME_WORK_MID_FACTOR2));
				else System.out.println("Your final grade is " + FinalExam);
			}
			if (HIGH_HOME_WORK_BAR<=HomeWorkAmount && FinalExam>FINAL_EXAM_BAR){	//7-8 assignments, above 55 final average 
			    if ((FinalExam*(1-HOME_WORK_HIGH_FACTOR) + HomeWorkAverageGrade*HOME_WORK_HIGH_FACTOR)>FinalExam) 
					System.out.println("Your final grade is " + (int)(FinalExam*(1-HOME_WORK_HIGH_FACTOR) 
									  + HomeWorkAverageGrade*HOME_WORK_HIGH_FACTOR));
				else System.out.println("Your final grade is " + FinalExam);
			}
		}
	}

}
