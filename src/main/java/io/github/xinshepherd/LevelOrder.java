package io.github.xinshepherd;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 102. 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 *
 * @author Fuxin
 * @since 2020/5/13
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            Deque<TreeNode> temp = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.pop();
                level.add(node.val);
                if (node.left != null) {
                    temp.addLast(node.left);
                }
                if (node.right != null) {
                    temp.addLast(node.right);
                }
            }
            if (!level.isEmpty()) {
                ans.add(level);
            }
            queue = temp;
        }
        return ans;
    }

    public static void main(String[] args) {
        LevelOrder levelOrder = new LevelOrder();
        assertThat(levelOrder.levelOrder(TreeNode.demo())).isEqualTo(
                Arrays.asList(Arrays.asList(1), Arrays.asList(2), Arrays.asList(3))
        );
    }

}
