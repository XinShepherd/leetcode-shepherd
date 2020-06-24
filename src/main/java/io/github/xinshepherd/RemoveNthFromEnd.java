package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 19. 删除链表的倒数第N个节点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * @author Fuxin
 * @since 2020/6/24
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode end = head;
        for (int i = 0; i < n; i++) {
            if (end == null)
                return head;
            end = end.next;
        }
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode current = sentinel;
        while (end != null) {
            current = current.next;
            end = end.next;
        }
        ListNode next = current.next;
        if (next != null) {
            current.next = next.next;
        }
        return sentinel.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.append(2, 3, 4, 5);
        RemoveNthFromEnd end = new RemoveNthFromEnd();
        ListNode node = end.removeNthFromEnd(head, 2);
        assertThat(node.toString()).isEqualTo("1,2,3,5,");
    }

}
