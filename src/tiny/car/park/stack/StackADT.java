package tiny.car.park.stack;

import tiny.car.park.exceps.EmptyStackException;

/**
 * An interface for the Stack ADT.
 *  */
public interface StackADT<T>
{
    /**
    * Return the number of elements in the stack.
    */
    public int size();

    /**
     * Return true if the stack is empty, false otherwise.
     */
    public boolean isEmpty();

    /**
     * Return element at the top of the stack.
     * Throws EmptyStackException if the stack is empty.
     */
    public T top() throws EmptyStackException;

    /**
     * Insert an element at the top of the stack.
     */
    public void push(T element);

    /**
     * Remove the top element from the stack.
     * Throws EmptyStackException if the stack is empty.
     */
    public T pop() throws EmptyStackException;
}