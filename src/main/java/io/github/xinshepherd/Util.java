package io.github.xinshepherd;

/**
 * @author Fuxin
 * @since 2020/3/6 9:10
 */
public abstract class Util {

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    public static void printArray(Object[] array) {
        for (Object i : array) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    public static void printTwoDimensionalArray(int[][] results) {
        System.out.println("[");
        for (int[] result : results) {
            printArray(result);
        }
        System.out.println("]");
    }
}
