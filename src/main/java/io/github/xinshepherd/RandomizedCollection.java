package io.github.xinshepherd;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Fuxin
 * @since 2020/10/31
 */
public class RandomizedCollection {

    static class Node {
        int val;
        Node before;
        Node after;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    Map<Integer, Node> map = new HashMap<>();
    Node head;
    Node tail;
    Node current;

    int size = 0;
    boolean changed = false;
    int[] array;

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {

    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
        } else {
            tail.after = node;
            node.before = tail;
        }
        tail = node;
        Node valNode = map.get(val);
        boolean notContain = valNode == null;
        if (!notContain) {
            node.next = valNode;
        }
        map.put(val, node);
        current = head;
        changed = true;
        size++;
        return notContain;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        Node node = map.get(val);
        boolean contains = node != null;
        if (contains) {
            map.put(val, node.next);
            Node before = node.before;
            if (before != null) {
                before.after = node.after;
            }
            if (node.after != null) {
                node.after.before = before;
            }
            if (node == head) {
                head = node.after;
            }
            if (node == tail) {
                tail = node.before;
            }
            current = head;
            changed = true;
            size--;
        }
        return contains;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        if (changed) {
            array = new int[size];
            Node cur = head;
            for (int i = 0; i < size; i++) {
                array[i] = cur.val;
                cur = cur.after;
            }
        }
        return array[ThreadLocalRandom.current().nextInt(size)];
    }

    public int getRandom2() {
        if (current == null) {
            current = head;
        }
        if (current != null) {
            int val = current.val;
            current = current.after;
            return val;
        }
        return 0;
    }

    /**
     * Your RandomizedCollection object will be instantiated and called as such:
     * RandomizedCollection obj = new RandomizedCollection();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */
    public static void main(String[] args) {
        // 初始化一个空的集合。
        RandomizedCollection collection = new RandomizedCollection();

        assertThat(collection.insert(1)).isTrue();

        assertThat(collection.insert(10)).isTrue();

        assertThat(collection.insert(10)).isFalse();

        assertThat(collection.insert(100)).isTrue();

        assertThat(collection.getRandom());

        assertThat(collection.remove(10)).isTrue();
    }

}
