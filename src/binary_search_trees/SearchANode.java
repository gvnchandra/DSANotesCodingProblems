package binary_search_trees;

public class SearchANode {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(8);
        root.right = new BinaryTreeNode(12);
        root.left.left = new BinaryTreeNode(7);
        root.left.right = new BinaryTreeNode(9);
        root.right.left = new BinaryTreeNode(11);
        root.right.right = new BinaryTreeNode(13);
        System.out.print(search(root, 13));
    }

    static boolean search(BinaryTreeNode node, int val) {
        if (node == null)
            return false;
        if (node.data == val)
            return true;
        if (val < node.data)
            return search(node.left, val);
        return search(node.right, val);
    }
}
