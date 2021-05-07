package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * 1486. 数组异或操作
 *
 * https://leetcode-cn.com/problems/xor-operation-in-an-array/
 *
 * @author Fuxin
 * @since 2021/5/7
 */
public class XorOperation {

    public int xorOperation(int n, int start) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans ^= start + (i << 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        XorOperation xorOperation = new XorOperation();
        Assertions.assertThat(xorOperation.xorOperation(5, 0)).isEqualTo(8);
        Assertions.assertThat(xorOperation.xorOperation(4, 3)).isEqualTo(8);
        Assertions.assertThat(xorOperation.xorOperation(1, 7)).isEqualTo(7);
        Assertions.assertThat(xorOperation.xorOperation(10, 5)).isEqualTo(2);

    }

}
