package io.github.xinshepherd;

/**
 * 23. 合并K个排序链表
 *
 * @author Fuxin
 * @since 2020/2/20 10:47
 */
public class MergeKLists {

    // 方法 2：逐一比较 时间复杂度 O(kN)  空间复杂度 O(n)
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

    // 分治 两两合并 O(Nlogk)  空间复杂度  O(1)
    public ListNode mergeKLists2(ListNode[] lists) {
        int length = lists.length;
        if (length == 0) return null;
        int interval = 1;
        while (interval < length) {
            for (int i = 0; i < length - interval; i += interval * 2) {
                lists[i] = mergeTowListNode(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }

    private ListNode mergeTowListNode(ListNode node1, ListNode node2) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                current.next = node1;
                node1 = node1.next;
            } else {
                current.next = node2;
                node2 = node2.next;
            }
            current = current.next;
        }
        if (node1 != null) {
            current.next = node1;
        } else {
            current.next = node2;
        }
        return head.next;
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
        print(mergeKLists.mergeKLists2(listNodes));
        print(mergeKLists.mergeKLists2(new ListNode[0]));
        print(mergeKLists.mergeKLists2(new ListNode[]{
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
