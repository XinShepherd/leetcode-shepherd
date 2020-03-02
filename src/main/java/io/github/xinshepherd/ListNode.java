package io.github.xinshepherd;

/**
 * @author Fuxin
 * @since 2020/2/21 11:10
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode append(int x) {
        ListNode listNode = new ListNode(x);
        next = listNode;
        return listNode;
    }

    ListNode append(int... nums) {
        ListNode node = this;
        for (int num : nums) {
            node = append(node, num);
        }
        return node;
    }

    ListNode append(ListNode node, int num) {
        ListNode listNode = new ListNode(num);
        node.next = listNode;
        return listNode;
    }

    static void print(ListNode listNode) {
        StringBuilder sb = new StringBuilder();
        while (listNode != null) {
            sb.append(listNode.val);
            sb.append(",");
            listNode = listNode.next;
        }
        System.out.println(sb.toString());
    }
}
