package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * 50. Pow(x, n)
 *
 * @author Fuxin
 * @since 2020/3/24 11:14
 */
public class MyPow {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        long N = n;
        if (n < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }

    double fastPow(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }


    public static void main(String[] args) {
        MyPow myPow = new MyPow();
        Assertions.assertThat(myPow.myPow(0, 0)).isEqualTo(1.0);
        Assertions.assertThat(myPow.myPow(1, 0)).isEqualTo(1.0);
        Assertions.assertThat(myPow.myPow(-1, 0)).isEqualTo(1.0);
        Assertions.assertThat(myPow.myPow(2, 2)).isEqualTo(4.0);
        Assertions.assertThat(myPow.myPow(2, 10)).isEqualTo(1024.0);
        Assertions.assertThat(myPow.myPow(-2, 10)).isEqualTo(1024.0);
        Assertions.assertThat(myPow.myPow(2, -2)).isEqualTo(0.25);
        Assertions.assertThat(myPow.myPow(-2, -3)).isEqualTo(-0.125);
    }
}
