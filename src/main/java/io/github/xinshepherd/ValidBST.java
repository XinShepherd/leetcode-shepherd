package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * 98. 验证二叉搜索树
 * @author Fuxin
 * @since 2020/3/3 8:51
 */
public class ValidBST {

    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    boolean isValid(TreeNode node, Integer upper, Integer lower) {
        if (node == null) {
            return true;
        }
        int val = node.val;
        if (upper != null && val >= upper) return false;
        if (lower != null && val <= lower) return false;
        if (!isValid(node.left, val, lower)) return false;
        if (!isValid(node.right, upper, val)) return false;
        return true;
    }

    public static void main(String[] args) {
        ValidBST validBST = new ValidBST();
        Assertions.assertThat(validBST.isValidBST(TreeNode.demo())).isEqualTo(false);
        Assertions.assertThat(validBST.isValidBST(TreeNode.demo2())).isEqualTo(false);
        Assertions.assertThat(validBST.isValidBST(TreeNode.demo3())).isEqualTo(true);
        Assertions.assertThat(validBST.isValidBST(TreeNode.demo4())).isEqualTo(false);
    }

}
