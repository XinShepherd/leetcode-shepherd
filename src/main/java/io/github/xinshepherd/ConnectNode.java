package io.github.xinshepherd;

import java.util.Deque;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 *
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 *
 * @author Fuxin
 * @since 2020/9/28
 */
public class ConnectNode {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

        public static Node of(Integer... elements) {
            if (elements.length == 0)
                return null;
            Deque<Node> queue = new LinkedList<>();
            for (Integer element : elements) {
                if (element != null) {
                    queue.addLast(new Node(element));
                } else {
                    queue.addLast(null);
                }
            }
            Deque<Node> current = new LinkedList<>();
            Node root = queue.removeFirst();
            current.addLast(root);
            while (!current.isEmpty()) {
                Node cur = current.removeFirst();
                if (cur != null) {
                    cur.left = queue.pollFirst();
                    cur.right = queue.pollFirst();
                    current.addLast(cur.left);
                    current.addLast(cur.right);
                }
            }
            return root;
        }
    }

    // 空间复杂度 O(N)
    public Node connect(Node root) {
        if (root == null)
            return null;
        Deque<Node> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            // hook
            Node node = new Node();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node next = queue.poll();
                node.next = next;
                node = next;
                if (next.left != null) {
                    queue.offer(next.left);
                }
                if (next.right != null) {
                    queue.offer(next.right);
                }
            }
        }
        return root;
    }

    // 空间复杂度 O(1)
    public Node connect2(Node root) {
        if (root == null) return null;
        link(root);
        return root;
    }

    void link(Node head) {
        Node node = head;
        while (node != null) {
            Node hook = new Node();
            Node current = hook;
            while (node != null) {
                if (node.left != null) {
                    current.next = node.left;
                    current = current.next;
                }
                if (node.right != null) {
                    current.next = node.right;
                    current = current.next;
                }
                node = node.next;
            }
            node = hook.next;
        }
    }

    public static void main(String[] args) {
        ConnectNode connectNode = new ConnectNode();
        Node node = Node.of(1, 2, 3, 4, 5, null, 7);
        Node ans = connectNode.connect(node);
        assertThat(ans.next).isNull();

        Node node2 = Node.of(1, 2, 3, 4, 5, null, 7);
        Node ans2 = connectNode.connect2(node2);
        assertThat(ans2.next).isNull();
    }

}


