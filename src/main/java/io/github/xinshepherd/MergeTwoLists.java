package io.github.xinshepherd;

/**
 * 21. 合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * @author Fuxin
 * @since 2020/5/1
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode hook = new ListNode(0), temp = hook;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                temp.next = l2;
                l2 = l2.next;
            } else {
                temp.next = l1;
                l1 = l1.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null ? l2 : l1;
        return hook.next;
    }

    public static void main(String[] args) {
        MergeTwoLists twoLists = new MergeTwoLists();
        ListNode l1 = new ListNode(1);
        l1.append(2, 4);
        ListNode l2 = new ListNode(2);
        l2.append(3, 4);
        System.out.println(twoLists.mergeTwoLists(l1, l2));
    }

}
