package io.github.xinshepherd;

/**
 * 148. 排序链表
 *
 * @author Fuxin
 * @since 2020/11/21
 */
public class SortLinkedList {

    // O(n2)
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        ListNode hook = new ListNode(Integer.MIN_VALUE);
        ListNode cur = head.next;
        hook.next = head;
        hook.next.next = null;
        while (cur != null) {
            ListNode temp = cur;
            cur = cur.next;
            temp.next = null;

            ListNode pre = hook;
            ListNode next = hook.next;
            while (next != null) {
                if (next.val >= temp.val) {
                    pre.next = temp;
                    temp.next = next;
                    break;
                } else if (next.next == null){
                    next.next = temp;
                    break;
                }
                pre = next;
                next = next.next;
            }
        }
        return hook.next;
    }

    // O(nlogn)
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode half = slow.next;
        slow.next = null; // 注意隔断
        ListNode l1 = sortList2(head);
        ListNode l2 = sortList2(half);

        ListNode hook = new ListNode(Integer.MIN_VALUE), temp = hook;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null ? l2 : l1;
        return hook.next;
    }


    public static void main(String[] args) {

    }

}
