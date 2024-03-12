package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1162. 地图分析
 *
 * @author Fuxin
 * @since 2020/3/29
 */
public class MaxDistance {

    int[] nr = {0, 1, 0, -1};
    int[] nc = {-1, 0, 1, 0};

    public int maxDistance(int[][] grid) {
        int n = grid.length;
        if (n == 0) return 0;
        int[][] dp = new int[n][n];

        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int v = grid[i][j];
                if (v == 1) {
                    dp[i][j] = 0;
                    int code = i * n + j;
                    queue.addLast(code);
                }
            }
        }
        int max = -1;
        while (!queue.isEmpty()) {
            Integer code = queue.poll();
            int dr = code / n;
            int dc = code % n;
            for (int i = 0; i < 4; i++) {
                int r = dr + nr[i];
                int c = dc + nc[i];
                if (r >= 0 && r < n && c >= 0 && c < n && grid[r][c] == 0) {
                    dp[r][c] = dp[dr][dc] + 1;
                    grid[r][c] = 1;
                    int newCode = r * n + c;
                    queue.addLast(newCode);
                    max = Math.max(max, dp[r][c]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxDistance distance = new MaxDistance();
        Assertions.assertThat(distance.maxDistance(new int[][]{
                new int[]{1, 0, 1},
                new int[]{0, 0, 0},
                new int[]{1, 0, 1}
        })).isEqualTo(2);

        Assertions.assertThat(distance.maxDistance(new int[][]{
                new int[]{1, 0, 0},
                new int[]{0, 0, 0},
                new int[]{0, 0, 0}
        })).isEqualTo(4);
        Assertions.assertThat(distance.maxDistance(new int[][]{
                new int[]{0, 0, 0},
                new int[]{0, 0, 0},
                new int[]{0, 0, 0}
        })).isEqualTo(-1);

    }
}
