package DataStructures.Heap;

public class MinHeap<T extends Comparable> extends Heap<T> {

    public MinHeap(Class<T> clazz) {
        super(clazz);
    }

    public MinHeap(Class<T> clazz, int size) {
        super(clazz, size);
    }
    @Override
    public void siftDown(int index){
        int leftIndex = getLeftChildIndex(index);
        int rightIndex = getRightChildIndex(index);

        int smallerIndex = -1;
        if(leftIndex != -1 && rightIndex != -1){
            smallerIndex = getElementAtIndex(leftIndex).compareTo(getElementAtIndex(rightIndex)) < 0 ? leftIndex : rightIndex;
        }
        else if( leftIndex != -1){
            smallerIndex = leftIndex;
        }
        else if( rightIndex != -1){
            smallerIndex = rightIndex;
        }
        if (smallerIndex == -1){
            return;
        }
        if (getElementAtIndex(index).compareTo(getElementAtIndex(smallerIndex)) < 0){
            swap(smallerIndex, index);
            siftDown(smallerIndex);
        }
    }

    @Override
    public void siftUp(int index) {
        int parentIndex = getParentIndex(index);
        if(parentIndex != -1 && getElementAtIndex(index).compareTo(getElementAtIndex(parentIndex)) < 0){
            swap(parentIndex, index);
            siftUp(parentIndex);
        }
    }

    public T maxElement(){
        int firstLeafIndex = ( array.length - 1 ) / 2;
        T maxElement = array[firstLeafIndex];
        for(int i = firstLeafIndex; i < array.length; i++){
            maxElement = array[i].compareTo(maxElement) > 0 ? array[i] : maxElement;
        }
        return maxElement;
    }

    public static void KlargestElements(int [] stream, int k ) throws Exception{
        MinHeap<Integer> heap = new MinHeap(Integer.class, stream.length);
        for(int i = 0; i < k; i++){
            heap.insert( stream[i] );
            heap.siftUp(heap.getCount() - 1);
        }
        for(int i = k; i < stream.length; i++){
            if(heap.getElementAtIndex(0) < stream[i]){
                heap.setElementAtIndex(stream[i],0);
                heap.siftDown(0);
            }
        }
    }
}
