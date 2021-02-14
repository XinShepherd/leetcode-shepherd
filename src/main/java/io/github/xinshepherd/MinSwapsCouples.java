package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 765. 情侣牵手
 *
 * https://leetcode-cn.com/problems/couples-holding-hands/
 *
 * @author Fuxin
 * @since 2021/2/14
 */
public class MinSwapsCouples {

    public int minSwapsCouples(int[] row) {
        int len = row.length;
        int N = len / 2;
        UnionFind unionFind = new UnionFind(N);
        for (int i = 0; i < len; i += 2) {
            unionFind.union(row[i] / 2, row[i + 1] / 2);
        }
        return N - unionFind.getCount();
    }

    static class UnionFind{
        private final int[] parent;
        private int count;

        public UnionFind(int count) {
            this.count = count;
            this.parent = new int[count];
            for (int i = 0; i < count; i++) {
                parent[i] = i;
            }
        }

        public int find(int son) {
            if (parent[son] == son)
                return son;
            int p = find(parent[son]);
            parent[son] = p;
            return p;
        }

        public void union(int x, int y) {
            int xp = find(x);
            int yp = find(y);
            if (xp == yp)
                return;
            parent[xp] = yp;
            count--;
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        MinSwapsCouples minSwapsCouples = new MinSwapsCouples();
        assertThat(minSwapsCouples.minSwapsCouples(new int[]{0, 2, 1, 3})).isEqualTo(1);
        assertThat(minSwapsCouples.minSwapsCouples(new int[]{3, 2, 0, 1})).isEqualTo(0);
    }


}
