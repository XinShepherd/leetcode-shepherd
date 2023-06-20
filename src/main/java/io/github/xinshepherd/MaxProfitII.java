package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * 122. 买卖股票的最佳时机 II
 *
 * @author Fuxin
 * @since 2020/3/9 10:25
 */
public class MaxProfitII {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if (prices.length <= 1) {
            return maxProfit;
        }
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
                continue;
            }
            if (!(i + 1 < prices.length && prices[i + 1] > prices[i])) {
                maxProfit += prices[i] - minPrice;
                minPrice = prices[i];
            }
        }
        return maxProfit;
    }

    /**
     * 解法二
     * 动态规划
     */
    public int maxProfit2(int[] prices) {
        int dp0 = 0; // 当天不持有股票的利润
        int dp1 = -prices[0]; // 当天持有股票时的利润(首日买入，所以利润为负数)
        for (int i = 1; i < prices.length; i++) {
            int newDp0 = Math.max(dp0, dp1 + prices[i]);
            int newDp1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = newDp0;
            dp1 = newDp1;
        }
        return dp0;
    }

    /**
     * 解法三
     * 贪心算法
     */
    public int maxProfit3(int[] prices) {
        int ans = 0;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > buy) {
                ans += prices[i] - buy;
            }
            buy = prices[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxProfitII maxProfitII = new MaxProfitII();
        Assertions.assertThat(maxProfitII.maxProfit(new int[]{7, 1, 5, 3, 6, 4})).isEqualTo(7);
        Assertions.assertThat(maxProfitII.maxProfit(new int[]{1, 2, 3, 4, 5})).isEqualTo(4);
        Assertions.assertThat(maxProfitII.maxProfit(new int[]{7, 6, 4, 3, 1})).isEqualTo(0);
        Assertions.assertThat(maxProfitII.maxProfit(new int[]{1})).isEqualTo(0);

        Assertions.assertThat(maxProfitII.maxProfit2(new int[]{7, 1, 5, 3, 6, 4})).isEqualTo(7);
        Assertions.assertThat(maxProfitII.maxProfit2(new int[]{1, 2, 3, 4, 5})).isEqualTo(4);
        Assertions.assertThat(maxProfitII.maxProfit2(new int[]{7, 6, 4, 3, 1})).isEqualTo(0);
        Assertions.assertThat(maxProfitII.maxProfit2(new int[]{1})).isEqualTo(0);

        Assertions.assertThat(maxProfitII.maxProfit3(new int[]{7, 1, 5, 3, 6, 4})).isEqualTo(7);
        Assertions.assertThat(maxProfitII.maxProfit3(new int[]{1, 2, 3, 4, 5})).isEqualTo(4);
        Assertions.assertThat(maxProfitII.maxProfit3(new int[]{7, 6, 4, 3, 1})).isEqualTo(0);
        Assertions.assertThat(maxProfitII.maxProfit3(new int[]{1})).isEqualTo(0);
    }
}
