import java.util.regex.Matcher;
import java.util.regex.Pattern;
	
public class Q4FindTargetInPowerOf2 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(findThisThing(42));
	}
	
	public static int findThisThing(int target){
		//initializing junk...
		Pattern pattern = Pattern.compile("" + target);
		Matcher m = null;
		int index = 0;
		int power = (int) Math.pow(2,index);
 
		//while the value is less than or equal to limit
		while(index <= 210000){
			//the target has been found in this power
			m = pattern.matcher(power+"");
			
			if(m.find()){
				//return the index at this power
				return index;
			} else {
				//update to next power of 2
				power = (int) Math.pow(2,++index);
				System.out.println("index: " + index + " power: " + power);
			}
		}
		
		return -1;
	}
}
