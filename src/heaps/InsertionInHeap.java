package heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertionInHeap {
    public static void main(String[] args) {
        List<Integer> li = new ArrayList<>(Arrays.asList(10, 5, 3, 2, 4, 0, 1));
        int ele = 9;
        insert(li, ele);
        System.out.println(li);
    }

    static void insert(List<Integer> li, int ele) {
        li.add(ele);
        heapify(li, li.size() - 1);
    }

    static void heapify(List<Integer> li, int i) {
        int parent = (i - 1) / 2;
        if (parent >= 0) {
            if (li.get(i) > li.get(parent)) {
                int temp = li.get(i);
                li.set(i, li.get(parent));
                li.set(parent, temp);
                heapify(li, parent);
            }
        }
    }
}
