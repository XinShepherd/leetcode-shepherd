package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 112. 路径总和
 * https://leetcode-cn.com/problems/path-sum/
 *
 * @author Fuxin
 * @since 2020/7/7
 */
public class HasPathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        return dp(root, sum, 0);
    }

    public boolean dp(TreeNode node, int sum, int current) {
        if (node != null) {
            current += node.val;
            if (node.left == null && node.right == null) {
                if (current == sum)
                    return true;
            }
            if (dp(node.left, sum, current))
                return true;
            return dp(node.right, sum, current);
        }
        return false;
    }

    public static void main(String[] args) {
        HasPathSum hasPathSum = new HasPathSum();
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(8);
        node.left.left = new TreeNode(11);
        node.right.left = new TreeNode(13);
        node.right.right = new TreeNode(4);
        node.right.right.right = new TreeNode(1);
        node.left.left.left = new TreeNode(7);
        node.left.left.right = new TreeNode(2);
        assertThat(hasPathSum.hasPathSum(node, 22)).isTrue();
    }

}
