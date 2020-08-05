package io.github.xinshepherd;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 337. 打家劫舍 III
 * https://leetcode-cn.com/problems/house-robber-iii/
 *
 * @author Fuxin
 * @since 2020/8/5
 */
public class Robber {

    Map<TreeNode, Integer> f = new HashMap<>();
    Map<TreeNode, Integer> g = new HashMap<>();

    // 时间复杂度 O(N) 空间复杂度也是 O(N)
    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    private void dfs(TreeNode node) {
        if (node == null)
            return;
        dfs(node.left);
        dfs(node.right);
        f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
        g.put(node, getMax(node.left) + getMax(node.right));
    }

    private Integer getMax(TreeNode node) {
        return Math.max(f.getOrDefault(node, 0), g.getOrDefault(node, 0));
    }

    // 方法二：省去 Hash
    public int robIII(TreeNode root) {
        int[] ans = dfsIII(root);
        return Math.max(ans[0], ans[1]);
    }

    private int[] dfsIII(TreeNode node) {
        if (node == null)
            return new int[]{0, 0};
        int[] leifResults = dfsIII(node.left);
        int[] rightResults = dfsIII(node.right);
        int selected = node.val + leifResults[0] + rightResults[0];
        int unselected = Math.max(leifResults[0], leifResults[1]) + Math.max(rightResults[0], rightResults[1]);
        return new int[]{unselected, selected};
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        Robber robber = new Robber();
        assertThat(robber.rob(root)).isEqualTo(7);
        assertThat(robber.robIII(root)).isEqualTo(7);
    }

}
