package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * 7. 整数反转
 *
 * https://leetcode-cn.com/problems/reverse-integer/
 */
public class Reverse {

    public int reverse(int x) {
        if (Integer.MIN_VALUE  == x)
            return 0;
        int max = Integer.MAX_VALUE / 10;
        int abs = Math.abs(x);
        int ans = 0;
        while (abs > 0) {
            if (ans > max)
                return 0;
            ans = ans * 10 + abs % 10;
            abs /= 10;
        }
        return x < 0 ? -ans : ans;
    }

    public static void main(String[] args) {
        Reverse reverse = new Reverse();
        Assertions.assertThat(reverse.reverse(12)).isEqualTo(21);
        Assertions.assertThat(reverse.reverse(121)).isEqualTo(121);
        Assertions.assertThat(reverse.reverse(-122)).isEqualTo(-221);
        Assertions.assertThat(reverse.reverse(0)).isEqualTo(0);
        Assertions.assertThat(reverse.reverse(Integer.MIN_VALUE)).isEqualTo(0);
        Assertions.assertThat(reverse.reverse(Integer.MAX_VALUE)).isEqualTo(0);
    }

}
