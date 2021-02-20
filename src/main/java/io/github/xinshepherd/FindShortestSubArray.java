package io.github.xinshepherd;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 697. 数组的度
 *
 * https://leetcode-cn.com/problems/degree-of-an-array/
 *
 * @author Fuxin
 * @since 2021/2/20
 */
public class FindShortestSubArray {

    public int findShortestSubArray(int[] nums) {
        int length = nums.length;
        Map<Integer, Number> map = new HashMap<>(length);
        int maxCount = 0;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            Number number = map.get(num);
            if (number == null) {
                number = new Number();
                number.num = num;
                number.count = 1;
                number.start = i;
                number.end = i;
                map.put(num, number);
            } else {
                number.count++;
                number.end = i;
            }
            if (number.count > maxCount) {
                maxCount = number.count;
            }
        }
        int minSub = Integer.MAX_VALUE;
        for (Number value : map.values()) {
            if (value.count == maxCount) {
                minSub = Math.min(minSub, value.end - value.start + 1);
            }
        }
        return minSub;
    }

    static class Number {
        int num;
        int count;
        int start;
        int end;
    }

    public static void main(String[] args) {
        FindShortestSubArray findShortestSubArray = new FindShortestSubArray();
        assertThat(findShortestSubArray.findShortestSubArray(new int[]{1, 2, 2, 3, 1})).isEqualTo(2);
        assertThat(findShortestSubArray.findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2})).isEqualTo(6);
    }

}
