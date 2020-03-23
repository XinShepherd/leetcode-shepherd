package io.github.xinshepherd;

/**
 * 876. 链表的中间结点
 *
 * @author Fuxin
 * @since 2020/3/23 9:03
 */
public class MiddleNode {
    public ListNode middleNode(ListNode head) {

        ListNode fast = head, low = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            low = low.next;
        }

        return low;
    }

    public static void main(String[] args) {
        MiddleNode middleNode = new MiddleNode();
        ListNode head = new ListNode(1);
        System.out.println(middleNode.middleNode(head));
        head.append(2, 3, 4, 5);
        System.out.println(middleNode.middleNode(head));
        head.append(2, 3, 4, 5, 6);
        System.out.println(middleNode.middleNode(head));
        head.append(2);
        System.out.println(middleNode.middleNode(head));
    }
}
