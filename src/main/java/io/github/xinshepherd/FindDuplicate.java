package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 287. 寻找重复数
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 *
 * @author Fuxin
 * @since 2020/5/26
 */
public class FindDuplicate {

    // 二分法 O(nlogn)
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int l = 1, r = n - 1;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt += 1;
                }
            }
            if (cnt <= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindDuplicate findDuplicate = new FindDuplicate();
        assertThat(findDuplicate.findDuplicate(new int[]{1, 3, 4, 2, 2})).isEqualTo(2);
        assertThat(findDuplicate.findDuplicate(new int[]{3, 1, 3, 4, 2})).isEqualTo(3);
    }

}
