package io.github.xinshepherd;


/**
 * 1310. 子数组异或查询
 *
 * https://leetcode-cn.com/problems/xor-queries-of-a-subarray/
 *
 */
public class XorQueries {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int length = queries.length;
        int max = 0;
        for (int[] query : queries) {
            max = Math.max(query[1], max);
        }
        int[] dp = new int[max + 1];
        // 动态规划
        dp[0] = arr[0];
        for (int i = 1; i <= max; i++) {
            dp[i] = dp[i - 1] ^ arr[i];
        }
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            int[] query = queries[i];
            ans[i] = query[0] > 0 ? dp[query[1]] ^ dp[query[0] - 1] : dp[query[1]];
        }
        return ans;
    }

}
