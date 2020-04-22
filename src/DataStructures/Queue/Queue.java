package DataStructures.Queue;

import DataStructures.Node.Node;

import java.lang.reflect.Array;

public class Queue<T extends Comparable<T>> {
    private static final int SPECIAL_EMPTY_VALUE = -1;
    private static int MAX_SIZE = 40;
    private T[] elements;

    private int headIndex = SPECIAL_EMPTY_VALUE;
    private int tailIndex = SPECIAL_EMPTY_VALUE;

    public Queue(Class<T> tClass) {
        elements = (T[]) Array.newInstance(tClass, MAX_SIZE);
    }

    public void enqueue(T data) throws QueueOverflowException {
        if (isFull()) {
            throw new QueueOverflowException();
        }
        tailIndex = (tailIndex + 1) % elements.length;
        elements[tailIndex] = data;
        if (headIndex == SPECIAL_EMPTY_VALUE) {
            headIndex = tailIndex;
        }
    }

    public T dequeue() throws QueueUnderflowException {
        if(isEmpty()){
            throw new QueueUnderflowException();
        }
        T data = elements[headIndex];

        if (headIndex == tailIndex) {
            headIndex = SPECIAL_EMPTY_VALUE;
        }else{
            elements[headIndex] = null;
            headIndex = (headIndex + 1) % elements.length;
        }
        return data;
    }

    public void offer(T data) {
        if (!isFull()) {
            try {
                enqueue(data);
            } catch (QueueOverflowException ignored) {
            }
        }
    }

    public boolean isEmpty() {
        return headIndex == SPECIAL_EMPTY_VALUE;
    }

    public boolean isFull() {
        int nextIndex = (tailIndex + 1) % elements.length;
        return nextIndex == headIndex;
    }
}
