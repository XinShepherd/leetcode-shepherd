package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 867. 转置矩阵
 *
 * https://leetcode-cn.com/problems/transpose-matrix/
 *
 * @author Fuxin
 * @since 2021/2/25
 */
public class Transpose {

    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] ans = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][i] = matrix[i][j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Transpose transpose = new Transpose();
        assertThat(transpose.transpose(new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        })).isEqualTo(new int[][]{
                new int[]{1, 4, 7},
                new int[]{2, 5, 8},
                new int[]{3, 6, 9}
        });
        assertThat(transpose.transpose(new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6}
        })).isEqualTo(new int[][]{
                new int[]{1, 4},
                new int[]{2, 5},
                new int[]{3, 6}
        });

    }

}
