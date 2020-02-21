package io.github.xinshepherd;

/**
 * 24. 两两交换链表中的节点
 * @author Fuxin
 * @since 2020/2/21 11:09
 */
public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        ListNode current = head, before = null, next = current.next;

        while (current != null && next != null) {
            ListNode temp = next.next;
            if (before != null) {
                before.next = next;
            }
            next.next = current;
            current.next = temp;
            before = current;
            current = temp;
            if (current != null) {
                next = current.next;
            }
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node = node1();
        print(node);
        SwapPairs swapPairs = new SwapPairs();
        ListNode listNode = swapPairs.swapPairs(node);
        print(listNode);
        print(swapPairs.swapPairs(node2()));
    }

    static ListNode node1() {
        ListNode head = new ListNode(1);
        append(append(append(head, 2), 3), 4);
        return head;
    }

    static ListNode node2() {
        ListNode head = new ListNode(1);
        append(append(append(append(head, 2), 3), 4), 5);
        return head;
    }

    static ListNode append(ListNode node, int value) {
        ListNode listNode = new ListNode(value);
        node.next = listNode;
        return listNode;
    }

    private static void print(ListNode listNode) {
        StringBuilder sb = new StringBuilder();
        while (listNode != null) {
            sb.append(listNode.val);
            sb.append(",");
            listNode = listNode.next;
        }
        System.out.println(sb.toString());
    }
}
