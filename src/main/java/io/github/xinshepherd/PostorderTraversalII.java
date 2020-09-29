package io.github.xinshepherd;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 145. 二叉树的后序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 *
 * @author Fuxin
 * @since 2020/9/29
 */
public class PostorderTraversalII {

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null)
            return Collections.emptyList();
        return loop(root);
    }

    List<Integer> loop(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> ans = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.addFirst(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        PostorderTraversalII postorderTraversalII = new PostorderTraversalII();
        assertThat(postorderTraversalII.postorderTraversal(TreeNode.of(1, null, 2, 3)))
                .isEqualTo(Arrays.asList(3, 2, 1));
        assertThat(postorderTraversalII.postorderTraversal(TreeNode.of()))
                .isEqualTo(Collections.emptyList());
    }

}
