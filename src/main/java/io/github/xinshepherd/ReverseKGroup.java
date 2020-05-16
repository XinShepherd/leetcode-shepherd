package io.github.xinshepherd;

import java.util.AbstractMap;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 25. K 个一组翻转链表
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 *
 * @author Fuxin
 * @since 2020/5/16
 */
public class ReverseKGroup {

    private AbstractMap.SimpleEntry<ListNode, ListNode> reverse(ListNode head, ListNode tail) {
        ListNode pre = tail.next;
        ListNode p = head;
        while (pre != tail) {
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return new AbstractMap.SimpleEntry<>(tail, head);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(-1);
        hair.next = head;
        ListNode pre = hair;

        while (head != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }

            ListNode next = tail.next;

            AbstractMap.SimpleEntry<ListNode, ListNode> reverse = reverse(pre.next, tail);

            pre.next = reverse.getKey();
            pre = reverse.getValue();
            pre.next = next;
            head = next;
        }
        return hair.next;
    }

    public static void main(String[] args) {
        ReverseKGroup kGroup = new ReverseKGroup();
        ListNode head = new ListNode(1);
        head.append(2, 3, 4, 5);
        ListNode node = kGroup.reverseKGroup(head, 2);
        assertThat(node.val).isEqualTo(2);
    }
}
