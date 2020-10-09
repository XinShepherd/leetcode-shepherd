package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 141. 环形链表
 *
 * https://leetcode-cn.com/problems/linked-list-cycle/
 *
 * @author Fuxin
 * @since 2020/10/9
 */
public class HasCycleII {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode fast = head.next, slow = head;
        while (fast != null) {
            if (fast == slow)
                return true;
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                // 走两步
                fast = fast.next;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        HasCycleII hasCycleII = new HasCycleII();
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        head.next = node2;
        node2.next = node0;
        node0.next = node4;
        node4.next = node2;
        assertThat(hasCycleII.hasCycle(head)).isTrue();
        assertThat(hasCycleII.hasCycle(null)).isFalse();
        assertThat(hasCycleII.hasCycle(new ListNode(3))).isFalse();
    }
}
