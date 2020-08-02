package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 29. 两数相除
 * https://leetcode-cn.com/problems/divide-two-integers/
 *
 * @author Fuxin
 * @since 2020/8/2
 */
public class Divide {

    public int divide(int dividend, int divisor) {
        if (dividend == 0)
            return 0;
        if (divisor == 1) return dividend;
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE)
                return Integer.MAX_VALUE;
            return -dividend;
        }
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        int count = div(absDividend, absDivisor);
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            return -count;
        }
        return count;
    }

    public int div(long a, long b) {
        if (a < b) return 0;
        int count = 1;
        long tb = b;
        while ((tb << 1) <= a) {
            tb <<= 1;
            count <<= 1;
        }
        return count + div(a - tb, b);
    }

    // 二分法，使用负数来处理边界
    public int divide2(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        boolean k = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        int result = 0;
        // 负数来 cover Integer.MIN_VALUE
        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);
        while (dividend <= divisor) {
            int temp = divisor;
            int c = 1;
            while (dividend - temp <= temp) {
                temp = temp << 1;
                c = c << 1;
            }
            dividend -= temp;
            result += c;
        }
        return k ? result : -result;
    }

    public static void main(String[] args) {
        Divide divide = new Divide();
        assertThat(divide.divide(10, 3)).isEqualTo(3);
        assertThat(divide.divide(7, -3)).isEqualTo(-2);
        assertThat(divide.divide(0, -3)).isEqualTo(0);
        assertThat(divide.divide(-2147483648, -1)).isEqualTo(2147483647);
    }

}
