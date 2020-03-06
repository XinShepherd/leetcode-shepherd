package io.github.xinshepherd;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Fuxin
 * @since 2020/3/6 8:57
 */
public class FindContinuousSequence {

    // 暴力破解
    public int[][] findContinuousSequence(int target) {
        List<int[]> results = new ArrayList<>();
        int half = (target + 1) / 2;
        for (int i = half; i > 1; i--) {
            for (int j = 1; j < half; j++) {
                int upper = j + i - 1;
                int sum = (j + upper) * i / 2;
                if (sum == target) {
                    int[] result = new int[i];
                    for (int k = 0; k < i; k++) {
                        result[k] = j++;
                    }
                    results.add(result);
                    break;
                }
                if (sum > target) {
                    break;
                }
            }
        }
        return results.toArray(new int[results.size()][]);
    }

    // 滑动窗口
    public int[][] findContinuousSequence2(int target) {
        int i = 1; // 滑动窗口的左边界
        int j = 1; // 滑动窗口的右边界
        int sum = 0; // 滑动窗口中数字的和
        List<int[]> res = new ArrayList<>();

        while (i <= target / 2) {
            if (sum < target) {
                // 右边界向右移动
                sum += j;
                j++;
            } else if (sum > target) {
                // 左边界向右移动
                sum -= i;
                i++;
            } else {
                // 记录结果
                int[] arr = new int[j-i];
                for (int k = i; k < j; k++) {
                    arr[k-i] = k;
                }
                res.add(arr);
                // 左边界向右移动
                sum -= i;
                i++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        FindContinuousSequence findContinuousSequence = new FindContinuousSequence();
        int[][] results = findContinuousSequence.findContinuousSequence2(3);
        Util.printTwoDimensionalArray(results);
        Util.printTwoDimensionalArray(findContinuousSequence.findContinuousSequence2(9));
        Util.printTwoDimensionalArray(findContinuousSequence.findContinuousSequence2(15));
    }

}
