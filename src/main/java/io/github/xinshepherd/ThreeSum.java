package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

import java.util.*;

/**
 * 15. 三数之和
 *
 * @author Fuxin
 * @since 2020/3/10 9:52
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3)
            return Collections.emptyList();
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        if (nums[0] <= 0 && nums[nums.length - 1] >= 0) {
            for (int i = 0; i < nums.length - 2;) {
                if (nums[i] > 0) break;
                int first = i + 1;
                int last = nums.length - 1;
                do {
                    if (first >= last && nums[i] * nums[last] > 0) break;
                    int result = nums[i] + nums[first] + nums[last];
                    if (result == 0) {
                        results.add(Arrays.asList(nums[i], nums[first], nums[last]));
                    }
                    if (result <= 0) {
                        while (first < last && nums[first] == nums[++first]) ;
                    } else {
                        while (first < last && nums[last] == nums[--last]);

                    }
                } while (first < last);
                while (i + 1 < nums.length && nums[i] == nums[++i]) ;
            }
        }
        return results;
    }

    // 比较暴力 O(n2)
    public List<List<Integer>> threeSum2(int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int sum = -nums[i];
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < length; j++) {
                int sub = sum - nums[j];
                if (set.contains(sub)) {
                    List<Integer> list = Arrays.asList(nums[i], nums[j], sub);
                    Collections.sort(list);
                    if (!result.contains(list))
                        result.add(list);
                } else {
                    set.add(nums[j]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        Assertions.assertThat(threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4})).hasSameElementsAs(Arrays.asList(
                Arrays.asList(-1, -1, 2),
                Arrays.asList(-1, 0, 1)
        ));
        Assertions.assertThat(threeSum.threeSum2(new int[]{-1, 0, 1, 2, -1, -4})).hasSameElementsAs(Arrays.asList(
                Arrays.asList(-1, -1, 2),
                Arrays.asList(-1, 0, 1)
        ));
    }

}
