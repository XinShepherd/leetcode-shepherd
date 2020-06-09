package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 990. 等式方程的可满足性
 * https://leetcode-cn.com/problems/satisfiability-of-equality-equations/
 *
 * @author Fuxin
 * @since 2020/6/8
 */
public class EquationsPossible {

    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (String str : equations) {
            if (str.charAt(1) == '=') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                union(parent, index1, index2);
            }
        }
        for (String str : equations) {
            if (str.charAt(1) == '!') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                if (find(parent, index1) == find(parent, index2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    // 找到祖先是自己的节点
    // 相当于通过祖先来通信
    public int find(int[] parent, int index) {
        while (parent[index] != index) {
            // 路径压缩
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }

    public static void main(String[] args) {
        EquationsPossible possible = new EquationsPossible();
        assertThat(possible.equationsPossible(new String[]{"a==b", "b!=c", "c==a"})).isEqualTo(false);
    }

}
