package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

import java.util.HashMap;
import java.util.Map;

// 169. 多数元素
public class MajorityElement {

    public int majorityElement(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length / 2;
        for (int num : nums) {
            Integer integer = map.get(num);
            if (integer == null) {
                map.put(num, 1);
            } else {
                integer++;
                if (integer > len)
                    return num;
                map.put(num, integer);
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        MajorityElement element = new MajorityElement();
        Assertions.assertThat(element.majorityElement(new int[]{3, 2, 3})).isEqualTo(3);
        Assertions.assertThat(element.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2})).isEqualTo(2);
    }


}
