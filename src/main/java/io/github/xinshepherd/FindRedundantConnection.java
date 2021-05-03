package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * 684. 冗余连接
 *
 * https://leetcode-cn.com/problems/redundant-connection/
 */
public class FindRedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        int[] parents = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            parents[i] = i;
        }
        UnionSet unionSet = new UnionSet(parents);
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            if (unionSet.find( x) != unionSet.find(y)) {
                unionSet.union(x, y);
            } else {
                return edge;
            }
        }
        return new int[0];
    }

    class UnionSet {

        int[] parents;

        public UnionSet(int[] parents) {
            this.parents = parents;
        }

        int find(int x) {
            if (parents[x] == x)
                return x;
            int i = find(parents[x]);
            parents[x] = i;
            return i;
        }

        void union(int x, int y) {
            parents[find(x)] = parents[find(y)];
        }
    }

    public static void main(String[] args) {
        FindRedundantConnection connection = new FindRedundantConnection();
        Assertions.assertThat(connection.findRedundantConnection(new int[][]{
                new int[]{1, 2},
                new int[]{1, 3},
                new int[]{2, 3}
        })).isEqualTo(new int[]{2, 3});
    }
}
