package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 968. 监控二叉树
 * https://leetcode-cn.com/problems/binary-tree-cameras/
 *
 * @author Fuxin
 * @since 2020/9/22
 */
public class MinCameraCover {

    static final int HALF = Integer.MAX_VALUE >> 1;

    public int minCameraCover(TreeNode root) {
        int[] array = dfs(root);
        return array[1];
    }

    int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{HALF, 0, 0};
        }
        int[] leftArray = dfs(root.left);
        int[] rightArray = dfs(root.right);
        int[] result = new int[3];
        result[0] = leftArray[2] + rightArray[2] + 1;
        result[1] = Math.min(result[0], Math.min(leftArray[0] + rightArray[1], leftArray[1] + rightArray[0]));
        result[2] = Math.min(result[0], leftArray[1] + rightArray[1]);
        return result;
    }

    public static void main(String[] args) {
        MinCameraCover minCameraCover = new MinCameraCover();
        TreeNode root = TreeNode.buildTreeFromArrays(new Integer[]{0, 0, null, 0, 0});
        assertThat(minCameraCover.minCameraCover(root)).isEqualTo(1);
    }

}
