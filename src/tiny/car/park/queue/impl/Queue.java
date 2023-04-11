package tiny.car.park.queue.impl;

import java.util.ArrayList;

import tiny.car.park.queue.QueueADT;

//Class 1
//Helper Class(user defined - generic queue class)
public class Queue<T> implements QueueADT<T>  {
	// front and rear variables are initially initiated to
	// -1 pointing to no element that control queue
	int front = -1, rear = -1;

	// Creating an object of ArratList class of T type
	ArrayList<T> A = new ArrayList<>();

	// Method 1
	// Returns value of element at front
	public T peek()
	{
		// If it is not pointing to any element in queue
		if (front == -1)

			return null;

		// else return the front element
		return A.get(front);
	}
	// Method 2
	// Returns value of element at rear
	public T rear()
	{
		// If it is not pointing to any element in queue
		if (rear == -1)
			return null;
		return A.get(rear);
	}
	// Method 3
	// Inserts element at the front of queue
	public void enqueue(T X)
	{
		// If queue is empty
		if (this.isEmpty()) {
			front = 0;
			rear = 0;
			A.add(X);
		}

		// If queue is not empty
		else {
			front++;
			if (A.size() > front) {

				// Mov front pointer to next
				A.set(front, X);
			}
			else

				// Add element to the queue
				A.add(X);
		}
	}
	// Method 4
	// Deletes elements from the rear from queue
	public void dequeue()
	{
		// if queue doesn't have any elements
		if (this.isEmpty())

			// Display message when queue is already empty
			System.out.println("Queue is already empty");

		// If queue has only one element
		else if (front == rear) {

			// Both are pointing to same element
			front = rear = -1;
		}

		// If queue has more than one element
		else {

			// Incrememnt the rear
			rear++;
		}
	}

	// Method 5
	// Checks whether the queue is empty
	public boolean isEmpty()
	{
		// Both are initialized to same value
		// as assigned at declaration means no queue made
		if (front == -1 && rear == -1)
			return true;
		return false;
	}
	// Method 6
	// Print the queue

	// @Override
	public String toString()
	{
		if (this.isEmpty())
			return "";

		String Ans = "";

		for (int i = rear; i < front; i++) {
			Ans += String.valueOf(A.get(i)) + "->";
		}

		Ans += String.valueOf(A.get(front));

		return Ans;
	}
}