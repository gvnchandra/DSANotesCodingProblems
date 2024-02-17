package heaps;

import binary_search_trees.BinaryTreeNode;

public class RootDeletionInHeap {
    public static void main(String[] args) {
        int[] arr = {10, 5, 3, 2, 4};
        int n = arr.length;
        n = deleteRoot(arr, n);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void heapify(int[] arr, int n, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int t = arr[i];
            arr[i] = arr[largest];
            arr[largest] = t;
            heapify(arr, n, largest);
        }
    }

    static int deleteRoot(int[] arr, int n) {
        //replacing the root with last node in min Heap
        //on doing this, it may or may not satisfy the min heap property
        arr[0] = arr[n - 1];
        n = n - 1;
        heapify(arr, n, 0);
        return n;
    }
}
