package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

// 509. 斐波那契数
public class Fibonacci {

    public int fib(int N) {
        return fibQuickVersion2(N);
    }

    // 空间复杂度 O(N)  时间复杂度 O(2^n)
    int fibNormalVersion(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        return fibNormalVersion(N - 1) + fibNormalVersion(N - 2);
    }

    // 空间复杂度 O(N)  时间复杂度 O(N)
    int fibQuickVersion(int N) {
        int[] ints = new int[N + 1];
        ints[0] = 0;
        ints[1] = 1;
        for (int i = 2; i < N + 1; i++) {
            ints[i] = ints[i - 1] + ints[i - 2];
        }
        return ints[N];
    }

    // 空间复杂度 O(1)  时间复杂度 O(N)
    int fibQuickVersion2(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        int funcMinus2 = 0;
        int funcMinus1 = 1;
        int current = 0;
        for (int i = 2; i < N + 1; i++) {
            current = funcMinus1 + funcMinus2;
            funcMinus2 = funcMinus1;
            funcMinus1 = current;
        }
        return current;
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        Assertions.assertThat(fibonacci.fib(0)).isEqualTo(0);
        Assertions.assertThat(fibonacci.fib(1)).isEqualTo(1);
        Assertions.assertThat(fibonacci.fib(4)).isEqualTo(3);
        Assertions.assertThat(fibonacci.fib(20)).isEqualTo(6765);
    }
}
