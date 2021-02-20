package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 697. 数组的度
 * <p>
 * https://leetcode-cn.com/problems/degree-of-an-array/
 *
 * @author Fuxin
 * @since 2021/2/20
 */
public class FindShortestSubArray {

    public int findShortestSubArray(int[] nums) {
        int length = nums.length;
        Number[] data = new Number[50000];
        int maxCount = 0;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            Number number = data[num];
            if (number == null) {
                number = new Number();
                number.count = 1;
                number.start = i;
                number.end = i;
                data[num] = number;
            } else {
                number.count++;
                number.end = i;
            }
            if (number.count > maxCount) {
                maxCount = number.count;
            }
        }
        int minSub = Integer.MAX_VALUE;
        for (int num : nums) {
            Number value = data[num];
            if (value.count == maxCount) {
                minSub = Math.min(minSub, value.end - value.start + 1);
            }
        }
        return minSub;
    }

    static class Number {
        int count;
        int start;
        int end;
    }

    public int findShortestSubArray2(int[] nums) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i : nums) {
            max = Math.max(i, max);
            min = Math.min(i, min);
        }
        int[] contnums = new int[max - min + 1];
        int degree = 0;
        for (int i : nums) {
            degree = Math.max(degree, ++contnums[i - min]);
        }
        if (degree == 1) return 1;
        int result = nums.length;
        for (int i = 0; i < contnums.length; i++) {
            if (contnums[i] == degree) {
                int tmp = min + i;
                int start = 0, end = nums.length - 1;
                while (start < end && nums[start] != tmp) {
                    start++;
                }
                while (start < end && nums[end] != tmp) {
                    end--;
                }
                result = Math.min(result, end - start + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindShortestSubArray findShortestSubArray = new FindShortestSubArray();
        assertThat(findShortestSubArray.findShortestSubArray(new int[]{1, 2, 2, 3, 1})).isEqualTo(2);
        assertThat(findShortestSubArray.findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2})).isEqualTo(6);
        assertThat(findShortestSubArray.findShortestSubArray2(new int[]{1, 2, 2, 3, 1})).isEqualTo(2);
        assertThat(findShortestSubArray.findShortestSubArray2(new int[]{1, 2, 2, 3, 1, 4, 2})).isEqualTo(6);
    }

}
