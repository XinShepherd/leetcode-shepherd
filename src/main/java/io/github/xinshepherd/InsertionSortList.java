package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 147. 对链表进行插入排序
 * https://leetcode-cn.com/problems/insertion-sort-list/
 *
 * @author Fuxin
 * @since 2020/5/19
 */
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null)
            return null;
        ListNode next = head.next;
        head.next = null;
        while (next != null) {
            ListNode current = head, pre = current;
            // 直接倒着排
            while (current != null && current.val < next.val) {
                pre = current;
                current = current.next;
            }
            ListNode temp = next.next;
            if (pre.val >= next.val) {
                next.next = pre;
                head = next;
            } else {
                pre.next = next;
                next.next = current;
            }
            next = temp;
        }
        return head;
    }

    ListNode reverse(ListNode head) {
        ListNode current = head, next = current.next;
        current.next = null;
        while (next != null) {
            ListNode temp = next.next;
            next.next = current;
            current = next;
            next = temp;
        }
        return current;
    }


    public static void main(String[] args) {
        InsertionSortList insertionSortList = new InsertionSortList();
        ListNode head = new ListNode(4);
        head.append(2, 1, 3);
        ListNode node = insertionSortList.insertionSortList(head);
        assertThat(node.val).isEqualTo(1);
        head = new ListNode(-1);
        head.append(5, 3, 4, 0);
        node = insertionSortList.insertionSortList(head);
        assertThat(node.val).isEqualTo(-1);
    }

}
