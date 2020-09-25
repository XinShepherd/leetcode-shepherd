package io.github.xinshepherd;

import java.util.Deque;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 *
 * @author Fuxin
 * @since 2020/9/25
 */
public class BuildTreeII {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Deque<Integer> stack = new LinkedList<>();
        for (int i : postorder) {
            stack.push(i);
        }
        return build(inorder, 0, inorder.length, stack);
    }

    public TreeNode build(int[] inorder, int start, int end, Deque<Integer> stack) {
        if (start > end || start >= inorder.length) {
            return null;
        }
        Integer pop = stack.pop();
        TreeNode node = new TreeNode(pop);
        if (start == end) {
            return node;
        }
        int i = start;
        for (; i < end; i++) {
            if (inorder[i] == pop) {
                break;
            }
        }
        node.left = build(inorder, start, i - 1, stack);
        node.right = build(inorder, i + 1, end, stack);
        return node;
    }


    public static void main(String[] args) {
        BuildTreeII buildTreeII = new BuildTreeII();
        TreeNode root = buildTreeII.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        assertThat(root.val).isEqualTo(3);
    }


}
