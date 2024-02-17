package binary_search_trees;

public class InsertionOfANode {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(8);
        root.right = new BinaryTreeNode(12);
        root.left.left = new BinaryTreeNode(7);
        root.left.right = new BinaryTreeNode(9);
        root.right.left = new BinaryTreeNode(11);
        root.right.right = new BinaryTreeNode(13);
        preorderTraversal(root);
        root = insert(root, 1);
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

    static BinaryTreeNode insert(BinaryTreeNode node, int val) {
        if (node == null) {
            node = new BinaryTreeNode(val);
            return node;
        }
        if (val < node.data) {
            node.left = insert(node.left, val);
        } else if (val > node.data) {
            node.right = insert(node.right, val);
        }
        return node;
    }
}
