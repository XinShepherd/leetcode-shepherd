package io.github.xinshepherd;


public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    public static TreeNode demo() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        return root;
    }

    public static TreeNode demo2() {
        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(20);
        root.left = new TreeNode(9);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        return root;
    }

    // BST
    public static TreeNode demo3() {
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left = new TreeNode(1);
        return root;
    }

    public static TreeNode demo4() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        return root;
    }

    public static TreeNode demo5() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        return root;
    }

    // 左子树深度大于右子树
    public static TreeNode demo6() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        return root;
    }
}
