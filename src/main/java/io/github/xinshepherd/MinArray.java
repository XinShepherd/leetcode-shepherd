package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 *
 * @author Fuxin
 * @since 2020/7/22
 */
public class MinArray {

    public int minArray(int[] numbers) {
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
                break;
            }
        }
        return min;
    }

    // 二分查找
    public int minArray2(int[] numbers) {
        int len = numbers.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (numbers[mid] < numbers[right]) {
                right = mid;
            } else if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else {
                right--;
            }
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        MinArray minArray = new MinArray();
        assertThat(minArray.minArray2(new int[]{3, 4, 5, 1, 2})).isEqualTo(1);
        assertThat(minArray.minArray2(new int[]{2, 2, 2, 0, 1})).isEqualTo(0);
    }

}
