package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * 129. 求根到叶子节点数字之和
 *
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 *
 * @author Fuxin
 * @since 2020/10/29
 */
public class SumNumbers {

    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        sum = 0;
        StringBuilder sb = new StringBuilder();
        sumNode(root, sb);
        return sum;
    }

    private void sumNode(TreeNode node, StringBuilder sb) {
        if (node == null)
            return;
        sb.append(node.val);
        if (node.left != null) {
            sumNode(node.left, sb);
        }
        if (node.right != null)
            sumNode(node.right, sb);

        if (node.left == null && node.right == null) {
            sum += Integer.parseInt(sb.toString());
        }
        sb.deleteCharAt(sb.length() - 1);
    }

    public int sumNumbers2(TreeNode root) {
        sum = 0;
        sumNode(root, 0);
        return sum;
    }

    private void sumNode(TreeNode node, int num) {
        if (node == null)
            return;
        num = num * 10 + node.val;
        if (node.left != null) {
            sumNode(node.left, num);
        }
        if (node.right != null) {
            sumNode(node.right, num);
        }
        if (node.left == null && node.right == null) {
            sum += num;
        }
    }


    public static void main(String[] args) {
        SumNumbers sumNumbers = new SumNumbers();
        Assertions.assertThat(sumNumbers.sumNumbers(TreeNode.of(1, 2, 3)))
                .isEqualTo(25);
        Assertions.assertThat(sumNumbers.sumNumbers(TreeNode.of(4, 9, 0, 5, 1)))
                .isEqualTo(1026);
        Assertions.assertThat(sumNumbers.sumNumbers2(TreeNode.of(1, 2, 3)))
                .isEqualTo(25);
        Assertions.assertThat(sumNumbers.sumNumbers2(TreeNode.of(4, 9, 0, 5, 1)))
                .isEqualTo(1026);
    }

}
