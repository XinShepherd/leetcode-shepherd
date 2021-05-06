package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * 1720. 解码异或后的数组
 *
 * https://leetcode-cn.com/problems/decode-xored-array/
 *
 * @author Fuxin
 * @since 2021/5/6
 */
public class DecodeArray {

    public int[] decode(int[] encoded, int first) {
        int len = encoded.length + 1;
        int[] ans = new int[len];
        ans[0] = first;
        int prev = first;
        for (int i = 1; i < len; i++) {
            ans[i] = prev ^ encoded[i - 1];
            prev = ans[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        DecodeArray decodeArray = new DecodeArray();
        Assertions.assertThat(decodeArray.decode(new int[]{1, 2, 3}, 1)).isEqualTo(new int[]{1, 0, 2, 1});
    }
}
