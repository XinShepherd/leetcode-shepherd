package io.github.xinshepherd;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Optional;

/**
 * 445. 两数相加 II
 *
 * @author Fuxin
 * @since 2020/4/14
 */
public class AddTowNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = initStack(l1);
        Deque<Integer> stack2 = initStack(l2);
        ListNode ans = null;
        int step = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || step !=0) {
            Integer num1 = Optional.ofNullable(stack1.poll()).orElse(0);
            Integer num2 = Optional.ofNullable(stack2.poll()).orElse(0);
            int sum = num1 + num2 + step;
            ListNode current = new ListNode(sum % 10);
            current.next = ans;
            step = sum / 10;
            ans = current;
        }
        return ans;
    }

    private Deque<Integer> initStack(ListNode l) {
        Deque<Integer> stack = new LinkedList<>();
        while (l != null) {
            stack.push(l.val);
            l = l.next;
        }
        return stack;
    }

    public static void main(String[] args) {
        AddTowNumbers addTowNumbers = new AddTowNumbers();
        ListNode l1 = new ListNode(7);
        l1.append(2, 4, 3);
        ListNode l2 = new ListNode(5);
        l2.append(6, 4);
        ListNode.print(addTowNumbers.addTwoNumbers(l1, l2));
    }

}
