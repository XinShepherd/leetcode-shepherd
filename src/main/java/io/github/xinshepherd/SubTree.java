package io.github.xinshepherd;

import java.util.Deque;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 572. 另一个树的子树
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
 *
 * @author Fuxin
 * @since 2020/5/7
 */
public class SubTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        Deque<TreeNode> nodes = new LinkedList<>();
        findNode(s, t, nodes);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            if (helper(node, t))
                return true;
        }
        return false;
    }

    void findNode(TreeNode s, TreeNode t, Deque<TreeNode> nodes) {
        if (s == null)
            return;
        if (s.val == t.val)
            nodes.addLast(s);
        findNode(s.left, t, nodes);
        findNode(s.right, t, nodes);
    }


    boolean helper(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        if (s.val != t.val)
            return false;
        return helper(s.left, t.left) && helper(s.right, t.right);
    }

    public static void main(String[] args) {
        SubTree subTree = new SubTree();
        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);
        assertThat(subTree.isSubtree(TreeNode.demo(), t)).isEqualTo(false);
        TreeNode s = new TreeNode(3);
        s.left = t;
        s.right = new TreeNode(5);
        assertThat(subTree.isSubtree(s, t)).isEqualTo(true);
    }

}
