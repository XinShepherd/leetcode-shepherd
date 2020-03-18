package io.github.xinshepherd;

/**
 * 96. 不同的二叉搜索树
 *
 * @author Fuxin
 * @since 2020/3/2 8:35
 */
public class NumTrees {

    public int numTrees(int n) {

        // 动态规划
        // 选取一个根节点，然后根节点左边是左子树，根节点右边是右子树，左右子树的个数相乘就是结果（一个递归的过程）
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    public static void main(String[] args) {
        NumTrees numTrees = new NumTrees();
        System.out.println(numTrees.numTrees(3));
    }

}
