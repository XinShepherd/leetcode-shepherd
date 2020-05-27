package io.github.xinshepherd;

/**
 * 283. 移动零
 * https://leetcode-cn.com/problems/move-zeroes
 *
 * @author Fuxin
 * @since 2020/5/27
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        for (int i = 0, j = i + 1; i < nums.length && j < nums.length; i++) {
            if (nums[i] == 0) {
                if (j <= i)
                    j = i + 1;
                while (j < nums.length && nums[j] == 0) {
                    j++;
                }
                if (j == nums.length)
                    return;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] ints = {0, 1, 0, 3, 12};
        moveZeroes.moveZeroes(ints);
        Util.printArray(ints);

    }

}
