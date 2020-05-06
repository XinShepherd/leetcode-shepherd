package io.github.xinshepherd;

/**
 * 983. 最低票价
 * https://leetcode-cn.com/problems/minimum-cost-for-tickets/
 *
 * @author Fuxin
 * @since 2020/5/6
 */
public class MincostTickets {

    int[] days, costs;
    Integer[] memo;
    int[] durations = new int[]{1, 7, 30};

    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        memo = new Integer[days.length];
        return dp(0);
    }

    public int dp(int i) {
        if (i >= days.length) {
            return 0;
        }
        if (memo[i] != null) {
            return memo[i];
        }
        memo[i] = Integer.MAX_VALUE;
        int j = i;
        for (int k = 0; k < 3; ++k) {
            while (j < days.length && days[j] < days[i] + durations[k]) {
                j++;
            }
            memo[i] = Math.min(memo[i], dp(j) + costs[k]);
        }
        return memo[i];
    }

}
