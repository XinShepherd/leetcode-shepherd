package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 837. 新21点
 * https://leetcode-cn.com/problems/new-21-game/
 *
 * @author Fuxin
 * @since 2020/6/3
 */
public class New21Game {

    public double new21Game(int N, int K, int W) {
        if (K == 0)
            return 1.0;
        double[] dp = new double[K + W + 1];
        for (int i = K; i <= N && i < K + W; i++) {
            dp[i] = 1.0;
        }
        dp[K - 1] = 1.0d * Math.min(N - K + 1, W) / W;
        for (int i = K - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] - (dp[i + W + 1] - dp[i + 1]) / W;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        New21Game new21Game = new New21Game();
        assertThat(Math.abs(1 - new21Game.new21Game(10, 1, 10))).isLessThanOrEqualTo(0.00001);
        assertThat(Math.abs(0.73278 - new21Game.new21Game(21, 17, 10))).isLessThanOrEqualTo(0.00001);
    }

}
