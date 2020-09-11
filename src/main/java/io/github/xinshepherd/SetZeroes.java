package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 73. 矩阵置零
 * <p>
 * https://leetcode-cn.com/problems/set-matrix-zeroes/
 *
 * @author Fuxin
 * @since 2020/9/10
 */
public class SetZeroes {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return;
        }
        int n = matrix[0].length;
        int[] mIndex = new int[m];
        int[] nIndex = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    mIndex[i] = 1;
                    nIndex[j] = 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (nIndex[i] == 1) {
                for (int k = 0; k < m; k++) {
                    matrix[k][i] = 0;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (mIndex[i] == 1) {
                for (int k = 0; k < n; k++) {
                    matrix[i][k] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        SetZeroes zeroes = new SetZeroes();
        int[][] matrix = {
                new int[]{1, 1, 1},
                new int[]{1, 0, 1},
                new int[]{1, 1, 1}
        };
        zeroes.setZeroes(matrix);
        assertThat(matrix).isEqualTo(new int[][]{
                new int[]{1, 0, 1},
                new int[]{0, 0, 0},
                new int[]{1, 0, 1}
        });

        matrix = new int[][]{
                new int[]{0, 1, 2, 0},
                new int[]{3, 4, 5, 2},
                new int[]{1, 3, 1, 5}
        };
        zeroes.setZeroes(matrix);
        assertThat(matrix).isEqualTo(new int[][]{
                new int[]{0, 0, 0, 0},
                new int[]{0, 4, 5, 0},
                new int[]{0, 3, 1, 0}
        });
    }

}
