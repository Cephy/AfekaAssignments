package simester1.word_assignment;

import java.util.*;

public class Ch3_q6 {

	public static void main(String[] args) {
	Scanner s = new Scanner(System.in); 
	
	final int HIGH_SHAPE_FACTOR = 60,  	INTER_SHAPE_FACTOR = 70,					   //Fixed Shape parameters
			  BEG_TIME = 2,      	  	INTER_TIME = 4, 				ADV_TIME = 5,  //Fixed training time parameters
			  BEG_LOW_SHAPE_DIS = 3,    INTER_DIS_HIGH_SHAPE = 5, 					   //Fixed distance parameters
			  ADV_DIS_HIGH_SHAPE = 10, 	ADV_DIS_MID_SHAPE = 8; 	  					   //Fixed distance parameters
			  //BEG = BEGINNER, INTER = INTERMEDIATE, ADV = ADVANCED, DIS = DISTANCE 
	
	double TimeTraining; 
	int ReposePulse; 
	
	System.out.println("how many weeks have you been training? ");
	TimeTraining = s.nextDouble();
	if (TimeTraining <= BEG_TIME)																			
		System.out.println("As you are at the beginning of your training we recommend you to run "
						  + BEG_LOW_SHAPE_DIS + " Kilometers each training session\nuntil you reach your thired week");
	else
		System.out.println("what is your resting heart rate? ");
		ReposePulse = s.nextInt(); 
		if (ReposePulse>=INTER_SHAPE_FACTOR)																	
		System.out.println("With heart rate above 70 we recommend you to keep runing "
						  + BEG_LOW_SHAPE_DIS + " Kilometers each training session\nuntil you lower your heart rate to blow 70");
		if (ReposePulse<INTER_SHAPE_FACTOR && BEG_TIME<TimeTraining && TimeTraining<=INTER_TIME)					
			System.out.println("We recommend you to run " + INTER_DIS_HIGH_SHAPE + " kilometers on your next session ");
		if (ReposePulse<=HIGH_SHAPE_FACTOR && TimeTraining>=ADV_TIME)
			System.out.println("We recommend you to run " + ADV_DIS_HIGH_SHAPE + " kilometers on your next session ");
		if (ReposePulse>HIGH_SHAPE_FACTOR && ReposePulse<INTER_SHAPE_FACTOR && TimeTraining>=ADV_TIME)
			System.out.println("We recommend you to run" + ADV_DIS_MID_SHAPE + " kilometers on your next session ");
	
	}

}
