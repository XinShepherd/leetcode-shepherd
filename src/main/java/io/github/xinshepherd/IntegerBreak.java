package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 343. 整数拆分
 * https://leetcode-cn.com/problems/integer-break/
 *
 * @author Fuxin
 * @since 2020/7/30
 */
public class IntegerBreak {

    public int integerBreak(int n) {
        if (n == 2)
            return 1;
        if (n == 3) {
            return 2;
        }
        return breakInt(n);
    }

    private int breakInt(int n) {
        if (n <= 4) {
            return n;
        }
        return 3 * breakInt(n - 3);
    }

    public static void main(String[] args) {
        IntegerBreak integerBreak = new IntegerBreak();
        assertThat(integerBreak.integerBreak(2)).isEqualTo(1);
        assertThat(integerBreak.integerBreak(3)).isEqualTo(2);
        assertThat(integerBreak.integerBreak(4)).isEqualTo(4);
        assertThat(integerBreak.integerBreak(10)).isEqualTo(36);
    }

}
