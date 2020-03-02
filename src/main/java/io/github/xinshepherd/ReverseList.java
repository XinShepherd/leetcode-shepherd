package io.github.xinshepherd;

/**
 * @author Fuxin
 * @since 2020/3/2 16:38
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        return iterate(head);
    }

    ListNode iterate(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = head;
        ListNode current = head.next, result = current;
        head.next = null;
        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            if (temp == null) {
                result = current;
            }
            current = temp;
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        ListNode head = new ListNode(1);
        head.append(2, 3, 4, 5);
        ListNode.print(reverseList.reverseList(head));
        head = new ListNode(3);
        head.append(2);
        ListNode.print(reverseList.reverseList(head));
    }

}
