package io.github.xinshepherd;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 109. 有序链表转换二叉搜索树
 * https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 *
 * @author Fuxin
 * @since 2020/8/18
 */
public class SortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        if (list.isEmpty())
            return null;
        TreeNode root = new TreeNode();
        build(root, list, 0, list.size() - 1);
        return root;
    }

    private void build(TreeNode node, List<Integer> list, int left, int right) {
        int mid = (left + right) >> 1;
        node.val = list.get(mid);
        if (mid - 1 >= left) {
            node.left = new TreeNode();
            build(node.left, list, left, mid - 1);
        }
        if (mid + 1 <= right) {
            node.right = new TreeNode();
            build(node.right, list, mid + 1, right);
        }
    }

    public static void main(String[] args) {
        SortedListToBST sortedListToBST = new SortedListToBST();
        ListNode node = new ListNode(-1);
        node.append(2, 3, 6, 7);
        TreeNode treeNode = sortedListToBST.sortedListToBST(node);
        assertThat(treeNode.val).isEqualTo(3);
    }

}
