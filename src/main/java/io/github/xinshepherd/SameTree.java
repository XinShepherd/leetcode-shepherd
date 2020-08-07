package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 100. 相同的树
 * https://leetcode-cn.com/problems/same-tree/
 *
 * @author Fuxin
 * @since 2020/8/7
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        SameTree sameTree = new SameTree();
        assertThat(sameTree.isSameTree(TreeNode.demo(), TreeNode.demo())).isTrue();
        assertThat(sameTree.isSameTree(TreeNode.demo(), TreeNode.demo2())).isFalse();
        assertThat(sameTree.isSameTree(TreeNode.demo(), null)).isFalse();
        assertThat(sameTree.isSameTree(null, null)).isTrue();
    }

}
