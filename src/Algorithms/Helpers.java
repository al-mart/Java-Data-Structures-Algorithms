package Algorithms;

public class Helpers {

    public static void print(int[] list) {
        for (int el: list) {
            System.out.print( el + ", ");
        }
        System.out.println();
    }

    public static void swap(int[] array, int firstIndex, int secondIndex){
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    public static void printValue(Object o) {
        System.out.println(o.toString());
    }
}
