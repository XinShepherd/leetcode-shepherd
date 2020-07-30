package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

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

    // 另一种递归
    public int maxDepth2(TreeNode root) {
        return root == null ? 0 : (Math.max(maxDepth2(root.left), maxDepth2(root.right)) + 1);
    }

    public static void main(String[] args) {
        MaxDepth maxDepth = new MaxDepth();
        assertThat(maxDepth.maxDepth(null)).isEqualTo(0);
        assertThat(maxDepth.maxDepth(TreeNode.demo())).isEqualTo(3);
        assertThat(maxDepth.maxDepth(TreeNode.demo2())).isEqualTo(3);
        assertThat(maxDepth.maxDepth2(null)).isEqualTo(0);
        assertThat(maxDepth.maxDepth2(TreeNode.demo())).isEqualTo(3);
        assertThat(maxDepth.maxDepth2(TreeNode.demo2())).isEqualTo(3);

    }

}
