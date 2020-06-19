package io.github.xinshepherd;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * 1028. 从先序遍历还原二叉树
 * https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal/
 *
 * @author Fuxin
 * @since 2020/6/18
 */
public class RecoverFromPreorder {

    public TreeNode recoverFromPreorder(String S) {
        if ("".equals(S)) {
            return null;
        }
        Deque<Pair> deque = convert(S);
        TreeNode root = new TreeNode(deque.pollFirst().value);
        build(root, deque, 1);
        return root;
    }

    void build(TreeNode node, Deque<Pair> deque, int dept) {
        while (!deque.isEmpty()) {
            Pair current = deque.peek();
            if (current.depth < dept) {
                return;
            }
            current = deque.pollFirst();
            if (current.depth == dept) {
                TreeNode cur = new TreeNode(current.value);
                if (Objects.isNull(node.left)) {
                    node.left = cur;
                } else {
                    node.right = cur;
                }
                build(cur, deque, dept + 1);
            }
        }
    }

    Deque<Pair> convert(String s) {
        int dept = 0;
        boolean isValue = true;
        int startIndex = 0;
        Deque<Pair> deque = new LinkedList<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (isValue && (s.charAt(i) == '-')) {
                int v = Integer.parseInt(s.substring(startIndex, i));
                Pair pair = new Pair(v, dept);
                deque.addLast(pair);
                dept = 1;
                isValue = false;
            } else if (!isValue) {
                if (s.charAt(i) == '-') {
                    dept++;
                } else {
                    startIndex = i;
                    isValue = true;
                }
            }
        }
        int v = Integer.parseInt(s.substring(startIndex, len));
        Pair pair = new Pair(v, dept);
        deque.addLast(pair);
        return deque;
    }

    static class Pair {
        int value;
        int depth;

        public Pair(int value, int depth) {
            this.value = value;
            this.depth = depth;
        }
    }

    public static void main(String[] args) {
        RecoverFromPreorder preorder = new RecoverFromPreorder();
        preorder.recoverFromPreorder("1-2--3--4-5--6--7");
        preorder.recoverFromPreorder("1-2--3---4-5--6---7");
    }

}
