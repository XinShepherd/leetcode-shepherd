package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 861. 翻转矩阵后的得分
 *
 * https://leetcode-cn.com/problems/score-after-flipping-matrix/
 *
 * @author Fuxin
 * @since 2020/12/7
 */
public class MatrixScore {

    public int matrixScore(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int ans = row * (1 << (col - 1));
        for (int i = 1; i < col; i++) {
            int ones = 0;
            for (int j = 0; j < row; j++) {
                if (A[j][0] == 1) {
                    ones += A[j][i];
                } else {
                    ones += 1 - A[j][i];
                }
            }
            int k = Math.max(ones, row - ones);
            ans += k * (1 << col - i - 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        MatrixScore matrixScore = new MatrixScore();
        assertThat(matrixScore.matrixScore(new int[][]{
                new int[]{0,0,1,1},
                new int[]{1,0,1,0},
                new int[]{1,1,0,0}
        })).isEqualTo(39);
    }

}
