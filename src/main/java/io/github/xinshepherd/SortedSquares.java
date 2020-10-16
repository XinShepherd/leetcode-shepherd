package io.github.xinshepherd;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 977. 有序数组的平方
 *
 * @author Fuxin
 * @since 2020/10/16
 */
public class SortedSquares {

    public int[] sortedSquares(int[] A) {
        int len = A.length;
        int index = -1; // 分割点
        for (int i = 0; i < len; i++) {
            if (index == -1 && A[i] >= 0) {
                index = i;
            }
            A[i] = A[i] * A[i];
        }
        int[] ans = new int[len];
        int k = 0;
        int i = index == -1 ? len : index, j = i - 1;
        while (i < len && j >=0) {
            if (A[i] < A[j]) {
                ans[k++] = A[i++];
            } else {
                ans[k++] = A[j--];
            }
        }
        while (i < len) {
            ans[k++] = A[i++];
        }
        while (j >= 0) {
            ans[k++] = A[j--];
        }
        return ans;
    }

    public int[] sortedSquares2(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }

    public static void main(String[] args) {
        SortedSquares sortedSquares = new SortedSquares();
        assertThat(sortedSquares.sortedSquares(new int[]{-4, -1, 0, 3, 10})).isEqualTo(new int[]{0, 1, 9, 16, 100});
        assertThat(sortedSquares.sortedSquares(new int[]{-4, -1})).isEqualTo(new int[]{1, 16});
        assertThat(sortedSquares.sortedSquares(new int[]{-1})).isEqualTo(new int[]{1});
    }
}
