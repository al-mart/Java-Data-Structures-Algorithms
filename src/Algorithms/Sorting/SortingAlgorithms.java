package Algorithms.Sorting;

import Algorithms.Helpers;

public class SortingAlgorithms {

    public static int[] selectionSort(int[] arrayToSort) {
        int[] sortedArray = arrayToSort.clone();
        for (int i = 0; i < sortedArray.length; i++) {
            for (int j = i + 1; j < sortedArray.length; j++) {
                if (sortedArray[i] > sortedArray[j])
                    Helpers.swap(sortedArray, i, j);
            }
        }
        return sortedArray;
    }

    /**
     * Here we start from end but sorting takes place from the beginning
     *
     * @param arrayToSort
     * @return sortedArray
     */
    public static int[] bubbleSortFromBeg(int[] arrayToSort) {
        int[] sortedArray = arrayToSort.clone();
        boolean swapped;
        for (int i = 0; i < sortedArray.length; i++) {
            swapped = false;
            for (int j = sortedArray.length - 1; j > i; j--) {
                if (sortedArray[j] < sortedArray[j - 1]) {
                    Helpers.swap(sortedArray, j, j - 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return sortedArray;
    }

    /**
     * Here we start from end but sorting takes place from the beginning
     *
     * @param arrayToSort
     * @return sortedArray
     */
    public static int[] bubbleSortFromEnd(int[] arrayToSort) {
        int[] sortedArray = arrayToSort.clone();
        boolean swapped;
        for (int i = 1; i < sortedArray.length + 1; i++) {
            swapped = false;
            for (int j = 0; j < i; j++) {
                if (sortedArray[j] > sortedArray[j + 1]) {
                    Helpers.swap(sortedArray, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return sortedArray;
    }

    public static int[] insertionSort(int[] arrayToSort) {
        int[] sortedArray = arrayToSort.clone();
        for (int i = 0; i < sortedArray.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (sortedArray[j] < sortedArray[j - 1]) {
                    Helpers.swap(sortedArray, j, j - 1);
                } else {
                    break;
                }
            }
        }
        return sortedArray;
    }

    public static int[] shellSort(int[] arrayToSort) {
        int[] sortedArray = arrayToSort.clone();
        int increment = sortedArray.length / 2;
        while (increment >= 1) {
            for (int startIndex = 0; startIndex <= increment; startIndex++) {
                insertionShellSort(sortedArray, startIndex, increment);
            }
            increment = increment / 2;
        }
        return sortedArray;
    }

    private static void insertionShellSort(int[] array, int startIndex, int increment) {
        for (int i = startIndex; i < array.length; i = i + increment) {
            for (int j = Math.min(i + increment, array.length - 1);
                 j - increment >= 0;
                 j = j - increment) {
                if (array[j] < array[j - increment]) {
                    Helpers.swap(array, j, j - increment);
                } else {
                    break;
                }
            }
        }
    }

    public static int[] mergeSort(int[] arrayToSort) {
        int[] sortedArray = arrayToSort.clone();
        internalMergeSort(sortedArray);
        return sortedArray;
    }

    public static void internalMergeSort(int[] arrayToSort) {
        if (arrayToSort.length == 1) {
            return;
        }
        int midIndex = arrayToSort.length / 2 + arrayToSort.length % 2;
        int[] firstHalf = new int[midIndex];
        int[] secondHalf = new int[arrayToSort.length - midIndex];
        split(arrayToSort, firstHalf, secondHalf);
        mergeSort(firstHalf);
        mergeSort(secondHalf);
        merge(arrayToSort, firstHalf, secondHalf);
    }

    private static void split(int[] array, int[] firstHalf, int[] secondHalf) {
        int index = 0;
        int secondHalfStartIndex = firstHalf.length;
        for (int elements : array) {
            if (index < secondHalfStartIndex) {
                firstHalf[index] = array[index];
            } else {
                secondHalf[index + secondHalfStartIndex] = array[index + secondHalfStartIndex];
            }
            index++;
        }
    }

    public static void merge(int[] array, int[] firstHalf, int[] secondHalf) {
        int mergeIndex = 0;
        int firstHalfIndex = 0;
        int secondHalfIndex = 0;
        while (firstHalfIndex < firstHalf.length && secondHalfIndex < secondHalf.length) {
            if (firstHalf[firstHalfIndex] < secondHalf[secondHalfIndex]) {
                array[mergeIndex] = firstHalf[firstHalfIndex];
                firstHalfIndex++;
            } else {
                array[mergeIndex] = secondHalf[secondHalfIndex];
                secondHalfIndex++;
            }
            mergeIndex++;
        }
        if (firstHalfIndex < firstHalf.length) {
            while (firstHalfIndex < firstHalf.length) {
                array[mergeIndex++] = firstHalf[firstHalfIndex++];
            }
        }
        if (secondHalfIndex < secondHalf.length) {
            while (secondHalfIndex < secondHalf.length) {
                array[mergeIndex++] = secondHalf[secondHalfIndex++];
            }
        }
    }

    public static void quickSort(int[] arrayToSort) {
        int pivot = 0;
        for (int i = 1; i < arrayToSort.length; i++) {
            if (arrayToSort[i] < arrayToSort[pivot]) {
                int temp = arrayToSort[i];
                arrayToSort[pivot - 1] = arrayToSort[i];

            }
        }
    }

    public static int partition(int listToSort[], int low, int high) {
        int pivot = listToSort[low];
        int l = low;
        int h = high;
        while(l < h){
            while(listToSort[l] < pivot && l < h){
                l++;
            }
            while(listToSort[h] > pivot){
                h--;
            }
            if(l < h){
                Helpers.swap(listToSort, l, h );
            }
        }
        Helpers.swap(listToSort, low , h );
        return h;
    }


}
