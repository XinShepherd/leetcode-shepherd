package io.github.xinshepherd;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// 144. 二叉树的前序遍历
public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return Collections.emptyList();
        List<Integer> list = new LinkedList<>();
//        preorder(root, list);
//        return list;
        return loop(root);
    }

    void preorder(TreeNode node, List<Integer> list) {
        if (node != null) {
            list.add(node.val);
            preorder(node.left, list);
            preorder(node.right, list);
        }
    }

    List<Integer> loop(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> result = new LinkedList<>();
        if (root == null)
            return null;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PreorderTraversal traversal = new PreorderTraversal();
        System.out.println(traversal.preorderTraversal(TreeNode.demo()));
    }
}
