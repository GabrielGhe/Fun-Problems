/**
 * 
 * This class is an abstract data type called QueueADT
 * It uses FIFO method which means first in, first out
 * 
 * Methods in this class are in alphabetical order
 * Private methods are last
 * 
 * @author Gabriel Gheorghian
 */

public class QueueADT {

	private int[] array;		//Data Scructure
	private int front;			//Holds the front position
	private int rear;			//Holds the last position
	private char growBy;		//Grow by doubling if < 0, else by constant
	public static int changes;	//Used to count enqueue complexity (debug)
	
	/**
	 * 	Default Constructor
	 */
	public QueueADT(){
		array = new int[10];	//Create new array of 10 integers
		front = 0;				//Initialize front to 0
		rear = 0;				//Initialize rear to 0
		growBy = 'd';			//Default array growing is double
	}
	
	
	/**
	 * Removes element at the front and
	 * returns it
	 * @return	item		Element at the front
	 * @throws Exception	If queue is empty, throws Exception
	 */
	public int dequeue() throws Exception{
		//if queue is empty, throw an exception
		if(isEmpty())
			throw new Exception("Cannot dequeue from empty queue.");
		
		front = front % array.length;
		return array[front++];
	}
	
	
	/**
	 * Adds an element to the back of the queue
	 * @param item 			item to add to queue
	 */
	public void enqueue(int item){
		int curSize = size();
		if(curSize >= array.length * 90 / 100)
				growArray();				//if array is full, grow it
		
		rear = rear % array.length;
		array[rear++] = item;				//add item to the rear
	}	
	
	
	/**
	 * Returns a boolean value saying 
	 * if the QueueADT is empty or not
	 * @return boolean
	 */
	public boolean isEmpty(){
		return (front == rear);
	}
	
	
	/**
	 * Sets how the queue grows (constant or doubling)
	 * @param 	character
	 * @return	boolean saying if it was succesful or not
	 */
	public boolean setExpansionRule(char character){
		if(character != 'd' && character != 'c')
			return false;
		
		growBy = character;
		System.out.println("Expension rule is now " + growBy);
		return true;
	} 
	
	
	/**
	 * Returns the current size of queue
	 * @return current size
	 */
	public int size(){
		return ((array.length - front) + rear) % array.length;
	}
	
	
	/**
	 * Returns the top element of the queue
	 * @return top element in the queue
	 * @throws Exception 
	 */
	public int top() throws Exception{
		if(isEmpty())
			throw new Exception("Queue is empty");	//throw an exception if queue is empty
		
		return array[front];
	}
	
	
	/**
	 * Truncates the queue to the exact
	 * size of the used slots of the queue
	 */
	public void truncate(){
		//make sure there's something to truncate
		int temp = size();
		if(temp <= array.length){
			arrayLengthModHelper(temp);
		}
	}
	
	
	/**
	 * Grows the array by a constant
	 * or by doubling it's size
	 */
	private void growArray(){
		//if it's less than 0, means grow by double else by growBy
		int growSize = (growBy == 'd')? array.length * 2 : array.length + 10;
		arrayLengthModHelper(growSize);
	}
	
	
	/**
	 * Creates a new array of size 'size',
	 * places the items from the original array inside
	 * and updates the front and rear
	 * @param size
	 */
	private void arrayLengthModHelper(int size){
		int[] temp = new int[size];		//create new array
		int index = 0;					//index for new array
		//while the front hasn't gotten to the rear, loop
		int sz = size();				//Will contain how many will have to be inserted
		for(int i= 0; i < sz; i++){
			front = front % array.length;
			temp[index++] = array[front++];
		}
		array = temp;						//make temp the new array
		front = 0;							//cache new front
		rear = index;						//cache new rear
		
		changes++;
		System.out.println("Capacity changed... it is now " + size);
	}
	
	/**
	 * toString implemented only to
	 * show marker how ADT works
	 * 
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		String str = "";
		int x = front;
		while (x != rear){
			x = x % array.length;
			str += array[x++] + " ";
		}
		return str;
	}
	
	
	/**
	 * Main Method
	 */
	public static void main(String[] args) {
		
		try
		{
			
			/* ******************************************************************
			 *  50 elements will be enqueued into the queue using the			*
			 *  double Expansion rule											*
			 * ******************************************************************
			 */
			System.out.println("STEP 1 #######################################");
			System.out.println();
			QueueADT queue = new QueueADT();
			
			queue.enqueue(1);	//add 1	queue : [1]
			queue.enqueue(2);	//add 2	queue : [1, 2]
			
			//will show 1	queue : [1, 2]
			System.out.println("Top: " + queue.top() + "\t\t array:" + queue.toString());
			System.out.println("Removed " + queue.dequeue() + "\t array:" + queue.toString()); //will display 1	queue : [2]
			System.out.println("Removed " + queue.dequeue() + "\t array:" + queue.toString()); //will display 2	queue : []
			queue.changes = 0;
			
			//enqueue 50 elements
			for(int i = 0; i < 50; i++){
				queue.enqueue(i);
				System.out.println("size " + queue.size() + "\t\t array:" + queue.toString());
			}
			System.out.println("The queue grew " + queue.changes + " times for 50 insertions");
			
			
			
			
			/* ******************************************************************
			 *  40 elements will be removed from the queue						*
			 * ******************************************************************
			 */
			System.out.println();
			System.out.println("STEP 2 #######################################");
			System.out.println();
			
			//removes first 40
			for(int i = 0; i < 40; i++){
				System.out.println("Removed " + queue.dequeue() + "\t array:" + queue.toString());
			}
			
			
			
			/* ******************************************************************
			 *  - Truncate the queue, which makes the size and capacity 10		*
			 *  - Change expansion to constant									*
			 *  - Enqueue 50 elements using the constant expansion rule			*
			 * ******************************************************************
			 */
			System.out.println();
			System.out.println("STEP 3 #######################################");
			System.out.println();
			
			//truncate to 10 elements
			queue.truncate();
			
			//change expansion rule to c
			queue.setExpansionRule('c');
			queue.changes = 0;
			
			for(int i = 0; i < 50; i++){
				queue.enqueue(i);
				System.out.println("size " + queue.size() + "\t\t array:" + queue.toString());
			}
			System.out.println("The queue grew " + queue.changes + " times for 50 insertions");
			
			
			/* ******************************************************************
			 *  Dequeue everything and try to dequeue again, it will 			*
			 *  cause an exception												*
			 * ******************************************************************
			 */
			System.out.println();
			System.out.println("STEP 4 #######################################");
			System.out.println();
			while(!queue.isEmpty()){
				queue.dequeue();
			}
			System.out.println("Array emptied");
			System.out.println("Expecting an exception, removing from an empty queue");
			queue.dequeue();
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
