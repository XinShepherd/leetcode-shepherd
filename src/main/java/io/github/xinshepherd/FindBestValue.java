package io.github.xinshepherd;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 1300. 转变数组后最接近目标值的数组和
 *
 * @author Fuxin
 * @since 2020/6/14
 */
public class FindBestValue {

    public int findBestValue(int[] arr, int target) {
        if (arr.length == 0)
            return 0;
        Arrays.sort(arr);
        int len = arr.length;
        int mid = target / len;
        int temp = target;
        if (arr[0] >= mid) {
            return getAns(mid, len, target);
        }
        for (int i = 0; i < len; i++) {
            int num = arr[i];
            if (num > mid) {
                mid = temp / (len - i);
                if (num >= mid)
                    return getAns(mid, len - i, temp);
            }
            temp -= num;
        }
        return arr[len - 1];
    }

    private int getAns(int mid, int len, int target) {
        if (Math.abs((mid + 1) * len - target) < Math.abs(mid * len - target))
            return mid + 1;
        return mid;
    }

    public int findBestValue2(int[] arr, int target) {
        if (arr.length == 0)
            return 0;
        List<Integer> nums = new ArrayList<>();
        for (int num : arr) {
            nums.add(num);
        }
        int len = arr.length;
        int mid = target / len;
        int temp = target;
        int maxNum = 0;
        while (!nums.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();
            for (int num : nums) {
                if (num > mid) {
                    tempList.add(num);
                } else {
                    temp -= num;
                    maxNum = Math.max(maxNum, num);
                }
            }
            if (tempList.isEmpty())
                break;
            mid = temp / tempList.size();
            // 表示所有数都大于 mid
            if (tempList.size() == nums.size())
                return getAns(mid, tempList.size(), temp);
            nums = tempList;
        }
        return maxNum;
    }

    public static void main(String[] args) {
        FindBestValue findBestValue = new FindBestValue();
        assertThat(findBestValue.findBestValue2(new int[]{4, 9, 3}, 10)).isEqualTo(3);
        assertThat(findBestValue.findBestValue2(new int[]{2, 3, 5}, 10)).isEqualTo(5);
        assertThat(findBestValue.findBestValue2(new int[]{2, 3, 4}, 10)).isEqualTo(4);
        assertThat(findBestValue.findBestValue2(new int[]{2, 3, 4, 5}, 12)).isEqualTo(3);
        assertThat(findBestValue.findBestValue2(new int[]{60864, 25176, 27249, 21296, 20204}, 56803)).isEqualTo(11361);
    }

}
