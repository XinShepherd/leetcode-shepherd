package io.github.xinshepherd;

/**
 * 55. 跳跃游戏
 *
 * @author Fuxin
 * @since 2020/4/17
 */
public class CanJump {


    public boolean canJump(int[] nums) {
        if (nums.length <= 1)
            return true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == 0) {
                break;
            }
            nums[i] = Math.max(nums[i], nums[i - 1] - 1);
            if (nums[i] + i >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        CanJump canJump = new CanJump();
        System.out.println(canJump.canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(canJump.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump.canJump(new int[]{1, 2, 3}));

    }

}
