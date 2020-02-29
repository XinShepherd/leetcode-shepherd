package io.github.xinshepherd;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// 94. 二叉树的中序遍历
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return Collections.emptyList();
        List<Integer> list = new LinkedList<>();
        inorder(root, list);
        return list;
    }

    void inorder(TreeNode node, List<Integer> list) {
        if (node == null)
            return;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }

    public static void main(String[] args) {
        InorderTraversal inorderTraversal = new InorderTraversal();
        System.out.println(inorderTraversal.inorderTraversal(TreeNode.demo()));

    }

}
