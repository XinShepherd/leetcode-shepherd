package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * 55. 跳跃游戏
 * https://leetcode-cn.com/problems/jump-game/
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
        Assertions.assertThat(canJump.canJump(new int[]{2, 3, 1, 1, 4})).isTrue();
        Assertions.assertThat(canJump.canJump(new int[]{3, 2, 1, 0, 4})).isFalse();
        Assertions.assertThat(canJump.canJump(new int[]{1, 2, 3})).isTrue();
    }

}
