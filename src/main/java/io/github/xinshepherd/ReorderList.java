package io.github.xinshepherd;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 143. 重排链表
 * https://leetcode-cn.com/problems/reorder-list/
 *
 * @author Fuxin
 * @since 2020/9/17
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null)
            return;
        Deque<ListNode> stack = new LinkedList<>();
        ListNode node = head;
        int len = 0;
        while (node != null) {
            stack.push(node);
            node = node.next;
            len++;
        }
        ListNode next = head;
        int current = 0;
        int half = (len - 1) / 2;
        while (current < half) {
            ListNode pop = stack.pop();
            pop.next = next.next;
            next.next = pop;
            next = pop.next;
            current++;
        }
        // 解决循环链表的问题
        if (len % 2 == 0) {
            next.next.next = null;
        } else {
            next.next = null;
        }
    }

    public static void main(String[] args) {
        ReorderList reorderList = new ReorderList();
        ListNode head = new ListNode(1);
        head.append(2, 3, 4);
        reorderList.reorderList(head);
        head = ListNode.newInstance(1, 2, 3, 4, 5);
        reorderList.reorderList(head);
    }

}
