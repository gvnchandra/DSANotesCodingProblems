package binary_trees;

public class HeightOfBinaryTree {
    static int height(BinaryTreeNode node) {
        if (node == null)
            return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
