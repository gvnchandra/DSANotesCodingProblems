package binary_trees;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorOfTwoNodes {
    BinaryTreeNode findLCA(BinaryTreeNode node, int n1, int n2) {
        if (node == null)
            return null;
        if (node.data == n1 || node.data == n2)
            return node;
        BinaryTreeNode left = findLCA(node.left, n1, n2);
        BinaryTreeNode right = findLCA(node.right, n1, n2);
        if (left != null && right != null)
            return node;
        return left != null ? left : right;
    }

    BinaryTreeNode method1(BinaryTreeNode root, int n1, int n2) {
        List<BinaryTreeNode> path1 = new ArrayList<>();
        List<BinaryTreeNode> path2 = new ArrayList<>();

        if (!dfs(root, n1, path1) || !dfs(root, n2, path2))
            return null;
        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i))
                break;
        }
        return path1.get(i - 1);
    }

    static boolean dfs(BinaryTreeNode root, int n1, List<BinaryTreeNode> path) {
        if (root == null)
            return false;
        path.add(root);
        if (dfs(root.left, n1, path) || dfs(root.right, n1, path))
            return true;
        path.remove(path.size() - 1);
        return false;
    }
}
