package io.github.xinshepherd;

/**
 * @author Fuxin
 * @since 2020/3/2 8:35
 */
public class NumTrees {

    int num = 0;

    public int numTrees(int n) {
        if (n == 0)
            return 0;
        boolean[] flags = new boolean[n];
        num = 0;
        // root
        for (int i = 0; i < n; i++) {
            flags[i] = true;
            TreeNode root = new TreeNode(i);
            backtrack(n, 1, root, flags);
            flags[i] = false;
        }
        return num;
    }

    void backtrack(int n, int count, TreeNode node, boolean[] flags) {
        if (count == n) {
            num++;
            return;
        }
        for (int i = 0; i < node.val; i++) {
            if (flags[i]) {
                continue;
            }
            node.left = new TreeNode(i);
            flags[i] = true;
            backtrack(n, count + 1, node.left, flags);
            flags[i] = false;
        }
        for (int i = node.val; i < n; i++) {
            if (flags[i]) {
                continue;
            }
            node.right = new TreeNode(i);
            flags[i] = true;
            backtrack(n, count + 1, node.right, flags);
            flags[i] = false;
        }
    }

    public static void main(String[] args) {
        NumTrees numTrees = new NumTrees();
        System.out.println(numTrees.numTrees(3));
    }

}
