package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 64. 最小路径和
 * https://leetcode-cn.com/problems/minimum-path-sum/
 *
 * @author Fuxin
 * @since 2020/7/23
 */
public class MyMinPathSum {

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        if (row == 0)
            return 0;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        // 填充第一行
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        // 填充第一列
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(grid[i][j] + dp[i -1][j], grid[i][j] + dp[i][j - 1]);
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        MyMinPathSum minPathSum = new MyMinPathSum();
        assertThat(minPathSum.minPathSum(new int[][]{
                new int[]{1, 3, 1},
                new int[]{1, 5, 1},
                new int[]{4, 2, 1},
        })).isEqualTo(7);
    }
}
