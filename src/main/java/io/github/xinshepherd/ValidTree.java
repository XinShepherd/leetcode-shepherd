package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 98. 验证二叉搜索树 （时隔两个月独立完成）
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 *
 * @author Fuxin
 * @since 2020/5/5
 */
public class ValidTree {

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    boolean helper(TreeNode node, Integer upper, Integer lower) {
        if (node == null) {
            return true;
        }

        if (upper != null && node.val >= upper) {
            return false;
        }
        if (lower != null && node.val <= lower) {
            return false;
        }
        return helper(node.left, node.val, lower)
                && helper(node.right, upper, node.val);
    }

    public static void main(String[] args) {
        ValidTree validTree = new ValidTree();
        assertThat(validTree.isValidBST(TreeNode.demo())).isEqualTo(false);
        assertThat(validTree.isValidBST(TreeNode.demo2())).isEqualTo(false);
        assertThat(validTree.isValidBST(TreeNode.demo3())).isEqualTo(true);
        assertThat(validTree.isValidBST(TreeNode.demo6())).isEqualTo(false);
    }

}
