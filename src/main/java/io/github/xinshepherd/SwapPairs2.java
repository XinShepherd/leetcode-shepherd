package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 24. 两两交换链表中的节点
 *
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 *
 * @author Fuxin
 * @since 2020/10/13
 */
public class SwapPairs2 {

    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return null;
        ListNode hook = new ListNode(0);
        hook.next = head;
        ListNode first = head;
        ListNode second = head.next;
        ListNode prev = hook;
        while (first != null && second != null) {
            first.next = second.next;
            second.next = first;
            prev.next = second;
            prev = first;
            first = first.next;
            if (first != null) {
                second = first.next;
            }
        }
        return hook.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.newInstance(1, 2, 3, 4);
        SwapPairs2 swapPairs2 = new SwapPairs2();
        ListNode ans = swapPairs2.swapPairs(head);
        assertThat(ans.val).isEqualTo(2);
    }

}
