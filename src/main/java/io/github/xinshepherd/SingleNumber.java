package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * 136. 只出现一次的数字
 *
 * @author Fuxin
 * @since 2020/2/26 11:36
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        Assertions.assertThat(singleNumber.singleNumber(new int[]{2, 2, 1})).isEqualTo(1);
        Assertions.assertThat(singleNumber.singleNumber(new int[]{4,1,2,1,2})).isEqualTo(4);
    }

}
