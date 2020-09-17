package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 226. 翻转二叉树
 * https://leetcode-cn.com/problems/invert-binary-tree/
 *
 * @author Fuxin
 * @since 2020/9/16
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    void invert(TreeNode node) {
        if (node != null) {
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            invert(node.left);
            invert(node.right);
        }
    }

    public static void main(String[] args) {
        InvertTree invertTree = new InvertTree();
        TreeNode root = TreeNode.buildTreeFromArrays(new Integer[]{4, 2, 7, 1, 3, 6, 9});
        invertTree.invertTree(root);
        assertThat(root.val).isEqualTo(4);
    }
}
