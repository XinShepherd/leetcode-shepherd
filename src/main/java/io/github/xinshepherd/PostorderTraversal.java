package io.github.xinshepherd;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// 145. 二叉树的后序遍历
public class PostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return Collections.emptyList();
        List<Integer> list = new LinkedList<>();
        postorder(root, list);
        return list;
    }

    void postorder(TreeNode node, List<Integer> list) {
        if (node == null)
            return;
        postorder(node.left, list);
        postorder(node.right, list);
        list.add(node.val);
    }

    public static void main(String[] args) {
        PostorderTraversal traversal = new PostorderTraversal();
        System.out.println(traversal.postorderTraversal(TreeNode.demo()));
    }
}
