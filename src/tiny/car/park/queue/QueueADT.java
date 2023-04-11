package tiny.car.park.queue;
/**
 * An interface for the Queue ADT.
*/
public interface QueueADT<T> {

	/** Adds the given item to the back of the queue.
	 * @param item the item to add
	 */
	public void enqueue(T item);

	/** Removes an item from the front of the queue and returns it.
	 * @return the item at the front of the queue, or null if empty
	 */
	public void dequeue();

	/** Returns the item at the front of the queue, without removing it.
	 * @return the item at the front of the queue, or null if empty
	 */
	public T peek();
	
	/** Returns the item at the rear of the queue, without removing it.
	 * @return the item at the rear of the queue, or null if empty
	 */
	public T rear();
	/** Returns true if the queue is empty.
	 */
	public boolean isEmpty();

}
