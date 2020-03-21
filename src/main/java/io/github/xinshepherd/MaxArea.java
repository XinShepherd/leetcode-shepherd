package io.github.xinshepherd;

/**
 * @author Fuxin
 * @since 2020/3/21
 */
public class MaxArea {

    public int maxArea(int[] height) {
        int max = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int h = Math.min(height[i], height[j]);
                int area = (j - i) * h;
                if (area > max) {
                    max = area;
                }
            }
        }
        return max;
    }

    public int onceLoop(int[] height) {
        int max = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            int h;
            int len = j - i;
            if (height[i] < height[j]) {
                h = height[i++];
            } else {
                h = height[j--];
            }
            int area = h * len;
            if (area > max) {
                max = area;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxArea maxArea = new MaxArea();
        System.out.println(maxArea.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea.onceLoop(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
