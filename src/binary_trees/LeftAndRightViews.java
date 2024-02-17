package binary_trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftAndRightViews {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right.left = new BinaryTreeNode(6);
        root.right.right = new BinaryTreeNode(7);
        root.right.left.right = new BinaryTreeNode(8);
        System.out.println(rightView(root));
        System.out.println(leftView(root));
    }

    static List<Integer> leftView(BinaryTreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 1; i <= n; i++) {
                BinaryTreeNode rem = q.poll();
                if (i == 1)
                    ans.add(rem.data);
                if (rem.left != null)
                    q.add(rem.left);
                if (rem.right != null)
                    q.add(rem.right);
            }
        }
        return ans;
    }

    static List<Integer> rightView(BinaryTreeNode root) {
        //By using reverse preorder traversal
        List<Integer> rightView = new ArrayList<>();
        int n = height(root);
        boolean[] visited = new boolean[n];
        reversePreOrder(root, visited, 0, rightView);
        return rightView;
    }

    static boolean reversePreOrder(BinaryTreeNode root, boolean[] vis,
                                   int level, List<Integer> rightView) {
        if (root == null)
            return false;
        if (!vis[level]) {
            vis[level] = true;
            rightView.add(root.data);
        }
        if (reversePreOrder(root.right, vis, level + 1, rightView))
            return true;
        return reversePreOrder(root.left, vis, level + 1, rightView);
    }

    static int height(BinaryTreeNode node) {
        if (node == null)
            return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

}
