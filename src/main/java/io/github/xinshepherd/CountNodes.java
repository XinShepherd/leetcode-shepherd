package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 222. 完全二叉树的节点个数
 *
 * https://leetcode-cn.com/problems/count-complete-tree-nodes/
 *
 * @author Fuxin
 * @since 2020/11/24
 */
public class CountNodes {

    public int countNodes(TreeNode root) {
        return count(root);
    }

    int count(TreeNode node) {
        if (node == null)
            return 0;
        int left = count(node.left);
        int right = count(node.right);
        return left + right + 1;
    }

    public static void main(String[] args) {
        CountNodes countNodes = new CountNodes();
        assertThat(countNodes.countNodes(TreeNode.of(1, 2, 3, 4, 5, 6))).isEqualTo(6);
    }

}
