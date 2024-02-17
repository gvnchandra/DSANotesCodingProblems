package binary_trees;

import java.util.LinkedList;
import java.util.Queue;

public class DeletionOfNode {
    static void delete(BinaryTreeNode root, int data) {
        BinaryTreeNode temp = null, keyNode = null;
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            temp = q.poll();
            if (temp.data == data)
                keyNode = temp;
            if (temp.left != null)
                q.add(temp.left);
            if (temp.right != null)
                q.add(temp.right);
        }

        if (keyNode == null) {
            System.out.println("Node with " + data + " doesn't exist in binary tree");
        } else {
            keyNode.data = temp.data;
            q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                BinaryTreeNode rem = q.poll();
                if (rem.right != null) {
                    if (rem.right == temp) {
                        rem.right = null;
                        return;
                    } else
                        q.add(rem.right);
                }
                if (rem.left != null) {
                    if (rem.left == temp) {
                        rem.left = null;
                        return;
                    } else
                        q.add(rem.left);
                }
            }
        }
    }
}
