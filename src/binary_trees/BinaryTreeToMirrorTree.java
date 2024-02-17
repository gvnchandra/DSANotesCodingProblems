package binary_trees;

public class BinaryTreeToMirrorTree {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(3);
        root.right = new BinaryTreeNode(2);
        root.right.left = new BinaryTreeNode(5);
        root.right.right = new BinaryTreeNode(4);
        inorder(root);
        mirrorTree(root);
        System.out.println();
        inorder(root);
    }

    static void inorder(BinaryTreeNode node) {
        if (node == null)
            return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    static void mirrorTree(BinaryTreeNode node) {
        if (node == null)
            return;
        mirrorTree(node.left);
        mirrorTree(node.right);
        BinaryTreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
