package io.github.xinshepherd;

/**
 * 23. 合并K个排序链表
 *
 * @author Fuxin
 * @since 2020/2/20 10:47
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if (length == 0) return null;
        ListNode head = null;
        ListNode current = null;
        boolean allEmpty = false;
        while (!allEmpty) {
            ListNode min = null;
            allEmpty = true;
            int index = 0;
            for (int i = 0; i < length; i++) {
                if (lists[i] == null)
                    continue;
                allEmpty = false;
                if (min == null) {
                    min = lists[i];
                    index = i;
                } else {
                    if (min.val > lists[i].val) {
                        min = lists[i];
                        index = i;
                    }
                }
            }
            if (min != null) {
                min = new ListNode(min.val);
                lists[index] = lists[index].next;
                if (head == null) {
                    current = head = min;
                } else {
                    current.next = min;
                    current = current.next;
                }
            }
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        MergeKLists mergeKLists = new MergeKLists();
        ListNode[] listNodes = new ListNode[]{
                list1(),
                list2(),
                list3()
        };
        print(mergeKLists.mergeKLists(listNodes));
        print(mergeKLists.mergeKLists(new ListNode[0]));
        print(mergeKLists.mergeKLists(new ListNode[]{
                null
        }));
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

    public static ListNode list1() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        node1.next = node2;
        ListNode node3 = new ListNode(5);
        node2.next = node3;
        return node1;
    }

    public static ListNode list2() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node3 = new ListNode(4);
        node2.next = node3;
        return node1;
    }

    public static ListNode list3() {
        ListNode node1 = new ListNode(2);
        ListNode node3 = new ListNode(6);
        node1.next = node3;
        return node1;
    }
}
