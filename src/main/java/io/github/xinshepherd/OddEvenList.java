package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 328. 奇偶链表
 *
 * https://leetcode-cn.com/problems/odd-even-linked-list/
 *
 * @author Fuxin
 * @since 2020/11/13
 */
public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;
        ListNode oddHook = new ListNode(-1);
        ListNode evenHook = new ListNode(-1);
        ListNode oddNode = oddHook, evenNode = evenHook;
        ListNode current = head;
        boolean odd = true;
        while (current != null) {
            if (odd) {
                oddNode.next = current;
                oddNode = oddNode.next;
            } else {
                evenNode.next = current;
                evenNode = evenNode.next;
            }
            odd = !odd;
            current = current.next;
        }
        evenNode.next = null;
        oddNode.next = evenHook.next;
        return oddHook.next;
    }

    public static void main(String[] args) {
        OddEvenList oddEvenList = new OddEvenList();
        ListNode listNode = oddEvenList.oddEvenList(ListNode.newInstance(1, 2, 3, 4, 5));
        assertThat(listNode.val).isEqualTo(2);
    }

}
