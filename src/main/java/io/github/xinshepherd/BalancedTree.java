package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 110. 平衡二叉树
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 *
 * @author Fuxin
 * @since 2020/8/17
 */
public class BalancedTree {

    public boolean isBalanced(TreeNode root) {
        return dept(root) != -1;
    }

    private int dept(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dept(node.left);
        if (left == -1)
            return left;
        int right = dept((node.right));
        if (right == -1)
            return right;
        if (Math.abs(left - right) >= 2) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        BalancedTree balancedTree = new BalancedTree();
        assertThat(balancedTree.isBalanced(TreeNode.demo())).isFalse();
        assertThat(balancedTree.isBalanced(TreeNode.demo2())).isTrue();
    }

}
