package io.github.xinshepherd;

/**
 * 148. 排序链表
 * https://leetcode-cn.com/problems/sort-list/
 *
 * @author Fuxin
 * @since 2020/5/1
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head.next;
        while (fast!= null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode half = slow.next;
        slow.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(half);
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
        SortList sortList = new SortList();
        ListNode head = new ListNode(4);
        head.append(2, 1, 3);
        System.out.println(sortList.sortList(head));
        head = new ListNode(-1);
        head.append(5, 3, 4, 0);
        System.out.println(sortList.sortList(head));
    }
}
