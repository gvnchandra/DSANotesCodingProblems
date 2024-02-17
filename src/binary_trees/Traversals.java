package binary_trees;

import java.util.LinkedList;
import java.util.Queue;

public class Traversals {
    void printInorder(BinaryTreeNode node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    void preOrder(BinaryTreeNode node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    void postOrder(BinaryTreeNode node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    void levelOrderTraversal(BinaryTreeNode root) {
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            BinaryTreeNode rem = q.poll();
            System.out.print(rem.data + " ");
            if (rem.left != null)
                q.add(rem.left);
            if (rem.right != null)
                q.add(rem.right);
        }
    }
}
