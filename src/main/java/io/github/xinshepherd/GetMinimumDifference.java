package io.github.xinshepherd;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 530. 二叉搜索树的最小绝对差
 *
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 *
 * @author Fuxin
 * @since 2020/10/12
 */
public class GetMinimumDifference {

    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        middle(root, list);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            int diff = list.get(i) - list.get(i - 1);
            min = Math.min(diff, min);
        }
        return min;
    }

    void middle(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        middle(node.left, list);
        list.add(node.val);
        middle(node.right, list);
    }

    int pre = -1;
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference2(TreeNode root) {
        mid(root);
        return min;
    }

    void mid(TreeNode node) {
        if (node == null) {
            return;
        }
        mid(node.left);
        if (pre != -1) {
            min = Math.min(min, node.val - pre);
        }
        pre = node.val;
        mid(node.right);
    }

    public static void main(String[] args) {
        GetMinimumDifference difference = new GetMinimumDifference();
        assertThat(difference.getMinimumDifference(TreeNode.of(1, null, 3, 2)))
                .isEqualTo(1);
        assertThat(difference.getMinimumDifference2(TreeNode.of(1, null, 3, 2)))
                .isEqualTo(1);
    }
}
