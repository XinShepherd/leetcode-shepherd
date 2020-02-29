package io.github.xinshepherd;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// 94. 二叉树的中序遍历
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return Collections.emptyList();
        List<Integer> list = new LinkedList<>();
        loop(root, list);
        return list;
    }

    void inorder(TreeNode node, List<Integer> list) {
        if (node == null)
            return;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }

    void loop(TreeNode root, List<Integer> list) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            list.add(node.val);
            node = node.right;
        }

    }

    public static void main(String[] args) {
        InorderTraversal inorderTraversal = new InorderTraversal();
        System.out.println(inorderTraversal.inorderTraversal(TreeNode.demo()));

    }

}
