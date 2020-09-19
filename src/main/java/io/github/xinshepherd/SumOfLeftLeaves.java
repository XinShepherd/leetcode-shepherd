package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 404. 左叶子之和
 *
 * @author Fuxin
 * @since 2020/9/19
 */
public class SumOfLeftLeaves {

    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        sum = 0;
        dfs(root, false);
        return sum;
    }

    public void dfs(TreeNode node, boolean left) {
        if (node.left == null && node.right == null) {
            if (left) {
                sum += node.val;
            }
            return;
        }
        if (node.left != null) {
            dfs(node.left, true);
        }
        if (node.right != null) {
            dfs(node.right, false);
        }
    }

    public static void main(String[] args) {
        SumOfLeftLeaves sumOfLeftLeaves = new SumOfLeftLeaves();
        assertThat(sumOfLeftLeaves.sumOfLeftLeaves(TreeNode.buildTreeFromArrays(new Integer[]{3, 9, 20, null, null, 15, 7})))
                .isEqualTo(24);
    }


}
