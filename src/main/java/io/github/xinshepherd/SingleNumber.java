package io.github.xinshepherd;

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
        System.out.println(singleNumber.singleNumber(new int[]{2, 2, 1}));
        System.out.println(singleNumber.singleNumber(new int[]{4,1,2,1,2}));
    }

}
