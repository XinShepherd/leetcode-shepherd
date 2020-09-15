package io.github.xinshepherd;

import static io.github.xinshepherd.TreeNode.buildTreeFromArrays;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * 101. 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 *
 * @author Fuxin
 * @since 2020/9/15
 */
public class SymmetricTree {

    boolean symmetric = true;

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        this.symmetric = true;
        find(root.left, root.right);
        return symmetric;
    }

    void find(TreeNode left, TreeNode right) {
        if (!symmetric)
            return;
        if (left == null && right == null)
            return;
        if (left != null && right != null && left.val == right.val) {
            find(left.right, right.left);
            find(left.left, right.right);
        } else {
            symmetric = false;
        }
    }

    public static void main(String[] args) {
        SymmetricTree symmetricTree = new SymmetricTree();
        TreeNode treeNode = buildTreeFromArrays(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        assertThat(symmetricTree.isSymmetric(treeNode)).isTrue();
        assertThat(symmetricTree.isSymmetric(buildTreeFromArrays(new Integer[]{1, 2, 2, null, 3, null, 3}))).isFalse();
    }

}
