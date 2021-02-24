package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 766. 托普利茨矩阵
 * <p>
 * https://leetcode-cn.com/problems/toeplitz-matrix/
 *
 * @author Fuxin
 * @since 2021/2/22
 */
public class ToeplitzMatrix {

    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < n - 1; i++) {
            if (isInvalid(matrix, 0, i))
                return false;
        }
        for (int i = 1; i < m - 1; i++) {
            if (isInvalid(matrix, i, 0))
                return false;
        }
        return true;
    }

    private boolean isInvalid(int[][] matrix, int x, int y) {
        int m = matrix.length;
        int n = matrix[0].length;
        int target = matrix[x][y];
        while (x < m && y < n) {
            if (matrix[x][y] != target)
                return true;
            x++;
            y++;
        }
        return false;
    }

    public boolean isToeplitzMatrix2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ToeplitzMatrix toeplitzMatrix = new ToeplitzMatrix();
        assertThat(toeplitzMatrix.isToeplitzMatrix(new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{5, 1, 2, 3},
                new int[]{9, 5, 1, 2}
        })).isTrue();
        assertThat(toeplitzMatrix.isToeplitzMatrix(new int[][]{
                new int[]{1, 2},
                new int[]{2, 2}
        })).isFalse();
        assertThat(toeplitzMatrix.isToeplitzMatrix2(new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{5, 1, 2, 3},
                new int[]{9, 5, 1, 2}
        })).isTrue();
        assertThat(toeplitzMatrix.isToeplitzMatrix2(new int[][]{
                new int[]{1, 2},
                new int[]{2, 2}
        })).isFalse();

    }

}
