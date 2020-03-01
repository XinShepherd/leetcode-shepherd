package io.github.xinshepherd;

// 104. 二叉树的最大深度
public class MaxDepth {

    private int depth = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        this.depth = 0;
        count(root, 1);
        return depth;
    }

    void count(TreeNode node, int depth) {
        if (node.right == null && node.left == null) {
            this.depth = Math.max(this.depth, depth);
            return;
        }
        if (node.right != null) {
            count(node.right, depth + 1);
        }
        if (node.left != null) {
            count(node.left, depth + 1);
        }
    }

    public static void main(String[] args) {
        MaxDepth maxDepth = new MaxDepth();
        System.out.println(maxDepth.maxDepth(null));
        System.out.println(maxDepth.maxDepth(TreeNode.demo()));
        System.out.println(maxDepth.maxDepth(TreeNode.demo2()));
    }

}
