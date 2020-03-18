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
        // 解题思路：
        // 从最外圈逐渐向内旋转
        for (; start < end; start++, end--) {
            int len = end - start;
            // 一圈内，从横线的第一个点开始旋转
            // 直至到达一条线上的最后一个点（不包括最后一个点，因为最后一个点也是另外一条线上的第一个点）
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
