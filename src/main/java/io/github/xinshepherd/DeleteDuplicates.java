package io.github.xinshepherd;

/**
 * 83. 删除排序链表中的重复元素
 *
 * @author Fuxin
 * @since 2020/3/19 16:50
 */
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode current = head.next, prev = head;
        while (current != null) {
            if (prev.val == current.val) {
                prev.next = current.next;
            } else {
                prev = current;
            }
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        ListNode head = new ListNode(1);
        head.append(2, 3, 3, 3, 4, 4, 5);
        System.out.println(deleteDuplicates.deleteDuplicates(head));
    }

}
