package io.github.xinshepherd;

/**
 * 114. 二叉树展开为链表
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 *
 * @author Fuxin
 * @since 2020/5/14
 */
public class Flatten {

    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode right = root.right;
        TreeNode flattened = flatten(root, root.left);
        root.left = null;
        flatten(flattened, right);
    }

    public TreeNode flatten(TreeNode node, TreeNode next) {
        if (next == null)
            return node;
        node.right = next;
        TreeNode right = next.right;
        TreeNode flattened = flatten(next, next.left);
        next.left = null;
        return flatten(flattened, right);
    }

    public static void main(String[] args) {
        Flatten flatten = new Flatten();
        TreeNode demo = TreeNode.demo2();
        flatten.flatten(demo);
        System.out.println(demo);
    }

}
