package io.github.xinshepherd;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 113. 路径总和 II
 *
 * https://leetcode-cn.com/problems/path-sum-ii/
 *
 * @author Fuxin
 * @since 2020/9/26
 */
public class PathSum {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new LinkedList<>();
        Deque<Integer> queue = new LinkedList<>();
        dfs(root, sum, 0, ans, queue);
        return ans;
    }

    public void dfs(TreeNode node, int sum, int current, List<List<Integer>> ans, Deque<Integer> queue) {
        if (node == null)
            return;
        int temp = current + node.val;

        queue.addLast(node.val);
        // 叶子结点
        if (temp == sum && node.left == null && node.right == null) {
            ans.add(new ArrayList<>(queue));
        }
        dfs(node.left, sum, temp, ans, queue);
        dfs(node.right, sum, temp, ans, queue);
        queue.removeLast();
    }

    public static void main(String[] args) {
        PathSum pathSum = new PathSum();

        TreeNode root = TreeNode.of(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1);
        assertThat(pathSum.pathSum(root, 22))
                .isEqualTo(Arrays.asList(
                        Arrays.asList(5, 4, 11, 2),
                        Arrays.asList(5, 8, 4, 5)
                        )
                );
        assertThat(pathSum.pathSum(TreeNode.of(-2, null, -3), -5))
                .isEqualTo(Arrays.asList(
                        Arrays.asList(-2, -3)
                        )
                );
    }
}
