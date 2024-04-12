package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * 137. 只出现一次的数字 II
 *
 * @author Fuxin
 * @since 2020/4/27
 */
public class SingleNumberII {

    public int singleNumber(int[] nums) {
        int seenOnce = 0, seenTwice = 0;

        // 交换律
        for (int num : nums) {
            // first appearence:
            // add num to seen_once
            // don't add to seen_twice because of presence in seen_once

            // second appearance:
            // remove num from seen_once
            // add num to seen_twice

            // third appearance:
            // don't add to seen_once because of presence in seen_twice
            // remove num from seen_twice
            seenOnce = ~seenTwice & (seenOnce ^ num);
            seenTwice = ~seenOnce & (seenTwice ^ num);
        }

        return seenOnce;

    }

    public static void main(String[] args) {
        SingleNumberII singleNumberII = new SingleNumberII();
        Assertions.assertThat(singleNumberII.singleNumber(new int[]{2, 3, 2, 2})).isEqualTo(3);

    }

}
