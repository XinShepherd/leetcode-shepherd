package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 142. 环形链表 II
 * <p>
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 *
 * @author Fuxin
 * @since 2020/10/10
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode slow = head, fast = head;
        boolean hasLoop = false;
        do {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                hasLoop = true;
                break;
            }
        } while (fast != null && fast.next != null);
        if (hasLoop) {
            // 先走一个圈的长度
            ListNode first = head;
            do {
                fast = fast.next.next;
                slow = slow.next;
                first = first.next;
            } while (fast != slow);
            ListNode second = head;
            while (second != first) {
                second = second.next;
                first = first.next;
            }
            return second;
        }
        return null;
    }

    public static void main(String[] args) {
        DetectCycle detectCycle = new DetectCycle();
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        head.next = node2;
        node2.next = node0;
        node0.next = node4;
        node4.next = node2;
        ListNode node = detectCycle.detectCycle(head);
        assertThat(node).isEqualTo(node2);
    }

}
