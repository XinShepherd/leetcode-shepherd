package io.github.xinshepherd;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 103. 二叉树的锯齿形层序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 * @author Fuxin
 * @since 2020/12/22
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return Collections.emptyList();
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        boolean left = false;
        while (!stack.isEmpty()) {
            left = !left;
            Deque<TreeNode> temp = new LinkedList<>();
            List<Integer> result = new ArrayList<>();
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                result.add(node.val);
                if (left) {
                    if (node.left != null) temp.push(node.left);
                    if (node.right != null) temp.push(node.right);
                } else {
                    if (node.right != null) temp.push(node.right);
                    if (node.left != null) temp.push(node.left);
                }
            }
            ans.add(result);
            stack = temp;
        }
        return ans;
    }

    public static void main(String[] args) {
        ZigzagLevelOrder zigzagLevelOrder = new ZigzagLevelOrder();
        assertThat(zigzagLevelOrder.zigzagLevelOrder(TreeNode.of(3, 9, 20, null, null, 15, 7)))
                .isEqualTo(Arrays.asList(
                        Arrays.asList(3),
                        Arrays.asList(20, 9),
                        Arrays.asList(15, 7)
                ));
    }

}
