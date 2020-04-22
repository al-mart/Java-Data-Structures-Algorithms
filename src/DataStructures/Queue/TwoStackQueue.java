package DataStructures.Queue;

import DataStructures.Stack.Stack;
import DataStructures.Stack.StackOverflowException;
import DataStructures.Stack.StackUnderflowException;

public class TwoStackQueue<T extends Comparable<T>> {
    private Stack<T> forwardStack = new Stack<T>();
    private Stack<T> reverseStack = new Stack<T>();

    public void enqueue(T data) throws QueueOverflowException {
        reverse();
        try{
            forwardStack.push(data);
        }catch(StackOverflowException exc){
            throw new QueueOverflowException();
        }

    }

    public T dequeue() throws QueueOverflowException{
        reverse();
        try{
            return reverseStack.pop();
        }catch (StackUnderflowException exc){
            throw new QueueOverflowException();
        }
    }

    public void reverse() {
        try {
            if (forwardStack == null) {
                while (!reverseStack.isEmpty()) {
                    forwardStack.push(reverseStack.pop());
                }
            } else {
                while (!forwardStack.isEmpty()) {
                    reverseStack.push(forwardStack.pop());
                }
            }
        }catch (Exception exc){}
    }
}
