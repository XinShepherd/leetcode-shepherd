package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 2. 两数相加
 *
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @author Fuxin
 * @since 2020/10/5
 */
public class AddTwoNumbers {

    // 第一种解法
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode hook = new ListNode(-1);
        ListNode current = hook;
        int step = 0;
        while (l1 != null && l2 != null) {
            int sum = step + l1.val + l2.val;
            ListNode node = new ListNode(sum % 10);
            step = sum / 10;
            current.next = node;
            current = node;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode res = l1 != null ? l1 : l2;
        if (step == 0) {
            current.next = res;
        } else {
            while (res != null && step == 1) {
                int sum = step + res.val;
                res.val = sum % 10;
                step = sum / 10;
                current.next = res;
                current = res;
                res = res.next;
            }
        }
        if (step == 1) {
            current.next = new ListNode(1);
        }
        return hook.next;
    }

    // 第二种解法
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode hook = new ListNode(-1);
        ListNode current = hook;
        int step = 0;
        while (l1 != null || l2 != null) {
            int sum = step;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            ListNode node = new ListNode(sum % 10);
            step = sum / 10;
            current.next = node;
            current = node;
        }
        if (step > 0) {
            current.next = new ListNode(step);
        }
        return hook.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = ListNode.newInstance(2, 4, 3);
        ListNode l2 = ListNode.newInstance(5, 6, 4);
        ListNode ans = addTwoNumbers.addTwoNumbers(l1, l2);
        assertThat(ans.val).isEqualTo(7);
    }

}
