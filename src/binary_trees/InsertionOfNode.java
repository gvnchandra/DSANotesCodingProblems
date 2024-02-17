package binary_trees;

import java.util.LinkedList;
import java.util.Queue;

public class InsertionOfNode {
    static void insert(BinaryTreeNode root, int data) {
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            BinaryTreeNode rem = q.poll();
            if (rem.left == null) {
                rem.left = new BinaryTreeNode(data);
                return;
            } else
                q.add(rem.left);
            if (rem.right == null) {
                rem.right = new BinaryTreeNode(data);
                return;
            } else
                q.add(rem.right);
        }
    }
}
