package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 199. 二叉树的右视图
 *
 * @author Fuxin
 * @since 2020/4/22
 */
public class RightSideView {

    private int depth = 0;

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        depth = 0;
        helper(ans, root, 1);
        return ans;
    }

    void helper(List<Integer> ans, TreeNode node, int treeDepth) {
        if (treeDepth > depth) {
            ans.add(node.val);
            depth = treeDepth;
        }
        int dep = treeDepth + 1;
        if (node.right != null) {
            helper(ans, node.right, dep);
        }
        if (node.left != null) {
            helper(ans, node.left, dep);
        }
    }

    public static void main(String[] args) {
        RightSideView sideView = new RightSideView();
        Assertions.assertThat(sideView.rightSideView(null)).isEqualTo(Collections.emptyList());
        Assertions.assertThat(sideView.rightSideView(TreeNode.demo2())).isEqualTo(Arrays.asList(3, 20, 7));
        Assertions.assertThat(sideView.rightSideView(TreeNode.demo5())).isEqualTo(Arrays.asList(1, 3, 4));
        Assertions.assertThat(sideView.rightSideView(TreeNode.demo6())).isEqualTo(Arrays.asList(1, 3, 5));
    }

}
