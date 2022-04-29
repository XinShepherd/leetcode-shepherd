package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * 887. 鸡蛋掉落
 *
 * @author Fuxin
 * @since 2020/4/11
 */
public class SuperEggDrop {

    public int superEggDrop(int K, int N) {
        if(N == 1)
            return 1;
        int[][] f = new int[N + 1][K + 1];
        for (int i = 1; i <= K; i++) {
            f[1][i] = 1;
        }
        int ans = -1;

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                f[i][j] = 1 + f[i - 1][j - 1] + f[i - 1][j];
            }
            if (f[i][K] >= N) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SuperEggDrop eggDrop = new SuperEggDrop();
        Assertions.assertThat(eggDrop.superEggDrop(1, 2)).isEqualTo(2);
        Assertions.assertThat(eggDrop.superEggDrop(2, 6)).isEqualTo(3);
        Assertions.assertThat(eggDrop.superEggDrop(3, 14)).isEqualTo(4);
    }
}
