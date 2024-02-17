package binary_search_trees;

public class DeletionOfANode {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(8);
        root.right = new BinaryTreeNode(12);
        root.left.left = new BinaryTreeNode(7);
        root.left.right = new BinaryTreeNode(9);
        root.right.left = new BinaryTreeNode(11);
        root.right.right = new BinaryTreeNode(13);
        preorderTraversal(root);
        root = delete(root, 9);
        System.out.println();
        preorderTraversal(root);
    }

    static void preorderTraversal(BinaryTreeNode node) {
        if (node == null)
            return;
        preorderTraversal(node.left);
        System.out.print(node.data + " ");
        preorderTraversal(node.right);
    }

    static BinaryTreeNode delete(BinaryTreeNode node, int val) {
        if (node == null)
            return null;
        if (val < node.data) {
            node.left = delete(node.left, val);
        } else if (val > node.data) {
            node.right = delete(node.right, val);
        } else {
            if (node.left == null)
                return node.right;
            if (node.right == null)
                return node.left;
            node.data = minValue(node.right);
            node.right = delete(node.right, node.data);
        }
        return node;
    }

    static int minValue(BinaryTreeNode node) {
        int min = node.data;
        while (node.left != null) {
            min = node.left.data;
            node = node.left;
        }
        return min;
    }
}
