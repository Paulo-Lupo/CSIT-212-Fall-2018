/*
 * Homework 7 - Queue.java
 * Joao Paulo D. S. Ferreira
 * CSIT 212 - Data Structures and Algorithms
 * Dr. Boxiang Dong
 * November 8, 2018
 */

/*
 * CSIT 212 Homework 7 - BFS & DFS 
 * This program contains some minor changes to 
 * the Queue program from Homework 3.
 * It still does the same it used to do before and some more.
 */

package ds;

public class Queue {
	
	public int size;
	public int[] array;
	public int head;
	public int tail;
	
	public Queue () {
		size = 0;
		array = null;
		head = -1;
		tail = 0;
	}
	
	public Queue (int _size) {
		size = _size;
		array = new int[size];
		head = -1;
		tail = 0;
	}
	
	/*
	 * Implement the ENQUEUE(Q, x) function
	 */
	public void enqueue (int x) {

		array[tail] = x;
			
		// only needed because of for the for loop in the toString method
		if (head == -1) {
			head = 0;
		}
		
		// Bonus Credit: Checks if the queue is full
		if(tail == size-1) { 		
			tail = 0;
		} else {
			tail++;
		}
	}
	
	/*
	 * Implement the DEQUEUE(Q) function
	 */
	public int dequeue () {		
		int x = array[head];
		if(head == size-1) {			
			head = 0;
		} else {
			head++;
		}
		
		return x;
	}
	
	// Returns if the queue is empty or not
	public boolean isEmpty() {
		if ((tail + 1) % size == head) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * Converts queue to string in the format of size, head, tail, [elements]
	 */
	public String toString () {
		String str;
		
		str = size + ", " + head + ", " + tail + ", [";
		for (int i = head; i%size < tail; i++) {
			str += array[i] + ",";
		}
		
		str += "]";
		return str;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue q;
		
		q = new Queue(10);
		for (int i = 0; i < 5 ; i++)
			q.enqueue(i);
		System.out.println(q.toString());
		for (int i = 0; i < 2; i++) 
			q.dequeue();
		System.out.println(q.toString());
	}
}
