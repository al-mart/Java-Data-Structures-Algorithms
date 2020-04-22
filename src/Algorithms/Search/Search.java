package Algorithms.Search;

public class Search {

    public static int binarySearch(int elementToFind, int[] array){
        int midIndex = array.length / 2 + array.length % 2 ;
        if(array[midIndex] == elementToFind){
            return midIndex;
        }else if( array[midIndex] > elementToFind){
            binarySearch(elementToFind, splice(array, 0, midIndex));
        }else{
            binarySearch(elementToFind, splice(array, midIndex, array.length - 1));
        }
        return  -1;
    }

    public static int[] splice(int[] array,int startIndex,int endIndex){
        int length = endIndex - startIndex + 1;
        int [] clone = new int[length];
        for (int i = 0; i <= length; i++){
            clone[i] = array[i + startIndex];
        }
        return clone;
    }

    public static int binarySearchCycle(int elementToFind, int[] array){
        int first = 0;
        int last = array.length - 1;

        while(first < last){
            int mid = first +  (first + last)/2;
            if(array[mid] == elementToFind){
                return elementToFind;
            }
            else if(array[mid] > elementToFind){
                last = mid - 1;
            }else{
                first = mid + 1;
            }
        }
        return -1;
    }
}
