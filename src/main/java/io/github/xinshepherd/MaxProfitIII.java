package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * 123. 买卖股票的最佳时机 III
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 *
 * @author Fuxin
 * @since 2021/5/5
 */
public class MaxProfitIII {

    public int maxProfit(int[] prices) {
        /*
         * 总共5个状态,状态之间转移
         * 但第一个状态可以忽略
         * buy1 buy2 表示当前买入时的收益
         *
         */
        int buy1 = -prices[0], buy2 = -prices[0];
        int sell1 = 0, sell2 = 0;
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            // 要么不操作，要么买入
            buy1 = Math.max(buy1, -price);
            // 要么不操作，要么第一次出售
            sell1 = Math.max(sell1, price + buy1);
            buy2 = Math.max(buy2, sell1 - price);
            sell2 = Math.max(sell2, price + buy2);
        }
        return sell2;
    }

    public static void main(String[] args) {
        MaxProfitIII maxProfitII = new MaxProfitIII();
        Assertions.assertThat(maxProfitII.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4})).isEqualTo(6);
        Assertions.assertThat(maxProfitII.maxProfit(new int[]{1, 2, 3, 4, 5})).isEqualTo(4);
        Assertions.assertThat(maxProfitII.maxProfit(new int[]{7, 6, 4, 3, 1})).isEqualTo(0);
    }

}
