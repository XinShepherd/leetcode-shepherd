package io.github.xinshepherd;

import java.util.Deque;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * @author Fuxin
 * @since 2020/5/22
 */
public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i : preorder) {
            deque.addLast(i);
        }
        return build(inorder, 0, inorder.length, deque);
    }

    TreeNode build(int[] inorder, int start, int end, Deque<Integer> deque) {
        if (start > end || start >= inorder.length)
            return null;
        Integer in = deque.removeFirst();
        if (start == end) {
            return new TreeNode(in);
        }
        TreeNode node = new TreeNode(in);
        int i = start;
        for (; i < end; i++) {
            if (inorder[i] == in) {
                break;
            }
        }
        node.left = build(inorder, start, i - 1, deque);
        node.right = build(inorder, i + 1, end, deque);
        return node;
    }

    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        TreeNode node = buildTree.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        assertThat(node.val).isEqualTo(3);
    }

}
