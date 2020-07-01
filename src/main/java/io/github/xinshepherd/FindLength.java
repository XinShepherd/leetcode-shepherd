package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 718. 最长重复子数组
 * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 *
 * @author Fuxin
 * @since 2020/7/1
 */
public class FindLength {

    // 暴力破解
    public int findLength(int[] A, int[] B) {
        int max = 0;
        int aLen = A.length;
        int bLen = B.length;
        for (int i = 0; i < aLen; i++) {
            if (aLen - i <= max)
                break;
            for (int j = 0; j < bLen; j++) {
                int aIndex = i;
                int bIndex = j;
                int len = 0;
                while (aIndex < aLen && bIndex < bLen && A[aIndex++] == B[bIndex++]) {
                    len++;
                }
                max = Math.max(max, len);
            }
        }
        return max;
    }

    // 动态规划
    public int findLength2(int[] A, int[] B) {
        int max = 0;
        int aLen = A.length;
        int bLen = B.length;
        int[][] dp = new int[aLen + 1][bLen + 1];
        for (int i = aLen - 1; i >= 0; i--) {
            for (int j = bLen - 1; j >= 0; j--) {
                dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        FindLength findLength = new FindLength();
        assertThat(findLength.findLength(
                new int[]{1, 2, 3, 2, 1},
                new int[]{3, 2, 1, 4, 7}
        )).isEqualTo(3);
        assertThat(findLength.findLength2(
                new int[]{1, 2, 3, 2, 1},
                new int[]{3, 2, 1, 4, 7}
        )).isEqualTo(3);
    }

}
