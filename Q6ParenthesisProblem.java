import java.util.Stack;

public class Q6TowerOfHanoi {

	public static void paranHelp(int open, int close, int balance, Stack<String> list){
		
		//base case
		if(open + close == 0){
			for(String x: list)
				System.out.print(x);
			System.out.println();
		}
		
		//case 1
		if(balance > 0 && close > 0){
			list.push(")");
			paranHelp(open, close - 1, balance - 1, list);
			list.pop();
		}
		
		//case 2
		if(open > 0){
			list.push("(");
			paranHelp(open - 1, close, balance + 1, list);
			list.pop();
		}

	}
	
	public static void paran(int num){
		System.out.println("Number of paranthesis " + num);
		paranHelp(num, num, 0, new Stack<String>());
		System.out.println("----------------------------");
	}
	
	public static void main(String[] args) {
		paran(4);
	}

}
