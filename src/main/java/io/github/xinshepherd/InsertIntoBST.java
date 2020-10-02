package io.github.xinshepherd;

/**
 * 701. 二叉搜索树中的插入操作
 *
 * https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 *
 * @author Fuxin
 * @since 2020/9/30
 */
public class InsertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        insert(root, val);
        return root;
    }

    boolean insert(TreeNode node, int val) {
        if (val < node.val) {
            if (node.left == null) {
                node.left = new TreeNode(val);
                return true;
            } else {
                return insert(node.left, val);
            }
        } else {
            if (node.right == null) {
                node.right = new TreeNode(val);
                return true;
            } else {
                return insert(node.right, val);
            }
        }
    }

    public static void main(String[] args) {
        InsertIntoBST insertIntoBST = new InsertIntoBST();
        TreeNode root = TreeNode.of(4, 2, 7, 1, 3);
        TreeNode node = insertIntoBST.insertIntoBST(root, 5);

    }


}
