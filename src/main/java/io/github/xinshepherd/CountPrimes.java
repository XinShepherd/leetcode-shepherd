package io.github.xinshepherd;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 204. 计数质数
 *
 * @author Fuxin
 * @since 2020/12/3
 */
public class CountPrimes {

    public int countPrimes(int n) {
        int[] primes = new int[n];
        Arrays.fill(primes, 1);
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i] == 1) {
                ans += 1;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        primes[j] = 0;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        CountPrimes countPrimes = new CountPrimes();
        assertThat(countPrimes.countPrimes(10)).isEqualTo(4);
        assertThat(countPrimes.countPrimes(10)).isEqualTo(4);
        assertThat(countPrimes.countPrimes(0)).isEqualTo(0);
        assertThat(countPrimes.countPrimes(1)).isEqualTo(0);
    }

}
