package io.github.xinshepherd;

import java.util.Deque;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 236. 二叉树的最近公共祖先
 *
 * @author Fuxin
 * @since 2020/5/10
 */
public class LowestCommonAncestor {

    TreeNode node;
    int maxDepth = -1;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> pNodes = new LinkedList<>();
        Deque<TreeNode> qNodes = new LinkedList<>();
        boolean includeP = include(root, p, pNodes);
        boolean includeQ = include(root, q, qNodes);
        if (!includeP || !includeQ)
            return null;
        while (!pNodes.isEmpty()) {
            TreeNode pop = pNodes.pop();
            for (TreeNode qNode : qNodes) {
                if (pop.equals(qNode))
                    return pop;
            }
        }
        return null;
    }

    public boolean helper(TreeNode node, TreeNode p, TreeNode q, int dept) {
        boolean match = anotherHelper(node, p) && anotherHelper(node, q);
        if (!match) return false;
        if (dept > maxDepth) {
            maxDepth = dept;
            this.node = node;
        }
        return helper(node.left, p, q, dept + 1)
                || helper(node.right, p, q, dept + 1);
    }

    boolean anotherHelper(TreeNode node, TreeNode p) {
        if (node == null)
            return false;
        if (node.equals(p)) {
            return true;
        }
        return anotherHelper(node.right, p)
                || anotherHelper(node.left, p);
    }


    boolean include(TreeNode node, TreeNode p, Deque<TreeNode> nodes) {
        if (node == null)
            return false;
        if (node.equals(p)) {
            nodes.addLast(node);
            return true;
        }
        boolean included = include(node.left, p, nodes)
                || include(node.right, p, nodes);
        if (included) {
            nodes.addLast(node);
        }
        return included;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.addLeftAndRight(5, 1);
        root.left.addLeftAndRight(6, 2);
        root.right.addLeftAndRight(0, 8);
        root.left.right.addLeftAndRight(7, 4);
        LowestCommonAncestor ancestor = new LowestCommonAncestor();
        assertThat(ancestor.lowestCommonAncestor(root, root.right, root.left)).isEqualTo(root);
        assertThat(ancestor.lowestCommonAncestor(root, root.left, root.left.right.left)).isEqualTo(root.left);

    }

}
