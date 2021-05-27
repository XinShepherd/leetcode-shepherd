package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * 461. 汉明距离
 *
 * https://leetcode-cn.com/problems/hamming-distance/
 *
 * @author Fuxin
 * @since 2021/5/27
 */
public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int[] xBinary = getBinary(x);
        int[] yBinary = getBinary(y);
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (xBinary[i] != yBinary[i]) {
                ans++;
            }
        }
        return ans;
    }

    private int[] getBinary(int num) {
        int[] binary = new int[32];
        int i = 0;
        while (num > 0) {
            binary[i] = num % 2;
            num /= 2;
            i++;
        }
        return binary;
    }

    public int hammingDistance2(int x, int y) {
        int temp = x;
        if (x < y) {
            x = y;
            y = temp;
        }
        int ans = 0;
        while (x > 0) {
            int xBit = x % 2;
            int yBit = y % 2;
            if (xBit != yBit) {
                ans++;
            }
            x /= 2;
            if (y > 0) {
                y /= 2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        HammingDistance hammingDistance = new HammingDistance();
        Assertions.assertThat(hammingDistance.hammingDistance(1, 4)).isEqualTo(2);
        Assertions.assertThat(hammingDistance.hammingDistance2(1, 4)).isEqualTo(2);
    }

}
