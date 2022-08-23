package ds_heap;

import java.util.Arrays;

public class MaxHeap {
    public static void main(String[] args) {
        int [] arr = {1, 4, 3, 7, 8, 9, 10};
        buildMaxHeap(arr);
        Arrays.stream(arr).forEach(elem -> System.out.print(elem + ", "));
    }

    private static void buildMaxHeap(int [] arr) {
        for (int i = arr.length/2; i >= 0; i--) {
            maxHeapify(arr, i);
        }
    }

    private static void maxHeapify(int[] arr, int i) {
        int leftIndex = 2*i + 1;
        int rightIndex = 2*i + 2;
        int largest;

        if(leftIndex < arr.length && arr[leftIndex] > arr[i]) {
            largest = leftIndex;
        } else {
            largest = i;
        }
        if(rightIndex < arr.length && arr[rightIndex] > arr[largest]) {
            largest = rightIndex;
        }

        if(largest != i) {
            swap(arr, i, largest);
            maxHeapify(arr, largest);
            System.out.println(arr[i] + " " + arr[largest]);
        }
    }

    private static void swap(int[] arr, int i, int largest) {
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;
    }
}
