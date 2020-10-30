package io.github.xinshepherd;

import java.util.Deque;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 463. 岛屿的周长
 *
 * https://leetcode-cn.com/problems/island-perimeter/
 *
 * @author Fuxin
 * @since 2020/10/30
 */
public class IslandPerimeter {

    int[] dr = new int[]{0, 1, 0, -1};
    int[] dc = new int[]{1, 0, -1, 0};

    public int islandPerimeter(int[][] grid) {
        int rLen = grid.length;
        if (rLen == 0)
            return 0;
        int cLen = grid[0].length;
        boolean[][] dp = new boolean[rLen][cLen];
        Deque<int[]> queue = new LinkedList<>();
        outer:
        for (int i = 0; i < rLen; i++) {
            for (int j = 0; j < cLen; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    dp[i][j] = true;
                    break outer;
                }
            }
        }
        int sum = 0;
        while (!queue.isEmpty()) {
            int[] ints = queue.poll();
            sum += 4;
            for (int i = 0; i < 4; i++) {
                int nr = ints[0] + dr[i];
                int nc = ints[1] + dc[i];
                if (nr >= 0 && nr < rLen && nc >= 0 && nc < cLen && grid[nr][nc] == 1) {
                    sum--;
                    if (!dp[nr][nc]) {
                        queue.offer(new int[]{nr, nc});
                        dp[nr][nc] = true;
                    }
                }
            }
        }
        return sum;
    }

    public int islandPerimeter2(int[][] grid) {
        int rLen = grid.length;
        if (rLen == 0)
            return 0;
        int cLen = grid[0].length;
        int sum = 0;
        for (int i = 0; i < rLen; i++) {
            for (int j = 0; j < cLen; j++) {
                if (grid[i][j] == 1) {
                    sum += 4;
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if (nr >= 0 && nr < rLen && nc >= 0 && nc < cLen && grid[nr][nc] == 1) {
                            sum--;
                        }
                    }
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        IslandPerimeter islandPerimeter = new IslandPerimeter();
        int[][] grid = {
                new int[]{0, 1, 0, 0},
                new int[]{1, 1, 1, 0},
                new int[]{0, 1, 0, 0},
                new int[]{1, 1, 0, 0}
        };
        assertThat(islandPerimeter.islandPerimeter(grid)).isEqualTo(16);
        assertThat(islandPerimeter.islandPerimeter2(grid)).isEqualTo(16);
    }

}
