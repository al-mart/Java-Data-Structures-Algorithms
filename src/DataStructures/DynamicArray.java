package DataStructures;

import java.lang.reflect.Array;

public class DynamicArray<T extends Comparable<T>> {
    private int size = 0;
    private int capacity = 10;
    private T[] array;
    private Class<T> clazz;

    DynamicArray(Class<T> clazz, int capacity) {
        this.capacity = capacity;
        this.clazz = clazz;
        array = (T[]) Array.newInstance(this.clazz, this.capacity);
    }

    DynamicArray(Class<T> clazz) {
        this.clazz = clazz;
        array = (T[]) Array.newInstance(this.clazz, this.capacity);
    }

    public void add(T element) {
        checkAndDoubleCapSize();
        this.array[size] = element;
        this.size++;
    }

    public void add(T element, int index) {
        if (index < capacity) {
            checkAndDoubleCapSize();
            this.array[index] = element;
            this.size++;
        }
    }

    private void checkAndDoubleCapSize() {
        this.capacity *= 2;
        T[] temp = (T[]) Array.newInstance(this.clazz, this.capacity);
        System.arraycopy(this.array, 0, temp, 0, this.array.length);
        this.array = temp;
    }

    public T remove() {
        T element = this.array[size];
        this.array[size] = null;
        size--;
        return element;
    }

    public T remove(int index) {
        if (index < size) {
            T element = this.array[index];
            this.array[index] = null;
            for(int i = index; i < size - 1; i++){
                array[i] = array[i+1];
            }
            size--;
            return element;
        }
        return null;
    }

    public int indexOf(T element) {
        for (int i = 0; i < size; i++){
            if(array[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    public T getElementByIndex(int index) {
        if ( index < size){
            return array[index];
        }
        return null;
    }
}
