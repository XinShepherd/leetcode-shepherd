package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 108. 将有序数组转换为二叉搜索树
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 * @author Fuxin
 * @since 2020/5/18
 */
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        int length = nums.length;
        if (length == 0) return null;
        int mid = length >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        arrayToBST(root, true, 0, mid - 1, nums);
        arrayToBST(root, false, mid + 1, length - 1, nums);
        return root;
    }

    void arrayToBST(TreeNode parent, boolean left, int start, int end, int[] nums) {
        if (start > end)
            return;
        int mid = (start + end + 1) >> 1;
        TreeNode node = new TreeNode(nums[mid]);
        if (left)
            parent.left = node;
        else
            parent.right = node;
        arrayToBST(node, true, start, mid - 1, nums);
        arrayToBST(node, false, mid + 1, end, nums);
    }

    public static void main(String[] args) {
        SortedArrayToBST array = new SortedArrayToBST();
        TreeNode root = array.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        assertThat(root.val).isEqualTo(0);
    }

}
