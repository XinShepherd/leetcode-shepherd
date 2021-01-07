package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 547. 省份数量
 *
 * https://leetcode-cn.com/problems/number-of-provinces/
 *
 * @author Fuxin
 * @since 2021/1/7
 */
public class FindCircleNum {

    int ans = 0;

    public int findCircleNum(int[][] isConnected) {
        int length = isConnected.length;
        ans = 0;
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            if (dp[i] != 1) {
                dp[i] = 1;
                search(isConnected, dp, i);
                ans++;
            }
        }
        return ans;
    }

    void search(int[][] isConnected, int[] dp, int i) {
        int length = isConnected.length;
        for (int j = 0; j < length; j++) {
            if (isConnected[i][j] == 1 && dp[j] != 1) {
                dp[j] = 1;
                search(isConnected, dp, j);
            }
        }
    }

    public static void main(String[] args) {
        FindCircleNum findCircleNum = new FindCircleNum();
        assertThat(findCircleNum.findCircleNum(new int[][]{
                new int[]{1, 1, 0},
                new int[]{1, 1, 0},
                new int[]{0, 0, 1}
        })).isEqualTo(2);
        assertThat(findCircleNum.findCircleNum(new int[][]{
                new int[]{1, 0, 0},
                new int[]{0, 1, 0},
                new int[]{0, 0, 1}
        })).isEqualTo(3);
    }

}
