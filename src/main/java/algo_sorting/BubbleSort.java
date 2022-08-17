package algo_sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int [] arr = {5, 3, 8, 4, 6};
        Arrays.stream(bubbleSort(arr)).forEach(System.out::print);
    }

    private static int [] bubbleSort(int [] arr) {
        boolean isSwapped = true;
        int count = 0;

        while (isSwapped) {
            isSwapped = false;

            for(int i=0; i<arr.length - 1; i++) {
                if(arr[i] > arr[i+1]) {
                    swap(arr, i);
                    isSwapped = true;
                }
                count++;
            }
        }
        System.out.println("Total Iterations: " + count);
        return arr;
    }

    private static void swap(int[] arr, int i) {
        int temp;
        temp = arr[i +1];
        arr[i +1] = arr[i];
        arr[i] = temp;
    }
}
