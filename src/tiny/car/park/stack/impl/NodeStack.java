package tiny.car.park.stack.impl;

import tiny.car.park.exceps.EmptyStackException;
import tiny.car.park.stack.StackADT;

public class NodeStack<T> implements StackADT<T>
{
    protected Node<T> top;    // reference to the head node
    protected int size;      // number of elements in stack

    public NodeStack()
    {
        top = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(top == null)
            return true;
        return false;
    }

    @Override
    public T top() throws EmptyStackException {
        if(isEmpty())
            throw new EmptyStackException("Stack is empty.");
        return top.getElement();
    }

    @Override
    public void push(T element) {
        Node<T> v = new Node<T>(element, top);
        top = v;
        size++;
    }

    @Override
    public T pop() throws EmptyStackException {
        if(isEmpty())
            throw new EmptyStackException("Stack is empty.");
        T temp = top.getElement();
        top = top.getNext();
        size--;
        return temp;
    }
}