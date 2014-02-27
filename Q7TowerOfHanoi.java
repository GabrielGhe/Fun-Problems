public class Q6TowerOfHanoi {

	public static void move(int n, int from, int to, int via){
		//base
		if(n == 1){
			System.out.println("Moving pole from " + from + " to " + to);
		} else {
			move(n - 1, from, via, to);
			move(1, from, to, via);
			move(n - 1, via, to, from);
		}
	}
	
	public static void main(String[] args) {
		move(2, 1, 3, 2);
	}

}
