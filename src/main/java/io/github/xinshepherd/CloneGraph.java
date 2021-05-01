package io.github.xinshepherd;


import org.assertj.core.api.Assertions;

import java.util.*;

/**
 * 133. 克隆图
 *
 * https://leetcode-cn.com/problems/clone-graph/
 */
public class CloneGraph {

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        Map<Integer, Node> map = new HashMap<>();
        return clone(node, map);
    }

    private Node clone(Node node, Map<Integer, Node> map) {
        Node clone = map.get(node.val);
        if (clone == null) {
            clone = new Node(node.val);
            map.put(node.val, clone);
        } else {
            return clone;
        }
        List<Node> cloneNeighbors = new ArrayList<>();
        for (Node neighbor : node.neighbors) {
            cloneNeighbors.add(clone(neighbor, map));
        }
        clone.neighbors = cloneNeighbors;
        return clone;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors = Arrays.asList(node2, node4);
        node2.neighbors = Arrays.asList(node1, node3);
        node3.neighbors = Arrays.asList(node2, node4);
        node4.neighbors = Arrays.asList(node1, node3);
        CloneGraph cloneGraph = new CloneGraph();
        Node clone = cloneGraph.cloneGraph(node1);
        Assertions.assertThat(clone).isNotNull();
    }
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}