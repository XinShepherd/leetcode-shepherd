package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * 121. 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        return onceLoop(prices);
    }


    public int onceLoop(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }


    // 暴力破解法
    public int loop(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                max = Math.max(prices[j] - prices[i], max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        Assertions.assertThat(maxProfit.maxProfit(new int[]{7, 1, 5, 3, 6, 4})).isEqualTo(5);
        Assertions.assertThat(maxProfit.maxProfit(new int[]{7, 6, 4, 3, 1})).isEqualTo(0);

    }

}
