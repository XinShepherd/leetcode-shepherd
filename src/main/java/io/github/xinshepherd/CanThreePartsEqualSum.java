package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * 1013. 将数组分成和相等的三个部分
 *
 * @author Fuxin
 * @since 2020/3/11 9:11
 */
public class CanThreePartsEqualSum {

    public boolean canThreePartsEqualSum(int[] A) {
        int total = 0;
        for (int value : A) {
            total += value;
        }
        if (total % 3 != 0)
            return false;
        int segmentSum = total / 3;
        int index = 0;
        for (int i = 0; i < 3; i++) {
            index = helper(A, index, segmentSum);
            if (index == -1)
                return false;
        }
        return true;
    }

    int helper(int[] A, int index, int segmentSum) {
        int sum = 0;
        for (; index < A.length; index++) {
            sum += A[index];
            if (sum == segmentSum) {
                return index + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        CanThreePartsEqualSum canThreePartsEqualSum = new CanThreePartsEqualSum();
        Assertions.assertThat(canThreePartsEqualSum.canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1})).isTrue();
        Assertions.assertThat(canThreePartsEqualSum.canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1})).isFalse();
        Assertions.assertThat(canThreePartsEqualSum.canThreePartsEqualSum(new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4})).isTrue();
    }

}
