package io.github.xinshepherd;

/**
 * 面试题56 - I. 数组中数字出现的次数
 *
 * @author Fuxin
 * @since 2020/4/28
 */
public class SingleTwoNumbers {

    public int[] singleNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        int div = 1;
        while ((div & res) == 0) {
            div <<= 1;
        }

        int a = 0, b = 0;
        for (int num : nums) {
            if ((div & num) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }

        }
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        SingleTwoNumbers numbers = new SingleTwoNumbers();
        Util.printArray(numbers.singleNumbers(new int[]{4, 1, 4, 6}));
        Util.printArray(numbers.singleNumbers(new int[]{1, 2, 10, 4, 1, 4, 3, 3}));
    }

}
