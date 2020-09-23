package io.github.xinshepherd;

/**
 * 617. 合并二叉树
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 *
 * @author Fuxin
 * @since 2020/9/23
 */
public class MergeTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode hook = new TreeNode();
        merge(hook, t1, t2, true);
        return hook.left;
    }

    void merge(TreeNode parent, TreeNode t1, TreeNode t2, boolean left) {
        if (t1 == null && t2 == null)
            return;
        if (t1 == null || t2 == null) { // 不需要合并了，直接返回
            TreeNode node = t1 == null ? t2 : t1;
            if (left)
                parent.left = node;
            else
                parent.right = node;
            return;
        }
        t1.val += t2.val;
        if (left)
            parent.left = t1;
        else
            parent.right = t1;
        merge(t1, t1.left, t2.left, true);
        merge(t1, t1.right, t2.right, false);
    }

    public static void main(String[] args) {
        MergeTrees mergeTrees = new MergeTrees();
        TreeNode t1 = TreeNode.buildTreeFromArrays(new Integer[]{1, 3, 2, 5, null, null, null});
        TreeNode t2 = TreeNode.buildTreeFromArrays(new Integer[]{2, 1, 3, null, 4, null, 7});
        TreeNode node = mergeTrees.mergeTrees(t1, t2);

    }

}
