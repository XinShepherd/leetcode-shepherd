package io.github.xinshepherd;

import java.util.Arrays;

/**
 * 945. 使数组唯一的最小增量
 *
 * @author Fuxin
 * @since 2020/3/22
 */
public class MinIncrementForUnique {

    public int minIncrementForUnique(int[] A) {
        if (A.length == 0 || A.length == 1) {
            return 0;
        }
        int increment = 0;
        Arrays.sort(A);
        int min = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] > min) {
                min = A[i];
                continue;
            }
            min++;
            increment += (min - A[i]);
        }
        return increment;
    }


    public static void main(String[] args) {
        MinIncrementForUnique unique = new MinIncrementForUnique();
        System.out.println(unique.minIncrementForUnique(new int[]{1, 2, 2}));
        System.out.println(unique.minIncrementForUnique(new int[]{3, 2, 1, 2, 1, 7}));
    }
}
