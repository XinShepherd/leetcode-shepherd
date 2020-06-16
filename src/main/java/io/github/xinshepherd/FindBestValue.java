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
        int len = arr.length;
        int mid = target / len;
        int temp = target;
        int maxNum = 0;
        while (len > 0) {
            int tempLen = len;
            for (int i = 0;  i < arr.length; i++) {
                int num = arr[i];
                if (num != -1 && num <= mid) {
                    temp -= num;
                    // 所有数都小于 mid 时返回 maxNum
                    maxNum = Math.max(maxNum, num);
                    len--;
                    // 表示已经访问过
                    arr[i] = -1;
                }
            }
            if (len == 0)
                break;
            mid = temp / len;
            // 表示所有数都大于 mid
            if (len == tempLen)
                return getAns(mid, len, temp);
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
