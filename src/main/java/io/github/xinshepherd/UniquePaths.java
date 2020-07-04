package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 62. 不同路径
 * https://leetcode-cn.com/problems/unique-paths/
 *
 * @author Fuxin
 * @since 2020/7/4
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0) {
                    dp[i][j] += dp[i - 1][j];
                }
                if (j - 1 >= 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        assertThat(uniquePaths.uniquePaths(3, 2)).isEqualTo(3);
        assertThat(uniquePaths.uniquePaths(7, 3)).isEqualTo(28);
    }

}
