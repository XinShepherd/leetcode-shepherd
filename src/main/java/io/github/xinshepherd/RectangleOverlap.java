package io.github.xinshepherd;

/**
 * 836. 矩形重叠
 *
 * @author Fuxin
 * @since 2020/3/18 8:51
 */
public class RectangleOverlap {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int xlen = rec2[2] - rec2[0];
        int ylen = rec2[3] - rec2[1];


        long[] border = new long[4];
        border[0] = (long) rec1[0] - xlen;
        border[1] = (long) rec1[1] - ylen;
        border[2] = (long) rec1[2] + xlen;
        border[3] = (long) rec1[3] + ylen;

        return isOverlap(border, rec2[0], rec2[1])
                && isOverlap(border, rec2[2], rec2[3])
                && isOverlap(border, rec2[0], rec2[3])
                && isOverlap(border, rec2[2], rec2[1]);

    }

    boolean isOverlap(long[] rec, int x, int y) {
        return x > rec[0] && x < rec[2] && y > rec[1] && y < rec[3];
    }

    // 降维判断重叠
    boolean helper(int[] rec1, int[] rec2) {
        boolean x_overlap = !(rec1[2] <= rec2[0] || rec2[2] <= rec1[0]);
        boolean y_overlap = !(rec1[3] <= rec2[1] || rec2[3] <= rec1[1]);
        return x_overlap && y_overlap;
    }

    public static void main(String[] args) {
        RectangleOverlap rectangleOverlap = new RectangleOverlap();
        System.out.println(rectangleOverlap.isRectangleOverlap(new int[]{0, 0, 2, 2}, new int[]{1, 1, 3, 3}));
        System.out.println(rectangleOverlap.isRectangleOverlap(new int[]{0, 0, 1, 1}, new int[]{1, 0, 2, 1}));
        System.out.println(rectangleOverlap.isRectangleOverlap(new int[]{7, 8, 13, 15}, new int[]{10, 8, 12, 20}));
    }

}
