package io.github.xinshepherd.sort;

import static org.assertj.core.api.Assertions.assertThat;

public class QuickSort {

    public void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    void quickSort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = getPivot(A, start, end);
        quickSort(A, start, pivot - 1);
        quickSort(A, pivot + 1, end);
    }

    int getPivot(int[] A, int start, int end) {
        int pivot = A[start];
        int i = start, j = end;
        for (; i < j;) {
            // 注意：先从后面开始往前移
            while (i < j && A[j] >= pivot) {
                j--;
            }
            while (i < j && A[i] <= pivot) {
                i++;
            }
            if (i < j) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        A[start] = A[i];
        A[i] = pivot;
        return i;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] A = {3, 1, 4, 2, 5};
        quickSort.sort(A);
        assertThat(A).isEqualTo(new int[]{1, 2, 3, 4, 5});
    }

}
