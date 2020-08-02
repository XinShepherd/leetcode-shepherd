package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

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

    public void flatten2(TreeNode root) {
        if (root == null) return;
        flat(root, root.left, root.right);
    }

    private TreeNode flat(TreeNode node, TreeNode left, TreeNode right) {
        if (left != null) {
            node.left = null;
            node.right = left;
            node = flat(left, left.left, left.right);
        }
        if (right != null) {
            node.right = right;
            node = flat(right, right.left, right.right);
        }
        return node;
    }

    public static void main(String[] args) {
        Flatten flatten = new Flatten();
        TreeNode demo = TreeNode.demo2();
        flatten.flatten(demo);
        System.out.println(demo);
        TreeNode demo2 = TreeNode.demo2();
        flatten.flatten2(demo2);
        assertThat(demo2.val).isEqualTo(3);
    }

}
