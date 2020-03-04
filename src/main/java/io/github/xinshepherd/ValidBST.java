package io.github.xinshepherd;

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
        System.out.println(validBST.isValidBST(TreeNode.demo()));
        System.out.println(validBST.isValidBST(TreeNode.demo2()));
        System.out.println(validBST.isValidBST(TreeNode.demo3()));
        System.out.println(validBST.isValidBST(TreeNode.demo4()));
    }

}
