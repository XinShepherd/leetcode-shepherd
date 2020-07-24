package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 1025. 除数博弈
 * https://leetcode-cn.com/problems/divisor-game/
 *
 * @author Fuxin
 * @since 2020/7/24
 */
public class DivisorGame {

    public boolean divisorGame(int N) {
        if (N <= 1)
            return false;
        boolean[] dp = new boolean[N + 1];
        dp[2] = true;
        for (int i = 4; i < N + 1; i++) {
            if (i % 2 == 0) {
                dp[i] = !dp[i - 1] || !dp[i / 2];
            } else {
                dp[i] = !dp[i - 1];
            }
        }
        return dp[N];
    }

    public static void main(String[] args) {
        DivisorGame divisorGame = new DivisorGame();
        assertThat(divisorGame.divisorGame(4)).isTrue();
        assertThat(divisorGame.divisorGame(5)).isFalse();
        assertThat(divisorGame.divisorGame(6)).isTrue();
        assertThat(divisorGame.divisorGame(7)).isFalse();
    }

}
