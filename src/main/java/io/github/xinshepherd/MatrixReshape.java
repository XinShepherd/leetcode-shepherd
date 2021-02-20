package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 566. 重塑矩阵
 *
 * https://leetcode-cn.com/problems/reshape-the-matrix/
 *
 * @author Fuxin
 * @since 2021/2/18
 */
public class MatrixReshape {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int col = nums[0].length;
        int size = row * col;
        if (size != r * c || r == row) {
            return nums;
        }
        int[][] ans = new int[r][c];
        int currentRow = 0, currentCol = 0;
        for (int[] num : nums) {
            for (int j = 0; j < col; j++) {
                if (currentCol == c) {
                    currentCol = 0;
                    currentRow++;
                }
                ans[currentRow][currentCol++] = num[j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MatrixReshape matrixReshape = new MatrixReshape();
        assertThat(matrixReshape.matrixReshape(new int[][]{
                new int[]{1, 2},
                new int[]{3, 4}
        }, 1, 4)).isEqualTo(new int[][]{new int[]{1, 2, 3, 4}});
    }

}
