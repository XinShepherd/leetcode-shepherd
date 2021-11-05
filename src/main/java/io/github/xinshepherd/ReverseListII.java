package io.github.xinshepherd;

/**
 * 剑指 Offer II 024. 反转链表
 *
 * https://leetcode-cn.com/problems/UHnkqh/submissions/
 */
public class ReverseListII {

    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode temp = null;
        ListNode current = head;
        ListNode next = head.next;
        while (next != null) {
            current.next = temp;
            temp = current;
            current = next;
            next = next.next;
        }
        current.next = temp;
        return current;
    }

}
