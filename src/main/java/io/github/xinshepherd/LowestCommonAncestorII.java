package io.github.xinshepherd;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 235. 二叉搜索树的最近公共祖先
 *
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *
 * @author Fuxin
 * @since 2020/9/27
 */
public class LowestCommonAncestorII {

    Map<Integer, TreeNode> map = new HashMap<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        int pDepth = findAndMapping(root, p.val, 1);
        int qDepth = findAndMapping(root, q.val, 1);
        while (pDepth > qDepth) {
            p = map.get(p.val);
            pDepth--;
        }
        while (pDepth < qDepth) {
            q = map.get(q.val);
            qDepth--;
        }
        while (q.val != p.val) {
            q = map.get(q.val);
            p = map.get(p.val);
        }
        return q;
    }

    int findAndMapping(TreeNode node, int val, int depth) {
        if (node == null)
            return 0;
        if (node.val == val) {
            return depth;
        }
        if (node.left != null) {
            map.put(node.left.val, node);
            int left = findAndMapping(node.left, val, depth + 1);
            if (left != 0)
                return left;
        }
        if (node.right != null) {
            map.put(node.right.val, node);
        }
        return findAndMapping(node.right, val, depth + 1);
    }


    // 官方题解，用到 BST 的特性
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (p.val < ancestor.val && q.val < ancestor.val) {
                ancestor = ancestor.left;
            } else if (p.val > ancestor.val && q.val > ancestor.val) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return ancestor;
    }

    public static void main(String[] args) {
        LowestCommonAncestorII lowestCommonAncestorII = new LowestCommonAncestorII();
        TreeNode root = TreeNode.of(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5);

        TreeNode node = lowestCommonAncestorII.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8));
        assertThat(node.val).isEqualTo(6);
        node = lowestCommonAncestorII.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4));
        assertThat(node.val).isEqualTo(2);
    }

}
