package io.github.xinshepherd;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 542. 01 矩阵
 *
 * @author Fuxin
 * @since 2020/4/15
 */
public class UpdateMatrix {

    int[] nr = {0, -1, 0, 1};
    int[] nc = {-1, 0, 1, 0};

    public int[][] updateMatrix(int[][] matrix) {
        int rLen = matrix.length, cLen = matrix[0].length;
        int len = Math.max(rLen, cLen);
        Deque<Integer> queue = new LinkedList<>();
        int[][] ans = new int[rLen][cLen];
        for (int[] an : ans) {
            Arrays.fill(an, -1);
        }
        for (int i = 0; i < rLen; i++) {
            for (int j = 0; j < cLen; j++) {
                if (matrix[i][j] == 0) {
                    ans[i][j] = 0;
                    int code = i * len + j;
                    queue.addLast(code);
                }
            }
        }
        while (!queue.isEmpty()) {
            int code = queue.pollFirst();
            int dr = code / len;
            int dc = code % len;
            for (int i = 0; i < 4; i++) {
                int r = nr[i] + dr;
                int c = nc[i] + dc;
                if (r >= 0 && r < rLen && c >= 0 && c < cLen && ans[r][c] == -1) {
                    ans[r][c] = ans[dr][dc] + 1;
                    queue.addLast(r * len + c);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        UpdateMatrix updateMatrix = new UpdateMatrix();
        Util.printTwoDimensionalArray(updateMatrix.updateMatrix(new int[][]{
                new int[]{0, 0, 0},
                new int[]{0, 1, 0},
                new int[]{0, 0, 0}
        }));

        Util.printTwoDimensionalArray(updateMatrix.updateMatrix(new int[][]{
                new int[]{0, 0, 0},
                new int[]{0, 1, 0},
                new int[]{1, 1, 1}
        }));
    }

}
