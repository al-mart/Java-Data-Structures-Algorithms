package Algorithms.Sorting;

import DataStructures.Heap.Heap;

/**
 * Hear we use a MaxHeap
 * percolateDown is used in spite of siftDown
 */
public class HeapSort extends Heap<Integer> {

    public HeapSort() {
        super(Integer.class);
    }

    @Override
    public void siftDown(int index) {

    }

    @Override
    public void siftUp(int index) {

    }

    public void heapify(int endIndex){
        int index = getParentIndex(endIndex);
        while (index >= 0){
            percolateDown(index, endIndex);
            index--;
        }

    }

    public void percolateDown(int index, int endIndex){
        int leftIndex = getLeftChildIndex(index, endIndex);
        int rightIndex = getRightChildIndex(index, endIndex);

        if(leftIndex != -1 && array[leftIndex] > array[index]){
            swap(leftIndex, index);
            percolateDown(leftIndex, endIndex);
        }

        if(rightIndex != -1 && array[rightIndex] > array[index]){
            swap(rightIndex, index);
            percolateDown(rightIndex, endIndex);
        }
    }

    public void heapSortRec(int endIndex){
        if(endIndex == 0){
            return;
        }
        swap(0, endIndex);
        percolateDown(0,endIndex - 1);
        heapSortRec(endIndex - 1);
    }

    public void heapSort(){
        int endIndex = array.length -1 ;
        heapify(endIndex);
        while(endIndex > 0 ){
            swap(0, endIndex);
            endIndex--;
            percolateDown(0, endIndex);
        }
    }

    public static void sort(Integer [] array){
        HeapSort heap = new HeapSort();
        heap.array = array;
        heap.heapify(array.length - 1);
        heap.heapSortRec(array.length - 1);
    }
}
