package io.github.xinshepherd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 257. 二叉树的所有路径
 * https://leetcode-cn.com/problems/binary-tree-paths/
 *
 * @author Fuxin
 * @since 2020/9/4
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null)
            return Collections.emptyList();
        List<String> ans = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        path.append(root.val);
        dfs(root, ans, path);
        return ans;
    }

    void dfs(TreeNode node, List<String> ans, StringBuilder path) {
        if (node.left == null && node.right == null) {
            ans.add(path.toString());
            return;
        }
        if (node.left != null) {
            path.append("->").append(node.left.val);
            dfs(node.left, ans, path);
            path.delete(path.lastIndexOf("->"), path.length());
        }
        if (node.right != null) {
            path.append("->").append(node.right.val);
            dfs(node.right, ans, path);
            path.delete(path.lastIndexOf("->"), path.length());
        }
    }

    public static void main(String[] args) {
        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
        List<String> strings = binaryTreePaths.binaryTreePaths(TreeNode.demo());
        assertThat(strings).isEqualTo(Arrays.asList("1->2->3"));
        assertThat(binaryTreePaths.binaryTreePaths(TreeNode.demo2()))
                .isEqualTo(Arrays.asList("3->9", "3->20->15", "3->20->7"));
    }

}
