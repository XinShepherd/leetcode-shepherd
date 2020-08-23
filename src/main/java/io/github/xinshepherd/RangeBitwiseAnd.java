package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 201. 数字范围按位与
 * https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/
 *
 * @author Fuxin
 * @since 2020/8/23
 */
public class RangeBitwiseAnd {

    // 正常思路
    public int rangeBitwiseAnd(int m, int n) {
        if (m == n)
            return m;
        int[] mBits = getBits(m);
        int[] nBits = getBits(n);
        int count = 0;
        int i = 31;
        boolean flag = false;
        for (; i >= 0; i--) {
            if (mBits[i] != nBits[i])
                break;
            if (mBits[i] == 1 && mBits[i] == nBits[i]) {
                flag = true;
            }
            if (flag && mBits[i] == nBits[i]) {
                count++;
            }
        }
        if (count == 0)
            return 0;
        int ans = 1;
        for (int j = i + count - 1; j > i; j--) {
            ans <<= 1;
            ans += mBits[j];
        }
        ans <<= (i + 1);
        return ans;
    }

    static int[] getBits(int num) {
        int[] bits = new int[32];
        int i = 0;
        while (num != 0 && i < 32) {
            bits[i++] = num % 2;
            num >>= 1;
        }
        return bits;
    }

    // 突发奇想
    public int rangeBitwiseAnd2(int m, int n) {
        if (m == n)
            return m;
        int remain = m - n;

        int ans = m;
        ans &= remain;
        ans &= n;
        return ans;
    }

    public static void main(String[] args) {
        RangeBitwiseAnd rangeBitwiseAnd = new RangeBitwiseAnd();
        int[] bits = getBits(-5);
        System.out.println(2 & (-5 + 1));
        assertThat(rangeBitwiseAnd.rangeBitwiseAnd(5, 7)).isEqualTo(4);
        assertThat(rangeBitwiseAnd.rangeBitwiseAnd(0, 1)).isEqualTo(0);
        assertThat(rangeBitwiseAnd.rangeBitwiseAnd(1, 2)).isEqualTo(0);
        assertThat(rangeBitwiseAnd.rangeBitwiseAnd(3, 4)).isEqualTo(0);
        assertThat(rangeBitwiseAnd.rangeBitwiseAnd(5, 100)).isEqualTo(0);
        assertThat(rangeBitwiseAnd.rangeBitwiseAnd(6, 7)).isEqualTo(6);
        assertThat(rangeBitwiseAnd.rangeBitwiseAnd(4, 5)).isEqualTo(4);
        assertThat(rangeBitwiseAnd.rangeBitwiseAnd(10, 11)).isEqualTo(10);

        assertThat(rangeBitwiseAnd.rangeBitwiseAnd2(5, 7)).isEqualTo(4);
        assertThat(rangeBitwiseAnd.rangeBitwiseAnd2(0, 1)).isEqualTo(0);
        assertThat(rangeBitwiseAnd.rangeBitwiseAnd2(1, 2)).isEqualTo(0);
        assertThat(rangeBitwiseAnd.rangeBitwiseAnd2(3, 4)).isEqualTo(0);
        assertThat(rangeBitwiseAnd.rangeBitwiseAnd2(5, 100)).isEqualTo(0);
        assertThat(rangeBitwiseAnd.rangeBitwiseAnd2(6, 7)).isEqualTo(6);
        assertThat(rangeBitwiseAnd.rangeBitwiseAnd2(4, 5)).isEqualTo(4);
        assertThat(rangeBitwiseAnd.rangeBitwiseAnd2(10, 11)).isEqualTo(10);
        assertThat(rangeBitwiseAnd.rangeBitwiseAnd2(2, 7)).isEqualTo(0);
    }

}
