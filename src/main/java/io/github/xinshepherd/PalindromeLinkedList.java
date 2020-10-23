package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 234. 回文链表
 *
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 *
 * @author Fuxin
 * @since 2020/10/23
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 奇数
        if (fast != null) {
            slow = slow.next;
        }

        // 反转链表
        ListNode current = slow;
        ListNode next = slow.next;
        // 去掉循环链表
        current.next = null;
        while (next != null) {
            ListNode temp = next.next;
            next.next = current;
            current = next;
            next = temp;
        }

        ListNode node = head;
        while (current != null && node != null) {
            if (current.val != node.val)
                return false;
            current = current.next;
            node = node.next;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        assertThat(palindromeLinkedList.isPalindrome(ListNode.newInstance(1, 2))).isFalse();
        assertThat(palindromeLinkedList.isPalindrome(ListNode.newInstance(1, 2, 2, 1))).isTrue();
        assertThat(palindromeLinkedList.isPalindrome(ListNode.newInstance(1, 2, 3, 2, 1))).isTrue();
    }


}
