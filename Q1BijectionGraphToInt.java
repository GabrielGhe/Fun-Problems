/**
 * Going from a Z x Z -> Z
 * @author gabrielgheorghian
 *
 */
public class Q1BijectionGraphToInt {

	public static int findThatInt(int x, int y){
		int loopAmount = (Math.abs(x) > Math.abs(y))? Math.abs(x): Math.abs(y);
		boolean debug = false;
		
		//outer loop, how far the point is from the center
		int xVal = 0;
		int yVal = 0;
		int count = 0;
		for(int i=0; i <= loopAmount; i++){
			if(x == xVal && y == yVal) return count;
			
			//at the beginning (0,0) = 0
			if(xVal == 0 && yVal == 0){
				xVal++;
				count++;
			} else {
				//going up
				if(debug)
					System.out.println("Goin up");
				while(yVal != i){
					if(debug)
						System.out.println("Count " + count + " xVal " + xVal + " yVal " + yVal);
					if(x == xVal && y == yVal)
						return count;
					else {
						yVal++;
						count = (count < 0)? (count * -1) + 1: (count * -1);
					}
				}
				//going left
				if(debug)
					System.out.println("Goin left");
				while(xVal != (i*-1)){
					if(debug)
						System.out.println("Count " + count + " xVal " + xVal + " yVal " + yVal);
					if(x == xVal && y == yVal) 
						return count;
					else {
						xVal--;
						count = (count < 0)? (count * -1) + 1: (count * -1);
					}
				}
				//going down
				if(debug)
					System.out.println("Goin down");
				while(yVal != (i*-1)){
					if(debug)
						System.out.println("Count " + count + " xVal " + xVal + " yVal " + yVal);
					if(x == xVal && y == yVal) 
						return count;
					else {
						yVal--;
						count = (count < 0)? (count * -1) + 1: (count * -1);
					}
				}
				//going right
				if(debug)
					System.out.println("Goin right");
				while(yVal != (i+1)){
					if(debug)
						System.out.println("Count " + count + " xVal " + xVal + " yVal " + yVal);
					if(x == xVal && y == yVal) 
						return count;
					else {
						xVal++;
						count = (count < 0)? (count * -1) + 1: (count * -1);
					}
				}
			}
		}
		return count;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(findThatInt(-1, 1));
	}

}
