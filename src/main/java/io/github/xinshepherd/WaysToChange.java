package io.github.xinshepherd;

/**
 * 面试题 08.11. 硬币
 *
 * @author Fuxin
 * @since 2020/4/23
 */
public class WaysToChange {

    int mod = 1000000007;
    int coins[] = {25, 10, 5, 1};

    public int waysToChange(int n) {
        if (n <=0) return 0;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int c = 0; c < 4; c++) {
            int coin = coins[c];
            for (int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % mod;
            }
        }
        return (int)dp[n];
    }

    public static void main(String[] args) {
        WaysToChange change = new WaysToChange();
        System.out.println(change.waysToChange(3));
        System.out.println(change.waysToChange(5));
        System.out.println(change.waysToChange(10));
        System.out.println(change.waysToChange(25));
    }

}
