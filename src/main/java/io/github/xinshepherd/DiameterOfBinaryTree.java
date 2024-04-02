package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

import static io.github.xinshepherd.TreeNode.demo2;
import static io.github.xinshepherd.TreeNode.demo3;

/**
 * 543. 二叉树的直径
 *
 * @author Fuxin
 * @since 2020/3/10 8:52
 */
public class DiameterOfBinaryTree {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        helper(root);
        return max;
    }

    int helper(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int left = helper(node.right) + 1;
        int right = helper(node.left) + 1;
        if (right + left > max) {
            max = right + left;
        }
        return Math.max(right, left);
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
        Assertions.assertThat(diameterOfBinaryTree.diameterOfBinaryTree(demo2())).isEqualTo(3);
        Assertions.assertThat(diameterOfBinaryTree.diameterOfBinaryTree(demo3())).isEqualTo(2);
    }

}
