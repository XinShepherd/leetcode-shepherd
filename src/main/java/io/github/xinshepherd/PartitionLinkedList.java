package io.github.xinshepherd;

/**
 * 86. 分隔链表
 *
 * @author Fuxin
 * @since 2020/2/26 10:51
 */
public class PartitionLinkedList {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;
        ListNode headLow = new ListNode(0), currentLow = headLow;
        ListNode headHigh = new ListNode(0), currentHigh = headHigh;
        while (head != null) {
            if (head.val < x) {
                currentLow.next = head;
                currentLow = currentLow.next;
            } else {
                currentHigh.next = head;
                currentHigh = currentHigh.next;
            }
            head = head.next;
        }
        currentLow.next = headHigh.next;
        currentHigh.next = null;
        return headLow.next;
    }

    public static void main(String[] args) {
        ListNode demo = demo();
        PartitionLinkedList partitionLinkedList = new PartitionLinkedList();
        ListNode partition = partitionLinkedList.partition(demo, 3);
        ListNode.print(partition);
    }

    static ListNode demo() {
        ListNode head = new ListNode(1);
        head.append(4)
                .append(3)
                .append(2)
                .append(5)
                .append(2);
        return head;
    }


}
