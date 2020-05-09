package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 69. x 的平方根
 *
 * @author Fuxin
 * @since 2020/5/9
 */
public class MySqrt {

    public int mySqrt(int x) {
        if (x <= 1)
            return x;
        int left = 0, right = x;
        while (left + 1 < right) {
            int mid = (left + right) >> 1;
            long res = (long)mid * mid;
            if (res > x) {
                right = mid;
            } else if (res < x) {
                left = mid;
            } else {
                return mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        assertThat(mySqrt.mySqrt(0)).isEqualTo(0);
        assertThat(mySqrt.mySqrt(1)).isEqualTo(1);
        assertThat(mySqrt.mySqrt(2)).isEqualTo(1);
        assertThat(mySqrt.mySqrt(4)).isEqualTo(2);
        assertThat(mySqrt.mySqrt(5)).isEqualTo(2);
        assertThat(mySqrt.mySqrt(9)).isEqualTo(3);
        assertThat(mySqrt.mySqrt(16)).isEqualTo(4);
        assertThat(mySqrt.mySqrt(255)).isEqualTo(15);
        assertThat(mySqrt.mySqrt(256)).isEqualTo(16);
        assertThat(mySqrt.mySqrt(2147395599)).isEqualTo(46339);
    }

}
