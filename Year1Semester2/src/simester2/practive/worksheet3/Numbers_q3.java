package simester2.practive.worksheet3;

public class Numbers_q3 {

	private static final int MAX = 6;
	private static final int MIN = 3;
	
	public static boolean range (int number)throws RangeException {
		if (MIN>number || MAX<number ){
			throw new RangeException();		
		}
		return true;
	}
}
