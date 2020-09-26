package io.github.xinshepherd;


import java.util.Deque;
import java.util.LinkedList;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    TreeNode() {
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 该方法存在重大漏洞，请使用 {@link #of(Integer...)} 方法
     *
     * @param elements 数组元素
     * @return 完整的树
     * @deprecated
     */
    @Deprecated
    public static TreeNode buildTreeFromArrays(Integer[] elements) {
        TreeNode root = new TreeNode(elements[0]);
        build(root, elements, 1, 1, 1);
        return root;
    }

    static void build(TreeNode node, Integer[] elements, int start, int current, int len) {
        if (node == null)
            return;
        int newLen = len * 2;
        int newStart = start + newLen;
        if (current < elements.length && elements[current] != null) {
            int i = (current - start + 1) * newLen + start;
            node.left = new TreeNode(elements[current]);
            build(node.left, elements, newStart, i, newLen);
        }
        current++;
        if (current < elements.length && elements[current] != null) {
            int i = (current - start + 1) * newLen + start;
            node.right = new TreeNode(elements[current]);
            build(node.right, elements, newStart, i, newLen);
        }
    }

    public static TreeNode of(Integer... elements) {
        if (elements.length == 0)
            return null;
        Deque<TreeNode> queue = new LinkedList<>();
        for (Integer element : elements) {
            if (element != null) {
                queue.addLast(new TreeNode(element));
            } else {
                queue.addLast(null);
            }
        }
        Deque<TreeNode> current = new LinkedList<>();
        TreeNode root = queue.removeFirst();
        current.addLast(root);
        while (!current.isEmpty()) {
            TreeNode cur = current.removeFirst();
            if (cur != null) {
                cur.left = queue.pollFirst();
                cur.right = queue.pollFirst();
                current.addLast(cur.left);
                current.addLast(cur.right);
            }
        }
        return root;
    }

    public TreeNode addLeftAndRight(int left, int right) {
        this.left = new TreeNode(left);
        this.right = new TreeNode(right);
        return this;
    }

    public TreeNode addLeft(int left) {
        this.left = new TreeNode(left);
        return this;
    }

    public TreeNode addRight(int right) {
        this.right = new TreeNode(right);
        return this;
    }

    public static TreeNode demo() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        return root;
    }

    public static TreeNode demo2() {
        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(20);
        root.left = new TreeNode(9);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        return root;
    }

    // BST
    public static TreeNode demo3() {
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left = new TreeNode(1);
        return root;
    }

    public static TreeNode demo4() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        return root;
    }

    public static TreeNode demo5() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        return root;
    }

    // 左子树深度大于右子树
    public static TreeNode demo6() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        return root;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}
