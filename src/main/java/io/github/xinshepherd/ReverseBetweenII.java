package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 92. 反转链表 II
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 *
 * @author Fuxin
 * @since 2020/5/3
 */
public class ReverseBetweenII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        int i = 1;
        ListNode hook = new ListNode(0);
        hook.next = head;
        ListNode start = hook;
        while (i < m) {
            start = hook.next;
            hook.next = hook.next.next;
            i++;
        }
        ListNode current = hook.next, next = current.next;
        current.next = null;
        while (i < n && next != null) {
            ListNode temp = next.next;
            next.next = current;
            current = next;
            next = temp;
            i++;
        }
        hook.next.next = next;
        if (m == 1)
            return current;
        start.next = current;
        return head;
    }

    public static void main(String[] args) {
        ReverseBetweenII betweenII = new ReverseBetweenII();
        ListNode head = new ListNode(1);
        head.append(2, 3, 4, 5);
        assertThat(betweenII.reverseBetween(head, 2, 4).toString()).isEqualTo("1,4,3,2,5,");
        head = new ListNode(1);
        head.append(2, 3, 4, 5);
        assertThat(betweenII.reverseBetween(head, 2, 5).toString()).isEqualTo( "1,5,4,3,2,");
        head = new ListNode(1);
        head.append(2, 3, 4, 5);
        assertThat(betweenII.reverseBetween(head, 1, 5).toString()).isEqualTo( "5,4,3,2,1,");
    }

}
