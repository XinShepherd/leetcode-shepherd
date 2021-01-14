package io.github.xinshepherd;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 1018. 可被 5 整除的二进制前缀
 *
 * https://leetcode-cn.com/problems/binary-prefix-divisible-by-5/
 *
 * @author Fuxin
 * @since 2021/1/14
 */
public class PrefixesDivBy5 {

    public List<Boolean> prefixesDivBy5(int[] A) {
        int remainder = 0;
        Boolean[] ans = new Boolean[A.length];
        for (int i = 0, aLength = A.length; i < aLength; i++) {
            int a = A[i];
            int current = (remainder << 1) + a;
            remainder = current % 5;
            ans[i] = remainder == 0;
        }
        return Arrays.asList(ans);
    }

    public static void main(String[] args) {
        PrefixesDivBy5 divBy5 = new PrefixesDivBy5();
        assertThat(divBy5.prefixesDivBy5(new int[]{0, 1, 1})).isEqualTo(Arrays.asList(true, false, false));
        assertThat(divBy5.prefixesDivBy5(new int[]{1, 1, 1})).isEqualTo(Arrays.asList(false, false, false));
        assertThat(divBy5.prefixesDivBy5(new int[]{0, 1, 1, 1, 1, 1})).isEqualTo(Arrays.asList(true, false, false, false, true, false));
        assertThat(divBy5.prefixesDivBy5(new int[]{1, 1, 1, 0, 1})).isEqualTo(Arrays.asList(false, false, false, false, false));
    }

}
