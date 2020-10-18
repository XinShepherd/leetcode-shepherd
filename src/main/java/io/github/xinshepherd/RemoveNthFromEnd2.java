package io.github.xinshepherd;

/**
 * 19. 删除链表的倒数第N个节点
 *
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthFromEnd2 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode hook = new ListNode(0);
        hook.next = head;
        ListNode first = hook;
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        ListNode second = hook;
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return hook.next;
    }

}
