package algo_sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int [] arr = {5, 3, 8, 4, 6};
        Arrays.stream(insertionSort(arr)).forEach(elem -> System.out.print(elem + ", "));
    }

    private static int[] insertionSort(int[] arr) {
        int lastIndex = 0;

        for(int i=1; i<arr.length; i++){
            int key = arr[i];
            for(int j=lastIndex; j>=0; j--){
                if(arr[j] > key) {
                    arr[j+1] = arr[j];
                } else {
                    arr[j+1] = key;
                    break;
                }

                if(j == 0) {
                    arr[j] = key;
                }
                Arrays.stream(arr).forEach(elem -> System.out.print(elem + ", "));
                System.out.println();
            }
            lastIndex++;
        }
        return arr;
    }
}
