package io.github.xinshepherd;

import static io.github.xinshepherd.Util.printTwoDimensionalArray;

/**
 * 48. 旋转图像
 *
 * @author Fuxin
 * @since 2020/3/18 11:36
 */
public class RotatePhoto {

    public void rotate(int[][] matrix) {
        int start = 0, end = matrix.length - 1;
        for (; start < end; start++, end--) {
            int len = end - start;
            for (int i = 0; i < len; i++) {
                int temp = matrix[start][start + i];
                matrix[start][start + i] = matrix[end - i][start];
                matrix[end - i][start] = matrix[end][end - i];
                matrix[end][end -i] = matrix[start + i][end];
                matrix[start + i][end] = temp;
            }
        }
    }

    public static void main(String[] args) {
        RotatePhoto rotatePhoto = new RotatePhoto();
        int[][] matrix = new int[][]{
                new int[]{5, 1, 9, 11},
                new int[]{2, 4, 8, 10},
                new int[]{13, 3, 6, 7},
                new int[]{15, 14, 12, 16}
        };
        rotatePhoto.rotate(matrix);
        printTwoDimensionalArray(matrix);

        matrix = new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        };
        rotatePhoto.rotate(matrix);
        printTwoDimensionalArray(matrix);

    }

}
