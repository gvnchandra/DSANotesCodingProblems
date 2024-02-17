package binary_trees;

import java.util.*;

public class TopAndBottomViews {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right.left = new BinaryTreeNode(6);
        root.right.right = new BinaryTreeNode(7);
        root.right.left.right = new BinaryTreeNode(8);
        System.out.println(topView(root));
        System.out.println(bottomView(root));
    }

    static List<Integer> topView(BinaryTreeNode root) {
        //By using horizontal distance method
        List<Integer> ans = new ArrayList<>();
        int hd = 0; //for root
        Map<Integer, List<Integer>> map = new TreeMap<>();
        printTopView(root, hd, map);
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            ans.add(entry.getValue().get(0));
        }
        return ans;
    }

    static void printTopView(BinaryTreeNode root, int hd,
                             Map<Integer, List<Integer>> treeMap) {
        if (root == null)
            return;
        List<Integer> li = treeMap.getOrDefault(hd, new ArrayList<>());
        li.add(root.data);
        treeMap.put(hd, li);
        printTopView(root.left, hd - 1, treeMap);
        printTopView(root.right, hd + 1, treeMap);
    }

    static List<Integer> bottomView(BinaryTreeNode root) {
        //By using horizontal distance method
        List<Integer> ans = new ArrayList<>();
        int hd = 0; //for root
        Map<Integer, List<Integer>> map = new TreeMap<>();
        printBottomView(root, hd, map);
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            ans.add(entry.getValue().get(entry.getValue().size() - 1));
        }
        return ans;
    }

    static void printBottomView(BinaryTreeNode root, int hd,
                                Map<Integer, List<Integer>> treeMap) {
        if (root == null)
            return;
        List<Integer> li = treeMap.getOrDefault(hd, new ArrayList<>());
        li.add(root.data);
        treeMap.put(hd, li);
        printBottomView(root.left, hd - 1, treeMap);
        printBottomView(root.right, hd + 1, treeMap);
    }
}
