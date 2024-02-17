package heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuildHeap {
    public static void main(String[] args) {
        int[] arr = {4, 10, 3, 5, 1};
        buildHeap(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void heapify(int[] arr, int n, int i) {
        int li = 2 * i + 1;
        int ri = 2 * i + 2;
        int largest = i;
        if (li < n && arr[li] > arr[largest])
            largest = li;
        if (ri < n && arr[ri] > arr[largest])
            largest = ri;
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }

    static void buildHeap(int[] arr) {
        int n = arr.length;
        //starting from the last non-leaf node, we need to heapify
        int startingInd = arr[(n - 2) / 2];
        for (int i = startingInd; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }
}
