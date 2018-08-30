package simester1.word_assignment3_workspace1;

public class Ch5_q7 {

	public static void main(String[] args) {
		int[][] mateNumbers = new int[10][2];
		int numCounter=219, secondMateNum=0, firstMateNumFlag=0, nextNumFlag=0; 
		
		for(int i=0 ; i<mateNumbers.length ; i++){
			boolean mateNumbersFlag = true;
			while(mateNumbersFlag==true){	
				numCounter++;
				if (numCounter==nextNumFlag){
					continue;
				}
				secondMateNum=0;
				for (int j=numCounter-1 ; j!=0 ; j--){
					if(numCounter%j==0){
						secondMateNum+=j;
					}	
				}	
				firstMateNumFlag=0;
				for (int j=secondMateNum-1 ;j!=0 ; j--){
					if(secondMateNum%j==0){
						firstMateNumFlag+=j;
					}
				}
				if((firstMateNumFlag==numCounter)&&(numCounter!=secondMateNum)){
					mateNumbers[i][0]=numCounter;
					nextNumFlag=mateNumbers[i][1]=secondMateNum;
					System.out.printf("%d) %d and %d are mates \n",i+1,mateNumbers[i][0],mateNumbers[i][1]);
					mateNumbersFlag=false;
				}
			}		
		}
	}
}