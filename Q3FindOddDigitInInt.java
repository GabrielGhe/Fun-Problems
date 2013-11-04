public class Q3FindOddDigitInInt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		Assumptions: all the digits in i are an even number except for only 1
		*/
		int i = 112233555;
		int mask = 0;
			
		while(i != 0){
			int temp = i % 10;				
			mask = mask ^ (1 << temp);	
			i = i /10;					
		}										
		int answer = (int)( Math.log10(mask) / Math.log10(2) );
		System.out.println("Answer is " + answer);				
	}

}
