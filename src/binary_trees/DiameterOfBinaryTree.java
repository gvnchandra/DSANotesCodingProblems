package binary_trees;

public class DiameterOfBinaryTree {
    static int method2(BinaryTreeNode root) {
        int[] diameter = new int[1];
        height(root, diameter);
        return diameter[0];
    }

    static int height(BinaryTreeNode node, int[] ans) {
        if (node == null)
            return 0;
        int lh = height(node.left, ans);
        int rh = height(node.right, ans);
        ans[0] = Math.max(ans[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }

    int method1(BinaryTreeNode root) {
        if (root == null)
            return 0;
        int ldiameter = method1(root.left);
        int rdiameter = method1(root.right);
        int lh = findHeight(root.left);
        int rh = findHeight(root.right);
        return Math.max(lh + rh + 1, Math.max(ldiameter, rdiameter));
    }

    int findHeight(BinaryTreeNode node) {
        if (node == null)
            return 0;
        return 1 + Math.max(findHeight(node.left), findHeight(node.right));
    }
}
