package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 941. 有效的山脉数组
 *
 * https://leetcode-cn.com/problems/valid-mountain-array/
 *
 * @author Fuxin
 * @since 2020/11/3
 */
public class ValidMountainArray {

    public boolean validMountainArray(int[] A) {
        if (A.length < 3)
            return false;
        int cur = -1;
        int count = 0;
        int i = 0;
        for (; i < A.length; i++) {
            if (A[i] == cur) {
                return false;
            }
            if (A[i] < cur)
                break;
            count++;
            cur = A[i];
        }
        if (count < 2)
            return false;
        count = 0;
        while (i < A.length) {
            if (A[i] >= cur)
                return false;
            cur = A[i];
            i++;
            count++;
        }
        return count > 0;
    }

    public static void main(String[] args) {
        ValidMountainArray validMountainArray = new ValidMountainArray();

        assertThat(validMountainArray.validMountainArray(new int[]{2, 1})).isFalse();
        assertThat(validMountainArray.validMountainArray(new int[]{3, 5, 5})).isFalse();
        assertThat(validMountainArray.validMountainArray(new int[]{0, 3, 2, 1})).isTrue();
        assertThat(validMountainArray.validMountainArray(new int[]{1, 3, 2})).isTrue();

    }


}
