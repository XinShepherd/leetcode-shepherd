package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

import java.util.Arrays;

/**
 *
 * https://leetcode-cn.com/problems/3sum-closest/
 *
 * 16. 最接近的三数之和
 *
 * @author Fuxin
 * @since 2021/5/25
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int best = -1;
        for (int i = 0; i < n; i++) {
            // 相等则跳过重复计算
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target)
                    return target;
                if (Math.abs(target - sum) < min) {
                    min = Math.abs(target - sum);
                    best = sum;
                }
                if (sum < target) {
                    int j0 = j + 1;
                    while (j0 < k && nums[j0] == nums[j]) {
                        j0++;
                    }
                    j = j0;
                } else {
                    // 如果和大于 target，移动 c 对应的指针
                    int k0 = k - 1;
                    // 移动到下一个不相等的元素
                    while (j < k0 && nums[k0] == nums[k]) {
                        --k0;
                    }
                    k = k0;
                }
            }
        }
        return best;
    }

    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        Assertions.assertThat(threeSumClosest.threeSumClosest(new int[]{-1, 2, 1, -4}, 1)).isEqualTo(2);

    }

}
