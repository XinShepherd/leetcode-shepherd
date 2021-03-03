package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 338. 比特位计数
 * <p>
 * https://leetcode-cn.com/problems/counting-bits/
 *
 * @author Fuxin
 * @since 2021/3/3
 */
public class CountBits {

    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int c = 0;
            int n = i;
            while (n > 0) {
                c++;
                n &= (n - 1);
            }
            ans[i] = c;
        }
        return ans;
    }

    public static void main(String[] args) {
        CountBits countBits = new CountBits();
        assertThat(countBits.countBits(2)).isEqualTo(new int[]{0, 1, 1});
        assertThat(countBits.countBits(5)).isEqualTo(new int[]{0, 1, 1, 2, 1, 2});
    }

}
