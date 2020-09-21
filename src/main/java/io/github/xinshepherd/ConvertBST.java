package io.github.xinshepherd;

/**
 * 538. 把二叉搜索树转换为累加树
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 *
 * @author Fuxin
 * @since 2020/9/21
 */
public class ConvertBST {

    int current = 0;

    public TreeNode convertBST(TreeNode root) {
        current = 0;
        dfs(root);
        return root;
    }

    void dfs(TreeNode node) {
        if (node == null)
            return;
        dfs(node.right);
        current += node.val;
        node.val = current;
        dfs(node.left);
    }

    public static void main(String[] args) {
        ConvertBST convertBST = new ConvertBST();
        TreeNode root = TreeNode.buildTreeFromArrays(new Integer[]{5, 2, 13});
        convertBST.convertBST(root);
    }

}
