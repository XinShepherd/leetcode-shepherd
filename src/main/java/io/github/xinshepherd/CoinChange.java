package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

import java.util.Arrays;

// 322. 零钱兑换
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    int dynamicProgramming(int[] coins, int amount, int[] total) {
        for (int i = 1; i <= amount; i++) {
            int temp = Integer.MAX_VALUE;
            for (int coin : coins) {
                int prev = i - coin;
                if (prev >= 0 && total[prev] != Integer.MAX_VALUE) {
                    temp = Math.min(total[prev] + 1, temp);
                }
            }
            total[i] = temp;
        }
        return total[amount] > amount ? -1 : total[amount];
    }

    int dp(int[] coins, int amount, int[] total) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (total[amount] != 0) return total[amount];
        int temp = Integer.MAX_VALUE;
        for (int coin : coins) {
            int result = dp(coins, amount - coin, total);
            if (result >= 0 && result < temp) {
                temp = result + 1;
            }
        }
        total[amount] = (temp == Integer.MAX_VALUE) ? -1 : temp;
        return total[amount];
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        Assertions.assertThat(coinChange.coinChange(new int[]{1, 2, 5}, 11)).isEqualTo(3);
        Assertions.assertThat(coinChange.coinChange(new int[]{1, 2, 5}, 10)).isEqualTo(2);
        Assertions.assertThat(coinChange.coinChange(new int[]{ 2 }, 3)).isEqualTo(-1);
        Assertions.assertThat(coinChange.coinChange(new int[]{ 2 }, 2)).isEqualTo(1);
        Assertions.assertThat(coinChange.coinChange(new int[]{ 2 }, 4)).isEqualTo(2);
        Assertions.assertThat(coinChange.coinChange(new int[]{186, 419, 83, 408}, 6249)).isEqualTo(20);
    }

}
