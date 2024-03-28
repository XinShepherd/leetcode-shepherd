package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/first-day-where-you-have-been-in-all-the-rooms">1997 题：访问完所有房间的第一天</a>
 * @author Fuxin
 */
public class FirstDayBeenInAllRooms {

    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int n = nextVisit.length;
        int mod = 1000_000_000 + 7;
        int[] dp = new int[n];
        dp[0] = 2; //初始化原地待一天 + 访问下一个房间一天
        for (int i = 1; i < n; i++) {
            int to = nextVisit[i];
            dp[i] = 2 + dp[i - 1];
            if (to != 0) {
                dp[i] = (dp[i] - dp[to - 1] + mod) % mod; //避免负数
            }

            dp[i] = (dp[i] + dp[i - 1]) % mod;
        }
        return dp[n - 2]; //题目保证n >= 2
    }

    public static void main(String[] args) {
        FirstDayBeenInAllRooms rooms = new FirstDayBeenInAllRooms();
        Assertions.assertThat(rooms.firstDayBeenInAllRooms(new int[]{0, 0})).isEqualTo(2);
        Assertions.assertThat(rooms.firstDayBeenInAllRooms(new int[]{0, 0, 2})).isEqualTo(6);
        Assertions.assertThat(rooms.firstDayBeenInAllRooms(new int[]{0, 1, 2, 0})).isEqualTo(6);
        Assertions.assertThat(rooms.firstDayBeenInAllRooms(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0})).isEqualTo(320260018);
    }
}
