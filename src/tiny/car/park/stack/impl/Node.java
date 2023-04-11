package tiny.car.park.stack.impl;

public class Node<T>
{
    private T element;
    private Node<T> next;

    /**
     * Creates a node with null references to its element and next node
     */
    public Node()
    {
        this(null, null);
    }

    /**
     * Creates a node with the given element and next node
     */
    public Node(T e, Node<T> n)
    {
        element = e;
        next = n;
    }

    /**
     * Accessor methods
     */
    public T getElement()
    {
        return element;
    }

    public Node<T> getNext()
    {
        return next;
    }

    /**
     * Modifier methods
     */
    public void setElement(T newElem)
    {
        element = newElem;
    }

    public void setNext(Node<T> newNext)
    {
        next = newNext;
    }
}