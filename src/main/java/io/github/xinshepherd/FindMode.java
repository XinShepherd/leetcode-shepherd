package io.github.xinshepherd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 501. 二叉搜索树中的众数
 *
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 *
 * @author Fuxin
 * @since 2020/9/24
 */
public class FindMode {

    Map<Integer, Integer> map = new HashMap<>();

    public int[] findMode(TreeNode root) {
        count(root);
        int maxLen = 0;
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxLen) {
                result.clear();
                result.add(entry.getKey());
                maxLen = entry.getValue();
            } else if (entry.getValue() == maxLen) {
                result.add(entry.getKey());
            }
        }
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }

    void count(TreeNode node) {
        if (node == null)
            return;
        int count = map.getOrDefault(node.val, 0);
        map.put(node.val, ++count);
        count(node.left);
        count(node.right);
    }

    public static void main(String[] args) {
        FindMode findMode = new FindMode();
        TreeNode root = TreeNode.buildTreeFromArrays(new Integer[]{1, null, 2, null, null, 2, null});
        int[] ans = findMode.findMode(root);
        assertThat(ans).isEqualTo(new int[]{2});
    }
}
