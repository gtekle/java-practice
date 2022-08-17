package algo_sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int [] arr = {5, 3, 8, 4, 6};
        Arrays.stream(selectionSort(arr)).forEach(elem -> System.out.print(elem + ", "));
    }

    private static int[] selectionSort(int[] arr) {
        int count = 0;

        for(int i=0; i<arr.length-1; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[j] < arr[i]) {
                    swapSmallest(arr, i, j);
                }
                count++;
            }
        }
        System.out.println("Total Iterations: " + count);
        return arr;
    }

    private static void swapSmallest(int[] arr, int i, int j) {
        int temp;
        temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
