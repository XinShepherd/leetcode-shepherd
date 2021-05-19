package io.github.xinshepherd;

/**
 *
 * 206. 反转链表
 *
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @author Fuxin
 * @since 2021/5/8
 */
public class ReverseListI {

    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

}
