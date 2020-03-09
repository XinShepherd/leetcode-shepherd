package io.github.xinshepherd;

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

    public static void main(String[] args) {
        MaxProfitII maxProfitII = new MaxProfitII();
        System.out.println(maxProfitII.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfitII.maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(maxProfitII.maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(maxProfitII.maxProfit(new int[]{1}));
    }
}
