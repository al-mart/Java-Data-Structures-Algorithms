package DataStructures.Heap;

import java.lang.reflect.Array;

public abstract class Heap<T extends Comparable> {
    public static int MAX_SIZE = 40;
    public T[] array;
    private int count = 0;

    public abstract void siftDown(int index);
    public abstract void siftUp(int index);

    public Heap(){
        this((Class<T>) Integer.class, MAX_SIZE);
    }

    public Heap(Class<T> clazz){
        this(clazz, MAX_SIZE);
    }
    public Heap(Class<T> clazz, int size){
        array = (T[])Array.newInstance(clazz, size);
    }

    public int getLeftChildIndex(int index){
        int leftChildIndex = index*2 +1;
        if(leftChildIndex >= count){
            return -1;
        }
        return leftChildIndex;
    }

    public int getLeftChildIndex(int index,int endIndex){
        int leftChildIndex = index*2 +1;
        if(leftChildIndex >= count || leftChildIndex >= endIndex){
            return -1;
        }
        return leftChildIndex;
    }

    public int getRightChildIndex(int index){
        int rightChildIndex = index*2 +1;
        if(rightChildIndex  >= count){
            return -1;
        }
        return rightChildIndex;
    }

    public int getRightChildIndex(int index, int endIndex){
        int rightChildIndex = index*2 +1;
        if(rightChildIndex  >= count || rightChildIndex >= endIndex){
            return -1;
        }
        return rightChildIndex;
    }

    public int getParentIndex(int index){
        if (index < 0 || index > count){
            return -1;
        }
        return ( index - 1 ) / 2;
    }

    public int getParentIndex(int index, int endIndex){
        if (index < 0 || index > count || index > endIndex){
            return -1;
        }
        return ( index - 1 ) / 2;
    }

    protected void swap(int index1, int index2){
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public int getCount() {
        return count;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return  count == array.length;
    }

    public T getElementAtIndex(int index){
        return array[index];
    }

    public void setElementAtIndex(T element,int index){
        array[index] = element;
    }

    public void insert(T value) throws Exception{
        if(count >= array.length){
            throw new Exception("Heap fuill");
        }
        array[count] = value;
        siftUp(count);
        count++;
    }
    public  T removeHighestPriority() throws Exception{
        T element = getHighestPriority();
        array[0] = array[count - 1];
        count--;
        siftDown(0);
        return element;
    }

    public T getHighestPriority() throws Exception{
        if (count == 0){
            throw new Exception("Heap Empty");
        }
        return array[0];
    }
}
