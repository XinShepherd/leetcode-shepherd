package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 922. 按奇偶排序数组 II
 *
 * https://leetcode-cn.com/problems/sort-array-by-parity-ii/
 *
 * @author Fuxin
 * @since 2020/11/12
 */
public class SortArrayByParityII {

    public int[] sortArrayByParityII(int[] A) {
        int len = A.length;
        int i = 0, j = len -1;
        while (i < len && j >= 0) {
            // odd
            while (i < len && (i % 2 != 0 || A[i] % 2 == 0)) {
                i++;
            }
            while (j >= 0 && (j % 2 == 0 || A[j] % 2 != 0)) {
                j--;
            }
            if (i < len && j >= 0) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        SortArrayByParityII sortArrayByParityII = new SortArrayByParityII();
        assertThat(sortArrayByParityII.sortArrayByParityII(new int[]{4, 2, 5, 7})).isEqualTo(new int[]{4, 5, 2, 7});
    }

}
