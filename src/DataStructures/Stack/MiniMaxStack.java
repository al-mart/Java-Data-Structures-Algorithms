package DataStructures.Stack;

/**
 * This is an implementation of a stack that returns min and max elements in O(1)
 * @param <T>
 */
public class MiniMaxStack<T extends Comparable<T>>{
    private Stack<T> stack;
    private Stack<T> mins;
    private Stack<T> maxs;

    MiniMaxStack(){
    }

    public void push(T data) throws StackOverflowException, StackUnderflowException {
        T min = null;
        T max  = null;
        if(!stack.isEmpty()){
            if(mins.peek().compareTo(data) > 0){
                min = mins.peek();
            }else{
                min = data;
            }
            if(maxs.peek().compareTo(data) > 0){
                max = maxs.peek();
            }else{
                max = data;
            }
        }
        stack.push(data);
        mins.push(min);
        maxs.push(max);
    }
    public T pop() throws StackUnderflowException{
        mins.pop();
        maxs.pop();
        return stack.pop();
    }

    public T getMax() throws StackUnderflowException{
     return maxs.peek();
    }

    public T getMin() throws StackUnderflowException{
        return mins.peek();
    }
}
