package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 738. 单调递增的数字
 *
 * https://leetcode-cn.com/problems/monotone-increasing-digits/
 *
 * @author Fuxin
 * @since 2020/12/15
 */
public class MonotoneIncreasingDigits {

    public int monotoneIncreasingDigits(int N) {
        char[] chars = String.valueOf(N).toCharArray();
        int len = chars.length;
        int i = 1;
        while (i < len && chars[i] >= chars[i - 1]) {
            i++;
        }
        if (i < len) {
            while (i > 0 && chars[i] < chars[i - 1]) {
                chars[i - 1] -= 1;
                i--;
            }
            for (i += 1; i < len; i++) {
                chars[i] = '9';
            }
        }
        return Integer.parseInt(String.valueOf(chars));
    }

    public static void main(String[] args) {
        MonotoneIncreasingDigits digits = new MonotoneIncreasingDigits();
        assertThat(digits.monotoneIncreasingDigits(10)).isEqualTo(9);
        assertThat(digits.monotoneIncreasingDigits(1234)).isEqualTo(1234);
        assertThat(digits.monotoneIncreasingDigits(332)).isEqualTo(299);
        assertThat(digits.monotoneIncreasingDigits(0)).isEqualTo(0);
        assertThat(digits.monotoneIncreasingDigits(34421)).isEqualTo(33999);
        assertThat(digits.monotoneIncreasingDigits(34434)).isEqualTo(33999);
        assertThat(digits.monotoneIncreasingDigits(120)).isEqualTo(119);
    }

}
