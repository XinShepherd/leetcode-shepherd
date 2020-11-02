package io.github.xinshepherd;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 349. 两个数组的交集
 *
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 *
 * @author Fuxin
 * @since 2020/11/2
 */
public class Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            set2.add(num);
        }
        set1.retainAll(set2);
        int[] ans = new int[set1.size()];
        int i = 0;
        for (Integer num : set1) {
            ans[i++] = num;
        }
        return ans;
    }

    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        assertThat(intersection.intersection(new int[]{1, 2, 2, 1}, new int[]{2})).isEqualTo(new int[]{2});
        assertThat(intersection.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})).containsExactlyInAnyOrder(9, 4);

    }


}
