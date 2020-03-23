package io.github.xinshepherd;

/**
 * 59. 螺旋矩阵 II
 *
 * @author Fuxin
 * @since 2020/3/23 9:11
 */
public class GenerateMatrix {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int counter = 1;
        for (int start = 0, end = n - 1; start <= end; start++, end--) {
            if (start == end) {
                matrix[start][end] = counter;
                break;
            }
            int len = end - start;

            for (int i = 0; i <= len; i++) {
                matrix[start][start + i] = counter++;
            }

            for (int i = 1; i <= len; i++) {
                matrix[start + i][end] = counter++;
            }

            for (int i = 1; i <= len; i++) {
                matrix[end][end - i] = counter++;
            }

            for (int i = 1; i < len; i++) {
                matrix[end - i][start] = counter++;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        GenerateMatrix generateMatrix = new GenerateMatrix();
        Util.printTwoDimensionalArray(generateMatrix.generateMatrix(1));
        Util.printTwoDimensionalArray(generateMatrix.generateMatrix(2));
        Util.printTwoDimensionalArray(generateMatrix.generateMatrix(3));
        Util.printTwoDimensionalArray(generateMatrix.generateMatrix(4));

    }

}
