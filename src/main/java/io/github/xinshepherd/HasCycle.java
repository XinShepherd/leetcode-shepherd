package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * @author Fuxin
 * @since 2020/3/9 11:30
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode current = head, next = current.next.next;
        while (next != null) {
            if (current == next)
                return true;
            current = current.next;
            if (next.next == null) {
                return false;
            }
            next = next.next.next;
        }
        return false;
    }

    public static void main(String[] args) {
        HasCycle hasCycle = new HasCycle();
        ListNode head = new ListNode(3);
        ListNode last = head.append(2, 0, 4);
        last.next = head.next;
        Assertions.assertThat(hasCycle.hasCycle(head)).isEqualTo(true);
        head = new ListNode(1);
        head.append(2).next = head;
        Assertions.assertThat(hasCycle.hasCycle(head)).isEqualTo(true);
        head = new ListNode(1);
        Assertions.assertThat(hasCycle.hasCycle(head)).isEqualTo(false);
    }

}
