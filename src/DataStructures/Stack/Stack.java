package DataStructures.Stack;

import DataStructures.Node.Node;

public class Stack<T extends Comparable<T>> implements Cloneable {
    private Node<T> top;
    private static int MAX_SIZE = 40;
    private int size = 0;

    public Stack() {

    }

    public void push(T data) throws StackOverflowException {
        if (isFull()) {
            throw new StackOverflowException();
        }
        Node<T> newElem = new Node<T>(data);
        newElem.setNext(top);
        top = newElem;
        size++;
    }

    public T pop() throws StackUnderflowException {
        if (isEmpty()) {
            throw new StackUnderflowException();
        }
        T data = top.getData();
        top = top.getNext();
        size--;
        return data;
    }

    public T peek() throws StackUnderflowException {
        if(size == 0){
            throw new StackUnderflowException();
        }
        return top.getData();
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

    public boolean isFull() {
        return size == MAX_SIZE;
    }
}
