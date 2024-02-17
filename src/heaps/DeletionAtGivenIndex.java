package heaps;

public class DeletionAtGivenIndex {
    public static void main(String[] args) {
        int[] arr = {10, 5, 3, 2, 4, 0, 1};
        int n = arr.length;
        n = deleteAtIndex(arr, n, 3);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void heapify(int[] arr, int n, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < n && arr[left] > arr[largest])
            largest = left;
        if (right < n && arr[right] > arr[largest])
            largest = right;
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }

    static int deleteAtIndex(int[] arr, int n, int d) {
        arr[d] = Integer.MAX_VALUE;
        int j = d;
        while (j != 0) {
            int temp = arr[j];
            arr[j] = arr[(j - 1) / 2];
            arr[(j - 1) / 2] = temp;
            j = (j - 1) / 2;
        }
        arr[0] = arr[n - 1];
        n = n - 1;
        heapify(arr, n, 0);
        return n;
    }

}
