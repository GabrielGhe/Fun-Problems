import java.util.ArrayList;

public class Q5VampireNumbers {

	public static void main(String[] args) {
		ArrayList<String> x = findTheVampNums(4);
		
		for(String combo: x)
			System.out.println(combo);
	}
	
	public static ArrayList<String> findTheVampNums(int vNumLength){
		ArrayList<String> results = new ArrayList<String>();
		
		if(vNumLength % 2 == 1){
			throw new IllegalArgumentException();//bad
		} else {
			//create the initial value to start from... the numbers have to be half the length
			int start = (int) Math.pow(10, (vNumLength / 2) - 1);
			
			for(int i=start; i < (start * 10); i++){
				for(int j=start; j < (start * 10); j++){
					String lengthOfMulti = (i*j) + "";
					if((lengthOfMulti.length() == vNumLength) && isItVampNum(i,j))
						results.add(i + " x " + j + " = " + (i * j));
				}
			}
		}
		return results;
	}
	
	public static boolean isItVampNum(int first, int second){
		ArrayList<Integer> dic = new ArrayList<Integer>();
		int vamp = first * second;
		while(first != 0){
			dic.add(first % 10);
			first /= 10;
		}
		while(second != 0){
			dic.add(second % 10);
			second /= 10;
		}
		int index = 0;
		while(vamp != 0){
			index = dic.indexOf(vamp % 10);
			if(index != -1)
				dic.remove(index);
			vamp /= 10;
		}
		return (dic.size() == 0);
	}
	
	
}
